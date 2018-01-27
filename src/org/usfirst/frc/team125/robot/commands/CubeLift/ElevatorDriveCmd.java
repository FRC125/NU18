package org.usfirst.frc.team125.robot.commands.CubeLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

/**
 *
 */
public class ElevatorDriveCmd extends Command {

    public ElevatorDriveCmd() {
        requires(Robot.cubeLift);
    }   

    protected void initialize() {
    }

    protected void execute() {
        Robot.cubeLift.directElevate(Robot.oi.getDriverLeftStickY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
