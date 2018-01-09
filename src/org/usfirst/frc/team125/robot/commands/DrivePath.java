package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivePath extends Command {

    public DrivePath() {
        requires(Robot.dt);
    }

    protected void initialize() {
        Robot.dt.PathFollow();
    }

    protected void execute() {
        Robot.dt.PathFollow();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
