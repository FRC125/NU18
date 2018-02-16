package org.usfirst.frc.team125.robot.commands.DoubleLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class ReleaseCarrierCmd extends Command {

    public ReleaseCarrierCmd() {
        requires(Robot.doubleLift);
    }

    protected void initialize() {
        Robot.doubleLift.releaseCarrier();
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

