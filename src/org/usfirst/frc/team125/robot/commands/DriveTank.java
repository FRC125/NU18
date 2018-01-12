package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.OI;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTank extends Command {

    public DriveTank() {
        requires(Robot.dt);
    }

    protected void initialize() {
        Robot.dt.disableBreakMode();
    }

    protected void execute() {
        Robot.dt.drive(Robot.oi.getDriverLeftStickY(), Robot.oi.getDriverRightStickY());
    }

    protected boolean isFinished() { return false; }

    protected void end() {
        //Left empty intentionally
    }

    protected void interrupted() {
        super.interrupted();
    }

}
