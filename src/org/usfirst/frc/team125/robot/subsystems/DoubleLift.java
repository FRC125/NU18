package org.usfirst.frc.team125.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.RobotMap;

/**
 * DoubleLift's DoubleLift for DoubleLifting
 */
public class DoubleLift extends Subsystem {

    //Motor Controllers TODO: Add possible slaves?
    private TalonSRX elevator = new TalonSRX(RobotMap.ELEVATOR);
    private DoubleSolenoid shifter = new DoubleSolenoid(RobotMap.SHIFT_FORWARD, RobotMap.SHIFT_BACKWARD);

    public void initDefaultCommand() {
        this.elevator.configPeakOutputForward(1.0, 0);
        this.elevator.configPeakOutputReverse(-1.0, 0);
        this.elevator.configNominalOutputForward(0.0, 0);
        this.elevator.configNominalOutputReverse(0.0, 0);

        //Encoder
        this.elevator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

        //Neutral mode
        this.elevator.setNeutralMode(NeutralMode.Brake);

        configPIDF(0, 0, 0, 0); // TODO: Tune lol
    }

    public void resetEncoders() {
        this.elevator.setSelectedSensorPosition(0, 0, 0);
    }

    public void shiftForward() {
        shifter.set(DoubleSolenoid.Value.kForward);
    }

    public void shiftBackward() {
        shifter.set(DoubleSolenoid.Value.kReverse);
    }

    public void runToPosition(int pos) {
        elevator.set(ControlMode.Position, pos);
    }

    public void directElevate(double pow) {
        elevator.set(ControlMode.PercentOutput, pow);
    }

    public void configPIDF(double kP, double kI, double kD, double kF) {
        elevator.config_kP(0, kP, 0);
        elevator.config_kI(0, kI, 0);
        elevator.config_kD(0, kD, 0);
        elevator.config_kF(0, kF, 0);
    }

}

