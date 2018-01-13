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
        Robot.dt.pathFollow();
    }

    protected void execute() {
        Robot.dt.pathFollow();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
