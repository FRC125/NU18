package org.usfirst.frc.team125.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class DriveArcade extends Command {

    public DriveArcade() {
        requires(Robot.dt);
    }

    protected void initialize() {
        Robot.dt.disableBreakMode();
    }

    protected void execute() {
        Robot.dt.driveArcade(Robot.oi.getDriverTriggerSum(), Robot.oi.getDriverLeftStickX());
    }

    protected boolean isFinished() { return false; }

    protected void end() {
        //Left empty intentionally
    }

    protected void interrupted() {
        super.interrupted();
    }

}
