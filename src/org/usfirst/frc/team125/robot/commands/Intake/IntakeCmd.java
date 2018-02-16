package org.usfirst.frc.team125.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class IntakeCmd extends Command {

    public IntakeCmd() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
    }

    @Override
    public void execute() {
        if (Robot.intake.passedCurrentLimit()) {
            Robot.intake.stopIntake();
        } else {
            Robot.intake.intake();
        }
    }

    @Override
    protected boolean isFinished() {
        return Robot.intake.passedCurrentLimit();
    }

    @Override
    protected void end() {
        Robot.intake.stopIntake();
        Robot.intake.currentCounterReset();
    }

    protected void interrupted() {
        end();
    }

}
