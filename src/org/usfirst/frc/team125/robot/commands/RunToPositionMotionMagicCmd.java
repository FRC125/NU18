package org.usfirst.frc.team125.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class RunToPositionMotionMagicCmd extends Command {

    private int position;

    public RunToPositionMotionMagicCmd(int pos) {
        requires(Robot.boyfriend);
        this.position = pos;
    }

    protected void initialize() {
        Robot.boyfriend.stopElevator();
    }

    protected void execute() {
        Robot.boyfriend.runToPositionMotionMagic(position);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.boyfriend.stopElevator();
    }

    protected void interrupted() {
        end();
    }
}
