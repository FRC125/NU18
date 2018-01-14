package org.usfirst.frc.team125.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class UpdateCubeSwitchCmd extends Command {

    public UpdateCubeSwitchCmd() {
        requires(Robot.intake);
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.intake.updateCubeSwitch(true);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.intake.updateCubeSwitch(false);
    }

    protected void interrupted() {
        end();
    }
}
