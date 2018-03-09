package org.usfirst.frc.team125.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class DrivePathCmd extends Command {

    Waypoint[] path;
    EncoderFollower[] followers;
    String hashCode;

    public DrivePathCmd(Waypoint[] path) {
        requires(Robot.drivetrain);
        this.path = path;
        setInterruptible(false);
        followers = Robot.drivetrain.pathSetup(path);
        hashCode = String.valueOf(Robot.drivetrain.getHash());
    }

    protected void initialize() {
        //Robot.drivetrain.initLogging(hashCode);
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
        //Robot.drivetrain.endLogging();
    }

    protected void interrupted() {
        end();
    }

}
