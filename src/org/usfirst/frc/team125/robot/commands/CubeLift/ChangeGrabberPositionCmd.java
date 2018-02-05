package org.usfirst.frc.team125.robot.commands.CubeLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class ChangeGrabberPositionCmd extends Command {

    public ChangeGrabberPositionCmd() {
        requires(Robot.cubeLift);
    }

    protected void initialize() {
        Robot.cubeLift.changeGrabberPosition();
    }

    protected void execute() {

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
