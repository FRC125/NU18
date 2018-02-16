package org.usfirst.frc.team125.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class DriveTankCmd extends Command {

    public DriveTankCmd() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
        Robot.drivetrain.enableBreakMode();
    }

    protected void execute() {
        Robot.drivetrain.drive(Robot.oi.getDriverLeftStickY(), Robot.oi.getDriverRightStickY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        //Left empty intentionally
    }

    protected void interrupted() {
        super.interrupted();
    }

}
