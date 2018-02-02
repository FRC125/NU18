package org.usfirst.frc.team125.robot.commands.CubeLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class RunToPositionMotionMagicCmd extends Command {

    private int position;
    private final int TOLERANCE = 200;

    public RunToPositionMotionMagicCmd(int pos) {
        requires(Robot.cubeLift);
        this.position = pos;
    }

    protected void initialize() {
        Robot.cubeLift.stopElevator();
    }

    protected void execute() {
        Robot.cubeLift.runToPositionMotionMagic(position);
    }

    protected boolean isFinished() {
        return (position - Robot.cubeLift.getEncPos()) <= TOLERANCE;
    }

    protected void end() {
        Robot.cubeLift.stopElevator();
    }

    protected void interrupted() {
        end();
    }
}
