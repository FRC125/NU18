package org.usfirst.frc.team125.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class CounterCWAngleTurnCmd extends Command {

    double angle;
    double changeInAngle;
    boolean isFinished = false;

    public CounterCWAngleTurnCmd(double changeInAngle) {
        requires(Robot.drivetrain);
        this.changeInAngle = changeInAngle;
    }

    protected void initialize() {
        this.angle = Robot.drivetrain.getAngle() + changeInAngle;
        Robot.drivetrain.enableBreakMode();
        Robot.drivetrain.resetForPointTurn();
    }

    protected void execute() {
        isFinished = Robot.drivetrain.turnToAngle(angle);
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
        Robot.drivetrain.resetForPointTurn();
        Robot.drivetrain.drive(0.0, 0.0);
    }

    protected void interrupted() {
        end();
    }

}
