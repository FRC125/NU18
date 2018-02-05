package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team125.robot.subsystems.*;
import org.usfirst.frc.team125.robot.commands.Drivetrain.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

    public static Drivetrain drivetrain = new Drivetrain();
    public static Intake intake = new Intake();
    public static DoubleLift doubleLift = new DoubleLift();
    public static CubeLift cubeLift = new CubeLift();
    public static Flopper flopper = new Flopper();

    public static OI oi;

	Command autoCommand = new AutoCommand();

    @Override
    public void robotInit() {
        oi = new OI();
        drivetrain.timer.start();
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        updateSmartdashboard();
        Scheduler.getInstance().run();
    }


	@Override
	public void autonomousInit() {
		/* String gameData = DriverStation.getInstance().getGameSpecificMessage(); */ // HOW TO GET GAME DATA
		autoCommand.start();
	}

    @Override
    public void autonomousPeriodic(){
        updateSmartdashboard();
        Scheduler.getInstance().run();
    }

	@Override
	public void teleopInit() {

	}

    public void teleopPeriodic() {
        updateSmartdashboard();
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {

    }

    public void updateSmartdashboard() {
        SmartDashboard.putNumber("Left dt Encoder", this.drivetrain.getEncoderRawLeft());
        SmartDashboard.putNumber("Right dt Encoder", this.drivetrain.getEncoderRawRight());
        SmartDashboard.putNumber("Left dt Meters", this.drivetrain.getEncoderDistanceMetersLeft());
        SmartDashboard.putNumber("Right dt Meters", this.drivetrain.getEncoderDistanceMetersRight());
        SmartDashboard.putNumber("Left dt Speed", this.drivetrain.getLeftVelocity());
        SmartDashboard.putNumber("Right dt Speed", this.drivetrain.getRightVelocity());
        SmartDashboard.putNumber("Gyro Angle", this.drivetrain.getAngle());
        SmartDashboard.putNumber("Elevator Encoder Position", this.cubeLift.getEncPos());
        this.drivetrain.updateAccelDashboard();
        this.cubeLift.updatePIDFOnDashboard();
        this.cubeLift.updatePIDFFromDashboard();
        SmartDashboard.putBoolean("Hall Effect Debouncer", this.cubeLift.getHallEffectDebouncer());
        SmartDashboard.putString("Elevator State", this.cubeLift.getState().toString());
        SmartDashboard.putString("Elevator Position", this.cubeLift.getPosition().toString());
        SmartDashboard.putBoolean("Raw HE", this.cubeLift.getRawHallEffectSensor());
    }
}
