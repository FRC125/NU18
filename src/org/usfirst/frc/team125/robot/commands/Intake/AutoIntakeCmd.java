package org.usfirst.frc.team125.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.commands.Groups.ClampAndLiftCmdGrp;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;


public class AutoIntakeCmd extends Command {

    public AutoIntakeCmd() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
        Robot.cubeLift.unpunch();
    }

    @Override
    public void execute() {
        Robot.cubeLift.unpunch();
        if (Robot.intake.checkSmartIntakeTriggered()) {
            Command smartIntakeTriggered = new ClampAndLiftCmdGrp();
            smartIntakeTriggered.start();
        } else {
            Robot.cubeLift.openGrabbers();
            Robot.intake.intake();
        }
    }

    @Override
    protected boolean isFinished() {
        return Robot.intake.checkSmartIntakeTriggered();
    }

    @Override
    protected void end() {
        Robot.intake.stopIntake();
    }

    protected void interrupted() {
        end();
    }

}
