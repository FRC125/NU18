package org.usfirst.frc.team125.robot.commands.Intake;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCmd extends Command {

    public IntakeCmd() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
    }

    @Override
    public void execute() {
        if (Robot.intake.passedCurrentLimit()){
            end();
        }else{
            Robot.intake.intake();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
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
