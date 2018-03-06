package org.usfirst.frc.team125.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;


public class PulseIntakeCmd extends Command {

    public PulseIntakeCmd() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
    }

    @Override
    public void execute() {
            Robot.intake.intake();
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
