package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
//import org.usfirst.frc.team125.robot.subsystems.DoubleLift;
public class Robot extends IterativeRobot{

	public static CubeLift boyfriend = new CubeLift();
	public static OI oi;

	@Override
	public void robotInit() {
		oi = new OI();
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Elevator Encoder Value", boyfriend.getEncPos());
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
//		SmartDashboard.putNumber("Elevator Encoder Value", boyfriend.getEncPos());
	}

	@Override
	public void testPeriodic() {
	}
}