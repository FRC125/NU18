package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeGrabberPositionCMD extends Command {

    public ChangeGrabberPositionCMD() {
    	requires(Robot.boyfriend);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.boyfriend.changeGrabberPosition();
    }

    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }

    protected void interrupted() {
    }
}
