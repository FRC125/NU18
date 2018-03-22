package org.usfirst.frc.team125.robot.commands.MotoredDoubleLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;


public class AnalogLiftCmd extends Command {

    public AnalogLiftCmd() {
        requires(Robot.motorDoubleLift);
        setInterruptible(true);
    }

    @Override
    protected void initialize() {
    }

    @Override
    public void execute() {
        Robot.motorDoubleLift.analogLift(Robot.oi.getOpRightTrigger());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    protected void interrupted() {
        Robot.motorDoubleLift.stopDoubleLift();
    }

}
