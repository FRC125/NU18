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

    Waypoint[] path;

    public DrivePathReverseCmd(Waypoint[] path) {
        requires(Robot.drivetrain);
        this.path = path;
        setInterruptible(false);
    }

    protected void initialize() { Robot.drivetrain.pathFollow(Robot.drivetrain.pathSetup(path, true), true);
    }

    protected void execute() {
        Robot.drivetrain.pathFollow(Robot.drivetrain.pathSetup(path, true), true);
    }

    protected boolean isFinished() {
        return Robot.drivetrain.getIsProfileFinished();
    }

    protected void end() {
    }

    protected void interrupted() {
    }


}
