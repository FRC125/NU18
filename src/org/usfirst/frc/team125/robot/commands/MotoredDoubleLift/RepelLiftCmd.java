package org.usfirst.frc.team125.robot.commands.MotoredDoubleLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;


public class RepelLiftCmd extends Command {

    public RepelLiftCmd() {
        requires(Robot.motorDoubleLift);
    }

    @Override
    protected void initialize() {
    }

    @Override
    public void execute() {
        Robot.motorDoubleLift.repel();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.motorDoubleLift.stopDoubleLift();
    }

    protected void interrupted() {
        end();
    }

}
