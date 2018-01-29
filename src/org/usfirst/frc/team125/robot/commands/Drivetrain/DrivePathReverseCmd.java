package org.usfirst.frc.team125.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.subsystems.Drivetrain;

/**
 *
 */
public class DrivePathReverseCmd extends Command {


    TankModifier modifier;
    public DrivePathReverseCmd(Waypoint[] waypoints) {
        requires(Robot.drivetrain);

        Trajectory.Config cfg = new Trajectory.Config(Trajectory.FitMethod.HERMITE_QUINTIC,
                Trajectory.Config.SAMPLES_HIGH,
                Drivetrain.DrivetrainProfiling.dt,
                Drivetrain.DrivetrainProfiling.max_velocity,
                Drivetrain.DrivetrainProfiling.max_acceleration,
                Drivetrain.DrivetrainProfiling.max_jerk);
        Trajectory toFollow = Pathfinder.generate(waypoints, cfg);
        this.modifier = new TankModifier(toFollow).modify((Drivetrain.DrivetrainProfiling.wheel_base_width));
    }

    protected void initialize() {
        Robot.drivetrain.pathSetup(modifier, true);
    }

    protected void execute() {
        Robot.drivetrain.pathFollow(true);
    }

    protected boolean isFinished() {
        return Robot.drivetrain.isPathFinished();
    }

    protected void end() {
    }

    protected void interrupted() {
    }


}
