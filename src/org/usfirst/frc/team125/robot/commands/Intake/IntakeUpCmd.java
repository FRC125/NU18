package org.usfirst.frc.team125.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class IntakeUpCmd extends Command {

    public IntakeUpCmd() {
        requires(Robot.intake);
    }

    protected void initialize() {
        Robot.intake.intakePistonUp();
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
