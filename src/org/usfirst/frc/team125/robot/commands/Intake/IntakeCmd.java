package org.usfirst.frc.team125.robot.commands.Intake;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.subsystems.Intake;

public class IntakeCmd extends Command {

    public IntakeCmd() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
    }

    @Override
    public void execute() {
        Robot.intake.runIntake(-1.0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.intake.stopIntake();
    }

    protected void interrupted() {
        end();
    }

}
