package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team125.robot.commands.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.SetupPathCmd;
import org.usfirst.frc.team125.robot.subsystems.Drivetrain;

public class Robot extends IterativeRobot{

	public static Drivetrain dt = new Drivetrain();

	public static OI oi;

	Waypoint[] straightPath = new Waypoint[] {
			new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
			new Waypoint(5, 0.0, Pathfinder.d2r(0.0)),
	};

	Waypoint[] curvedPath = new Waypoint[] {
			new Waypoint(0., 0., Pathfinder.d2r(0.0)),
			new Waypoint(6.3, 2.125, Pathfinder.d2r(90)),
	};

	Waypoint[] autoPathing = straightPath;
	Trajectory.Config cfg = new Trajectory.Config(Trajectory.FitMethod.HERMITE_QUINTIC, Trajectory.Config.SAMPLES_HIGH,
			Drivetrain.DrivetrainProfiling.dt, Drivetrain.DrivetrainProfiling.max_velocity, Drivetrain.DrivetrainProfiling.max_acceleration, Drivetrain.DrivetrainProfiling.max_jerk);
	Trajectory toFollow = Pathfinder.generate(autoPathing, cfg);
	TankModifier modifier = new TankModifier(toFollow).modify((Drivetrain.DrivetrainProfiling.wheel_base_width));

	@Override
	public void robotInit() {
		oi = new OI();
		dt.timer.start();
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
		Command autoInit = new SetupPathCmd(modifier);
		autoInit.start();
	}

	@Override
	public void autonomousPeriodic() {
		updateSmartdashboard();
		Command autoPeriodic = new DrivePathCmd();
		autoPeriodic.start();
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		updateSmartdashboard();
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}

	public void updateSmartdashboard() {
		SmartDashboard.putNumber("left Enc", this.dt.getEncoderRawLeft());
		SmartDashboard.putNumber("right Enc", this.dt.getEncoderRawRight());
		SmartDashboard.putNumber("angle", this.dt.getAngle());
	}
}
