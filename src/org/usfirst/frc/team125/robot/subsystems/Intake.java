package org.usfirst.frc.team125.robot.subsystems;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team125.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team125.robot.commands.CubeLift.CloseGrabbersCmd;
import org.usfirst.frc.team125.robot.util.CurrentReader;
import org.usfirst.frc.team125.robot.util.DebouncedBoolean;

public class Intake extends Subsystem {

    //Intake motors
    private IMotorController intakeL = new TalonSRX(RobotMap.INTAKE_LEFT);
    private IMotorController intakeR = new TalonSRX(RobotMap.INTAKE_RIGHT);

    private DoubleSolenoid intakePiston = new DoubleSolenoid(RobotMap.INTAKE_RETRACT_FORWARD, RobotMap.INTAKE_RETRACT_REVERSE);

    private DigitalInput smartIntake = new DigitalInput(RobotMap.INTAKE_LIMIT_SWITCH);
    private static final double minimumSmartIntakeTime = 2.0; // Is 2 seconds too long???
    private DebouncedBoolean smartIntakeDebouncer = new DebouncedBoolean(minimumSmartIntakeTime);

    public static final double INTAKE_POWER_LEFT = 1.0;
    public static final double INTAKE_POWER_RIGHT = .50;
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
                SmartDashboard.putBoolean("Is Smart Intake Updater Alive", true);
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

        this.intakePiston.set(INTAKE_REVERSE_VALUE); // TODO: Check if this is right...
    }

    public void intake() {
            this.intakeL.set(ControlMode.PercentOutput, INTAKE_POWER_LEFT);
            this.intakeR.set(ControlMode.PercentOutput, -INTAKE_POWER_RIGHT);
    }


    public void outtake() {
            this.intakeL.set(ControlMode.PercentOutput, -INTAKE_POWER_LEFT);
            this.intakeR.set(ControlMode.PercentOutput, INTAKE_POWER_RIGHT);
    }

    public void stopIntake() {
        this.intakeL.set(ControlMode.PercentOutput, 0);
        this.intakeR.set(ControlMode.PercentOutput, 0);
    }

    public boolean passedCurrentLimit(){
        double intakeCurrent = 0;
        intakeCurrent = this.intakeCurrentReader.getTotalCurrent(CurrentReader.CurrentPorts.Intake);
        SmartDashboard.putNumber("intakeCurrent", intakeCurrent );

        if (intakeCurrent > this.intakeCurrentReader.INTAKE_MAX_CURRENT){
            this.intakeCurrentReader.currentCounter += 1;
        }
        return this.intakeCurrentReader.currentCounter > this.intakeCurrentReader.COUNTER_MAX ? true : false;
    }

    public int currentCounterReset(){
        return this.intakeCurrentReader.currentCounter = 0;
    }

    public void checkSmartIntakeTriggered(){
        smartIntakeDebouncer.update(smartIntake.get());
        if (smartIntakeDebouncer.get()) {
            new CloseGrabbersCmd();
        }
    }



    public void intakePistonForward() {
        this.intakePiston.set(INTAKE_FORWARD_VALUE);
    }

    public void intakePistonReverse() {
        this.intakePiston.set(INTAKE_REVERSE_VALUE);
    }

    @Override
    protected void initDefaultCommand() {
    }
}
