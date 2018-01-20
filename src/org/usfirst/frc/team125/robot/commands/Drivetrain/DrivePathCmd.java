package org.usfirst.frc.team125.robot.commands.Drivetrain;

import org.usfirst.frc.team125.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivePathCmd extends Command {

    public DrivePathCmd() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
        Robot.drivetrain.pathFollow();
    }

    protected void execute() {
        Robot.drivetrain.pathFollow();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
