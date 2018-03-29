package org.usfirst.frc.team125.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.RobotMap;
import org.usfirst.frc.team125.robot.util.CurrentReader;
import org.usfirst.frc.team125.robot.util.DebouncedBoolean;

public class Intake extends Subsystem {

    //Intake motors
    private IMotorController intakeLeft = new VictorSPX(RobotMap.INTAKE_LEFT);
    private IMotorController intakeRight = new VictorSPX(RobotMap.INTAKE_RIGHT);

    private DoubleSolenoid intakeSolenoid = new DoubleSolenoid(RobotMap.INTAKE_RETRACT_FORWARD, RobotMap.INTAKE_RETRACT_REVERSE);

    private static final double minimumSmartIntakeTime = 0.4; // Is 2 seconds too long???
    private static final double minimumSmartIntakeTimeDouble = 0.2; // Is 2 seconds too long???

    private DigitalInput smartIntakeLeft = new DigitalInput(RobotMap.INTAKE_LIMIT_SWITCH_LEFT);
    private DigitalInput smartIntakeRight = new DigitalInput(RobotMap.INTAKE_LIMIT_SWITCH_RIGHT);
    private DebouncedBoolean smartIntakeDebouncerLeft = new DebouncedBoolean(minimumSmartIntakeTime);
    private DebouncedBoolean smartIntakeDebouncerRight = new DebouncedBoolean(minimumSmartIntakeTime);
    private DebouncedBoolean smartIntakeDebouncerDouble = new DebouncedBoolean(minimumSmartIntakeTimeDouble);

    private Ultrasonic ultraSmartIntakeLeft = new Ultrasonic(RobotMap.ULTRA_LEFT_TRIG, RobotMap.ULTRA_LEFT_ECHO);
    private Ultrasonic ultraSmartIntakeRight = new Ultrasonic(RobotMap.ULTRA_RIGHT_TRIG, RobotMap.ULTRA_RIGHT_ECHO);
    private DebouncedBoolean ultraSmartIntakeDebouncerLeft = new DebouncedBoolean(minimumSmartIntakeTime);
    private DebouncedBoolean ultraSmartIntakeDebouncerRight = new DebouncedBoolean(minimumSmartIntakeTime);
    private DebouncedBoolean ultraSmartIntakeDebouncerDouble = new DebouncedBoolean(minimumSmartIntakeTimeDouble);
    public final double LEFT_DISTANCE_MIN = 5.0;
    public final double RIGHT_DISTANCE_MIN = 5.0;

    public enum SmartIntakeState {
        LeftTriggered,
        RightTriggered,
        BothTriggered,
        NotTriggered,
    }

    public static final double INTAKE_POWER_LEFT = 1.0;
    public static final double INTAKE_POWER_RIGHT = 1.0;
    public static final double CURRENT_MAX = 110;

    public CurrentReader intakeCurrentReader = new CurrentReader();

    private static final DoubleSolenoid.Value INTAKE_FORWARD_VALUE = DoubleSolenoid.Value.kForward;
    private static final DoubleSolenoid.Value INTAKE_REVERSE_VALUE = DoubleSolenoid.Value.kReverse;

