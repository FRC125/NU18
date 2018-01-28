package org.usfirst.frc.team125.robot.commands.CubeLift;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CloseElevatorClampCmd extends Command {

    public CloseElevatorClampCmd() {
        requires(Robot.cubeLift);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.cubeLift.closeClamp();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
