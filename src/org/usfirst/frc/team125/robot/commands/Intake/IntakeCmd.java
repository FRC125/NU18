package org.usfirst.frc.team125.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.commands.Groups.ClampAndIntakeCmdGrp;


public class IntakeCmd extends Command {

    public IntakeCmd() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
    }

    @Override
    public void execute() {

        if(Robot.intake.checkSmartIntakeTriggered()) {
            Robot.intake.stopIntake();
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
        new ClampAndIntakeCmdGrp();
        Robot.intake.stopIntake();
    }

    protected void interrupted() {
        end();
    }

}
