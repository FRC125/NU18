package org.usfirst.frc.team125.robot.commands.Drivetrain;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team125.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.subsystems.Drivetrain;

/**
 *
 */
public class DrivePathCmd extends Command {


    Waypoint[] path;

    public DrivePathCmd(Waypoint[] waypoints) {
        requires(Robot.drivetrain);

        this.path = waypoints;
    }

    protected void initialize() {
        TankModifier modifier;
        Trajectory.Config cfg = new Trajectory.Config(Trajectory.FitMethod.HERMITE_QUINTIC,
                Trajectory.Config.SAMPLES_HIGH,
                Drivetrain.DrivetrainProfiling.dt,
                Drivetrain.DrivetrainProfiling.max_velocity,
                Drivetrain.DrivetrainProfiling.max_acceleration,
                Drivetrain.DrivetrainProfiling.max_jerk);
        Trajectory toFollow = Pathfinder.generate(path, cfg);
        modifier = new TankModifier(toFollow).modify((Drivetrain.DrivetrainProfiling.wheel_base_width));
        Robot.drivetrain.pathSetup(modifier, true);
        Robot.drivetrain.pathFollow(false);
    }

    protected void execute() {
        Robot.drivetrain.pathFollow(false);
    }

    protected boolean isFinished() {
        return Robot.drivetrain.isPathFinished();
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
