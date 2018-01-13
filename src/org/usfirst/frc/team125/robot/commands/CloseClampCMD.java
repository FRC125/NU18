package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CloseClampCMD extends Command {

    public CloseClampCMD() {
        requires(Robot.intake);
    }


    protected void initialize() {
    }

   
    protected void execute() {
    	Robot.intake.closeClamp();
    }

    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }

    
    protected void interrupted() {
    }
}
