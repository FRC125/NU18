package org.usfirst.frc.team125.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.RobotMap;
import org.usfirst.frc.team125.robot.util.CurrentReader;
import org.usfirst.frc.team125.robot.util.DebouncedBoolean;

public class Intake extends Subsystem {

    //Intake motors
    private IMotorController intakeL = new VictorSPX(RobotMap.INTAKE_LEFT);
    private IMotorController intakeR = new VictorSPX(RobotMap.INTAKE_RIGHT);

    private DoubleSolenoid intakeSolenoid = new DoubleSolenoid(RobotMap.INTAKE_RETRACT_FORWARD, RobotMap.INTAKE_RETRACT_REVERSE);

    private DigitalInput smartIntakeA = new DigitalInput(RobotMap.INTAKE_LIMIT_SWITCH_A);
    private DigitalInput smartIntakeB = new DigitalInput(RobotMap.INTAKE_LIMIT_SWITCH_B);
    private static final double minimumSmartIntakeTime = 0.2; // Is 2 seconds too long???
    private DebouncedBoolean smartIntakeDebouncerA = new DebouncedBoolean(minimumSmartIntakeTime);
    private DebouncedBoolean smartIntakeDebouncerB = new DebouncedBoolean(minimumSmartIntakeTime);

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
                SmartDashboard.putNumber("j counter", j);
                j++;
            }
        }
    }

    public Intake() {
        Thread thread = new Thread(new Intake.SmartIntakeUpdater());
        thread.start();
        //Left side
        this.intakeL.configPeakOutputForward(INTAKE_POWER_LEFT, 0);
        this.intakeL.configPeakOutputReverse(-INTAKE_POWER_LEFT, 0);
        this.intakeL.configNominalOutputForward(0.0, 0);
        this.intakeL.configNominalOutputReverse(0.0, 0);

        //Right side
        this.intakeR.configPeakOutputForward(INTAKE_POWER_RIGHT, 0);
        this.intakeR.configPeakOutputReverse(-INTAKE_POWER_RIGHT, 0);
        this.intakeR.configNominalOutputForward(0.0, 0);
        this.intakeR.configNominalOutputReverse(0.0, 0);

        this.intakeL.setNeutralMode(NeutralMode.Coast);
        this.intakeR.setNeutralMode(NeutralMode.Coast);

        intakePistonUp(); // TODO: Check if this is right...
    }

    public void intake() {
        this.intakeL.set(ControlMode.PercentOutput, -INTAKE_POWER_LEFT);
        this.intakeR.set(ControlMode.PercentOutput, INTAKE_POWER_RIGHT);
    }

    public void outtake() {
        this.intakeL.set(ControlMode.PercentOutput, INTAKE_POWER_LEFT);
        this.intakeR.set(ControlMode.PercentOutput, -INTAKE_POWER_RIGHT);
    }

    public void stopIntake() {
        this.intakeL.set(ControlMode.PercentOutput, 0);
        this.intakeR.set(ControlMode.PercentOutput, 0);
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
        smartIntakeDebouncerA.update(!smartIntakeA.get());
        smartIntakeDebouncerB.update(!smartIntakeB.get());
        Robot.ledController.setSmartIntakeTriggered(smartIntakeDebouncerA.get() || smartIntakeDebouncerB.get());
        SmartDashboard.putBoolean("Smart intake a", smartIntakeA.get());
        SmartDashboard.putBoolean("Smart intake de-bouncer a", smartIntakeDebouncerA.get());
        SmartDashboard.putBoolean("Smart intake b", smartIntakeB.get());
        SmartDashboard.putBoolean("Smart intake de-bouncer b", smartIntakeDebouncerB.get());
        return (smartIntakeDebouncerA.get() || smartIntakeDebouncerB.get())
                || (!smartIntakeA.get() && !smartIntakeB.get());
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
