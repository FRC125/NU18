package org.usfirst.frc.team125.robot.commands.CubeLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class ElevatorDriveCmd extends Command {

    public ElevatorDriveCmd() {
        requires(Robot.cubeLift);
        setInterruptible(true);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.cubeLift.directElevate(-Robot.oi.getOpLeftStickY() * 0.25);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
        Robot.cubeLift.stopElevator();
    }

}
