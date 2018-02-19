package org.usfirst.frc.team125.robot.commands.CubeLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class RunToPositionCmd extends Command {

    private int position;

    public RunToPositionCmd(int pos) {
        requires(Robot.cubeLift);
        this.position = pos;
    }

    protected void initialize() {
        Robot.cubeLift.stopElevator();
    }

    protected void execute() {
        Robot.cubeLift.runToPosition(position);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.cubeLift.stopElevator();
    }

    protected void interrupted() {
        end();
    }
}
