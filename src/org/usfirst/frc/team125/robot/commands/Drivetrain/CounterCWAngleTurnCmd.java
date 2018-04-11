package org.usfirst.frc.team125.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class CounterCWAngleTurnCmd extends Command {

    double angle;
    boolean isFinished = false;

    public CounterCWAngleTurnCmd(double changeInAngle) {
        requires(Robot.drivetrain);
        this.angle = Robot.drivetrain.getAngle() + changeInAngle;
    }

    protected void initialize() {
        Robot.drivetrain.enableBreakMode();
        Robot.drivetrain.resetLastHeadingError();
    }

    protected void execute() {
        isFinished = Robot.drivetrain.turnToAngle(angle);
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
        Robot.drivetrain.resetLastHeadingError();
        Robot.drivetrain.drive(0.0, 0.0);
    }

    protected void interrupted() {
        end();
    }

}
