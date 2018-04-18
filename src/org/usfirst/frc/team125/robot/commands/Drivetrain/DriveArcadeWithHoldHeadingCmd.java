package org.usfirst.frc.team125.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class DriveArcadeWithHoldHeadingCmd extends Command {

    public DriveArcadeWithHoldHeadingCmd() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
        Robot.drivetrain.enableBreakMode();
        Robot.drivetrain.resetGyro();
    }

    protected void execute() {
        Robot.drivetrain.driveHoldHeading(Robot.oi.getDriverTriggerSum());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.drivetrain.resetForPointTurn();
    }

    protected void interrupted() {
        end();
    }

}
