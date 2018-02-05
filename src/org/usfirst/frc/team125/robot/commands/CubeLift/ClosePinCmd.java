package org.usfirst.frc.team125.robot.commands.CubeLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class ClosePinCmd extends Command {

    public ClosePinCmd() {
        requires(Robot.cubeLift);
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.cubeLift.closePin();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    protected void end() {

    }

    protected void interrupted() {

    }

}
