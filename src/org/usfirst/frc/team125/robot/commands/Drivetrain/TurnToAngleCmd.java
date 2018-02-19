package org.usfirst.frc.team125.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class TurnToAngleCmd extends Command {

    public TurnToAngleCmd(double angle) {
        requires(Robot.drivetrain);
        this.angle = angle;

    }

    double angle;

    protected void initialize() {
        Robot.drivetrain.enableBreakMode();
        Robot.drivetrain.resetGyro();
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return Robot.drivetrain.turnToAngle(angle);
    }

    protected void end() {
        Robot.drivetrain.resetLastHeadingError();
        Robot.drivetrain.drive(0.0, 0.0);
    }

    protected void interrupted() {
        end();
    }

}
