package org.usfirst.frc.team125.robot.commands.CubeLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class StartClimbCmd extends Command {

    public StartClimbCmd() {
        requires(Robot.cubeLift);
        setInterruptible(true);
    }

    protected void initialize() {
        Robot.cubeLift.stopElevator();
    }

    protected void execute(){
        Robot.cubeLift.directElevate(-0.1);
        Robot.cubeLift.updateCurrentSpikeDebouncer();
    }

    protected boolean isFinished() {
        return Robot.cubeLift.getCurrentSpikeDebouncer();
    }

    protected void end() {
    }

    protected void interrupted() {
        Robot.cubeLift.stopElevator();
    }

}