    private class SmartIntakeUpdater implements Runnable {
        int j = 0;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                checkSmartIntakeTriggered();
                checkUltraSmartIntakeTriggered();
                SmartDashboard.putNumber("j counter", j);
                j++;
            }
        }
    }

    public Intake() {
        Thread thread = new Thread(new Intake.SmartIntakeUpdater());
        thread.start();
        //Left side
        this.intakeLeft.configPeakOutputForward(INTAKE_POWER_LEFT, 0);
        this.intakeLeft.configPeakOutputReverse(-INTAKE_POWER_LEFT, 0);
        this.intakeLeft.configNominalOutputForward(0.0, 0);
        this.intakeLeft.configNominalOutputReverse(0.0, 0);

        //Right side
        this.intakeRight.configPeakOutputForward(INTAKE_POWER_RIGHT, 0);
        this.intakeRight.configPeakOutputReverse(-INTAKE_POWER_RIGHT, 0);
        this.intakeRight.configNominalOutputForward(0.0, 0);
        this.intakeRight.configNominalOutputReverse(0.0, 0);

        this.intakeLeft.setNeutralMode(NeutralMode.Coast);
        this.intakeRight.setNeutralMode(NeutralMode.Coast);

        ultraSmartIntakeLeft.setAutomaticMode(true);
        ultraSmartIntakeRight.setAutomaticMode(true);

        intakePistonUp(); // TODO: Check if this is right...
    }

    public void intake() {
        this.intakeLeft.set(ControlMode.PercentOutput, -INTAKE_POWER_LEFT);
        this.intakeRight.set(ControlMode.PercentOutput, INTAKE_POWER_RIGHT);
    }

    public void intakeLeftSide() {
        this.intakeLeft.set(ControlMode.PercentOutput, -INTAKE_POWER_LEFT);
    }

    public void intakeRightSide() {
        this.intakeRight.set(ControlMode.PercentOutput, INTAKE_POWER_RIGHT);
    }

    public void outtake() {
        this.intakeLeft.set(ControlMode.PercentOutput, INTAKE_POWER_LEFT);
        this.intakeRight.set(ControlMode.PercentOutput, -INTAKE_POWER_RIGHT);
    }

    public void stopIntake() {
        this.intakeLeft.set(ControlMode.PercentOutput, 0.);
        this.intakeRight.set(ControlMode.PercentOutput, 0.);
    }

    public boolean passedCurrentLimit() {
        double intakeCurrent = 0;
        intakeCurrent = this.intakeCurrentReader.getTotalCurrent(CurrentReader.CurrentPorts.Intake);
        SmartDashboard.putNumber("intakeCurrent", intakeCurrent);

        if (intakeCurrent > this.intakeCurrentReader.INTAKE_MAX_CURRENT) {
            this.intakeCurrentReader.currentCounter += 1;
        }
        return this.intakeCurrentReader.currentCounter > this.intakeCurrentReader.COUNTER_MAX ? true : false;
    }

    public int currentCounterReset() {
        return this.intakeCurrentReader.currentCounter = 0;
    }

    public boolean checkSmartIntakeTriggered() {
        smartIntakeDebouncerLeft.update(!smartIntakeLeft.get());
        smartIntakeDebouncerRight.update(!smartIntakeRight.get());
        smartIntakeDebouncerDouble.update(!smartIntakeLeft.get() && !smartIntakeRight.get());
        //Robot.ledController.setSmartIntakeTriggered(smartIntakeDebouncerLeft.get() || smartIntakeDebouncerRight.get());
        SmartDashboard.putBoolean("Smart intake left", smartIntakeLeft.get());
        SmartDashboard.putBoolean("Smart intake de-bouncer left", smartIntakeDebouncerLeft.get());
        SmartDashboard.putBoolean("Smart intake right", smartIntakeRight.get());
        SmartDashboard.putBoolean("Smart intake de-bouncer right", smartIntakeDebouncerRight.get());
        return (smartIntakeDebouncerLeft.get() || smartIntakeDebouncerRight.get())
                || (smartIntakeDebouncerDouble.get());
    }

    public SmartIntakeState getSmartIntakeState() {
        if(smartIntakeDebouncerDouble.get()) {
            return SmartIntakeState.BothTriggered;
        } else if (smartIntakeDebouncerLeft.get()) {
            return SmartIntakeState.LeftTriggered;
        } else if (smartIntakeDebouncerRight.get()) {
            return SmartIntakeState.RightTriggered;
        } else {
            return SmartIntakeState.NotTriggered;
        }
    }

    public double getUltraSmartIntakeLeftInches() {
        return ultraSmartIntakeLeft.getRangeInches();
    }

    public double getUltraSmartIntakeRightInches() {
        return ultraSmartIntakeRight.getRangeInches();
    }
    public boolean getUltraSmartIntakeLeftTriggered() {
        return getUltraSmartIntakeLeftInches() <= LEFT_DISTANCE_MIN;
    }

    public boolean getUltraSmartIntakeRightTriggered() {
        return getUltraSmartIntakeRightInches() <= RIGHT_DISTANCE_MIN;
    }

    public boolean checkUltraSmartIntakeTriggered() {
        ultraSmartIntakeDebouncerLeft.update(getUltraSmartIntakeLeftTriggered());
        ultraSmartIntakeDebouncerRight.update(getUltraSmartIntakeRightTriggered());
        ultraSmartIntakeDebouncerDouble.update(getUltraSmartIntakeLeftTriggered() && getUltraSmartIntakeRightTriggered());
        //Robot.ledController.setSmartIntakeTriggered(smartIntakeDebouncerLeft.get() || smartIntakeDebouncerRight.get());
        SmartDashboard.putBoolean("Ultra Smart intake left", getUltraSmartIntakeLeftTriggered());
        SmartDashboard.putBoolean("Ultra Smart intake de-bouncer left", ultraSmartIntakeDebouncerLeft.get());
        SmartDashboard.putBoolean("Ultra Smart intake right", getUltraSmartIntakeRightTriggered());
        SmartDashboard.putBoolean("Ultra Smart intake de-bouncer right", ultraSmartIntakeDebouncerRight.get());
        return (ultraSmartIntakeDebouncerLeft.get() || ultraSmartIntakeDebouncerRight.get())
                || (ultraSmartIntakeDebouncerDouble.get());
    }

    public SmartIntakeState getUltraSmartIntakeState() {
        if(ultraSmartIntakeDebouncerDouble.get()) {
            return SmartIntakeState.BothTriggered;
        } else if (ultraSmartIntakeDebouncerLeft.get()) {
            return SmartIntakeState.LeftTriggered;
        } else if (ultraSmartIntakeDebouncerRight.get()) {
            return SmartIntakeState.RightTriggered;
        } else {
            return SmartIntakeState.NotTriggered;
        }
    }

    public void intakePistonUp() {
        this.intakeSolenoid.set(INTAKE_REVERSE_VALUE);
    }

    public void intakePistonDown() {
        this.intakeSolenoid.set(INTAKE_FORWARD_VALUE);
    }

    public void toggleIntakePiston() {
        if (intakeSolenoid.get() == INTAKE_FORWARD_VALUE) {
            intakeSolenoid.set(INTAKE_REVERSE_VALUE);
        }
        if (intakeSolenoid.get() == INTAKE_REVERSE_VALUE) {
            intakeSolenoid.set(INTAKE_FORWARD_VALUE);
        }
    }

    @Override
    protected void initDefaultCommand() {
    }
}
