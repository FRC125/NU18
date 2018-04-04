package org.usfirst.frc.team125.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.subsystems.Drivetrain;

/**
 *
 */
public class DrivePathCmd extends Command {

    Waypoint[] path;
    EncoderFollower[] followers;

    public DrivePathCmd(Waypoint[] path, boolean slow) {
        requires(Robot.drivetrain);
        this.path = path;
        setInterruptible(false);
        Drivetrain.DrivetrainProfiling.setupPathVariables(slow);
        followers = Robot.drivetrain.pathSetup(path);
    }

    protected void initialize() {
        Robot.drivetrain.resetForPath();
        Robot.drivetrain.pathFollow(followers, false);
    }

    protected void execute() {
        Robot.drivetrain.pathFollow(followers, false);
    }

    protected boolean isFinished() {
        return Robot.drivetrain.getIsProfileFinished();
    }

    protected void end() {
        Robot.drivetrain.drive(0., 0.);
    }

    protected void interrupted() {
        end();
    }

}
