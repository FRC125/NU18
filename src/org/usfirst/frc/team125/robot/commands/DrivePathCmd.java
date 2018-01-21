package org.usfirst.frc.team125.robot.commands;

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

    public DrivePathCmd() {
        requires(Robot.dt);
    }

    protected void initialize() {
        Robot.dt.pathFollow();
    }

    protected void execute() {
        Robot.dt.pathFollow();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
