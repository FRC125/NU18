package org.usfirst.frc.team125.robot.commands.CubeLift;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenElevatorClampCmd extends Command {

    public OpenElevatorClampCmd() {
    	requires(Robot.cubeLift);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.cubeLift.openClamp();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
