package org.usfirst.frc.team125.robot.commands.Flopper;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class DeployCubeLeftCmd extends Command {
    public DeployCubeLeftCmd(){
        requires(Robot.flopper);
    }
    protected void initialize() {

    }

    protected void execute() {
        Robot.flopper.deployFlopLeft();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
