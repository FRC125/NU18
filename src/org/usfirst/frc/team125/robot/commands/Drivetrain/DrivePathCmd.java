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
    public DrivePathCmd(Waypoint[] path) {
        requires(Robot.drivetrain);
        this.path = path;
        setInterruptible(false);
    }

    protected void initialize() {
        Robot.drivetrain.pathFollow(Robot.drivetrain.pathSetup(path, true), false);
    }

    protected void execute() {
        Robot.drivetrain.pathFollow(Robot.drivetrain.pathSetup(path, true), false);
    }

    protected boolean isFinished() {
        return Robot.drivetrain.getIsProfileFinished();
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
