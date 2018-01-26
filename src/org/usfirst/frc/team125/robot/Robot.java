package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import java.lang.reflect.Array;

import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.subsystems.DoubleLift;
import org.usfirst.frc.team125.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team125.robot.commands.Drivetrain.*;
import org.usfirst.frc.team125.robot.subsystems.Drivetrain;

public class Robot extends IterativeRobot {

    public static Drivetrain drivetrain = new Drivetrain();
    public static Intake intake = new Intake();
    public static DoubleLift doubleLift = new DoubleLift();
    public static CubeLift cubeLift = new CubeLift();

    public static OI oi;

    Waypoint[] straightPath = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.4384, 0.0, Pathfinder.d2r(0.0)),
    };

    Waypoint[] curvedPath = new Waypoint[]{
            new Waypoint(0., 0., Pathfinder.d2r(0.0)),
            new Waypoint(2.4384, -1.22, Pathfinder.d2r(-90.0)),
    };

    Waypoint[] autoPathing = curvedPath;
    Trajectory.Config cfg = new Trajectory.Config(Trajectory.FitMethod.HERMITE_QUINTIC, Trajectory.Config.SAMPLES_HIGH,
            Drivetrain.DrivetrainProfiling.dt, Drivetrain.DrivetrainProfiling.max_velocity, Drivetrain.DrivetrainProfiling.max_acceleration, Drivetrain.DrivetrainProfiling.max_jerk);
    Trajectory toFollow = Pathfinder.generate(autoPathing, cfg);
    TankModifier modifier = new TankModifier(toFollow).modify((Drivetrain.DrivetrainProfiling.wheel_base_width));

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

    Command autoCommand;

    @Override
    public void autonomousInit() {
        /* String gameData = DriverStation.getInstance().getGameSpecificMessage(); */ // HOW TO GET GAME DATA
        Robot.drivetrain.pathSetup(modifier, true);
        autoCommand = new DrivePathCmd();
        autoCommand.start();
    }

    @Override
    public void autonomousPeriodic() {
        updateSmartdashboard();
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

    public void updateSmartdashboard() {
    	cubeLift.debugCubelift();
    	drivetrain.debugDrivetrain();
    }

}
