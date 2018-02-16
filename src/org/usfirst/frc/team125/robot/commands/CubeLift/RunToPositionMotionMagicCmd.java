package org.usfirst.frc.team125.robot.commands.CubeLift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;

public class RunToPositionMotionMagicCmd extends Command {

    private CubeLift.Positions position;
    private boolean started = false;

    public RunToPositionMotionMagicCmd(CubeLift.Positions pos) {
        requires(Robot.cubeLift);
        this.position = pos;
    }

    protected void initialize() {
        Robot.cubeLift.stopElevator();
        if(position == CubeLift.Positions.Climbing || position == CubeLift.Positions.ChinUp) {
            Robot.intake.intakePistonReverse();
        } else {
            Robot.intake.intakePistonForward();
        }
        Robot.cubeLift.startMotionMagic(this.position);
    }

    protected void execute() {
        if (!started) {
            started = true;
        } else {
            Robot.cubeLift.checkMotionMagicTermination(this.position);
        }

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
