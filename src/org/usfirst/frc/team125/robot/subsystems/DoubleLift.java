package org.usfirst.frc.team125.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team125.robot.RobotMap;

/**
 * DoubleLift's DoubleLift for DoubleLifting
 */
public class DoubleLift extends Subsystem {

    //Motor Controllers TODO: Add possible slaves?
    private TalonSRX elevator = new TalonSRX(RobotMap.ELEVATOR);

    public void initDefaultCommand() {
        this.elevator.configPeakOutputForward(1.0, 0);
        this.elevator.configPeakOutputReverse(-1.0, 0);
        this.elevator.configNominalOutputForward(0.0, 0);
        this.elevator.configNominalOutputReverse(0.0, 0);

        //Encoder
        this.elevator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

        this.elevator.setNeutralMode(NeutralMode.Brake);
    }

    public void resetEncoders() {
        this.elevator.setSelectedSensorPosition(0, 0, 0);
    }

}

