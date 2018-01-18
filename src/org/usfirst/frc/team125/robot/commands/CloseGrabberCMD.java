package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CloseGrabberCMD extends Command {

    public CloseGrabberCMD() {
    	requires(Robot.boyfriend);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.boyfriend.closeGrabbers();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
