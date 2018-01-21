package org.usfirst.frc.team125.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class DriveArcadeWithHoldHeadingCmd extends Command {

    public DriveArcadeWithHoldHeadingCmd() {
        requires(Robot.dt);
    }

    protected void initialize() {
        Robot.dt.disableBreakMode();
        Robot.dt.resetGyro();
    }

    protected void execute() {
        Robot.dt.driveHoldHeading(Robot.oi.getDriverTriggerSum());
    }

    protected boolean isFinished() { return false; }

    protected void end() {
        Robot.dt.resetLastHeadingError();
    }

    protected void interrupted() {
        end();
    }

}
