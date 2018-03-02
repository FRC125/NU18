package org.usfirst.frc.team125.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Groups.ClamAndLiftCmdGrp;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;


public class IntakeCmd extends Command {

    public IntakeCmd() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
        Robot.cubeLift.unpunch();
    }

    @Override
    public void execute() {
        Robot.cubeLift.unpunch();
        if (Robot.cubeLift.getPosition() != CubeLift.Positions.Intake || Robot.cubeLift.getState() != CubeLift.LiftState.Stationary) {
            Robot.intake.stopIntake();
        } else if (Robot.intake.checkSmartIntakeTriggered()) {
            Command smartIntakeTriggered = new ClamAndLiftCmdGrp();
            smartIntakeTriggered.start();
        } else {
            Robot.cubeLift.openGrabbers();
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
    }

    protected void interrupted() {
        end();
    }

}
