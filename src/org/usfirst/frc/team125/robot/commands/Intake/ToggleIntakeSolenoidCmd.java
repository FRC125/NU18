package org.usfirst.frc.team125.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class ToggleIntakeSolenoidCmd extends Command {

    public ToggleIntakeSolenoidCmd() {
        requires(Robot.intake);
    }

    protected void initialize() {
        Robot.intake.toggleIntakePiston();
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

