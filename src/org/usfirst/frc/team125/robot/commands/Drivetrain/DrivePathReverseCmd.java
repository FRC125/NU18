package org.usfirst.frc.team125.robot.commands.Drivetrain;

import com.sun.corba.se.impl.encoding.EncapsOutputStream;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.subsystems.Drivetrain;

/**
 *
 */
public class DrivePathReverseCmd extends Command {

    Waypoint[] path;
    EncoderFollower[] followers;

    public DrivePathReverseCmd(Waypoint[] path) {
        requires(Robot.drivetrain);
        this.path = path;
        setInterruptible(false);
        followers = Robot.drivetrain.pathSetup(path);
    }

    protected void initialize() {
        Robot.drivetrain.resetForPath();
        Robot.drivetrain.pathFollow(followers, true);
    }

    protected void execute() {
        Robot.drivetrain.pathFollow(followers, true);
    }

    protected boolean isFinished() {
        return Robot.drivetrain.getIsProfileFinished();
    }

    protected void end() {
        Robot.drivetrain.drive(0.,0.);
    }

    protected void interrupted() {
        end();
    }

}
