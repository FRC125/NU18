package org.usfirst.frc.team125.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class ElevatorDrive extends Command {

    public ElevatorDrive() {
        requires(Robot.boyfriend);
    }   

    protected void initialize() {
    }

    protected void execute() {
        Robot.boyfriend.directElevate(Robot.oi.getDriverLeftStickY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
