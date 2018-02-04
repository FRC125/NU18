package org.usfirst.frc.team125.robot.commands.CubeLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class CloseClampCmd extends Command {

    public CloseClampCmd() {
        requires(Robot.cubeLift);
    }

    protected void initialize(){
    }

    protected void execute() {
        Robot.cubeLift.closeClamp();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    protected void end(){

    }

    protected void interrupted(){
        end();
    }
}
