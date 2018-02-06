package org.usfirst.frc.team125.robot.commands.CubeLift;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenGrabbersCmd extends Command {

    public OpenGrabbersCmd() {
        requires(Robot.cubeLift);
    }

    protected void initialize() {
        Robot.cubeLift.openGrabbers();
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
