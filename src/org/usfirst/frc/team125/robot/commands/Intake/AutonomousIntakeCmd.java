package org.usfirst.frc.team125.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;


public class AutonomousIntakeCmd extends Command {

    public AutonomousIntakeCmd() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
    }

    @Override
    public void execute() {
        Robot.cubeLift.openGrabbers();
        Robot.cubeLift.unpunch();
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
