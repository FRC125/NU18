package org.usfirst.frc.team125.robot.commands.CubeLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;

public class RunToPositionMotionMagicCmd extends Command {

    private CubeLift.Positions position;

    public RunToPositionMotionMagicCmd(CubeLift.Positions pos) {
        requires(Robot.cubeLift);
        this.position = pos;
    }

    protected void initialize() {
        Robot.cubeLift.stopElevator();
    }

    protected void execute() {
        Robot.cubeLift.runToPositionMotionMagic(position);
    }

    protected boolean isFinished() {
        return Robot.cubeLift.getState() == CubeLift.LiftState.Stationary && Robot.cubeLift.getPosition() == this.position;
    }

    protected void end() {
        Robot.cubeLift.stopElevator();
    }

    protected void interrupted() {
        end();
    }
}
