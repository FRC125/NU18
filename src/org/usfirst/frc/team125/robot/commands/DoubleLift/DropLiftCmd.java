package org.usfirst.frc.team125.robot.commands.DoubleLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class DropLiftCmd extends Command {

    public DropLiftCmd() {
        requires(Robot.doubleLift);
    }

    protected void initialize() {
        Robot.doubleLift.dropLift();
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
