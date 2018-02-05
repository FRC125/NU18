package org.usfirst.frc.team125.robot.commands.Flopper;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class DeployCubeRightCmd extends Command {

    public DeployCubeRightCmd(){
        requires(Robot.flopper);
    }
    protected void initialize() {

    }

    protected void execute() {
        Robot.flopper.deployFlopRight();
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
