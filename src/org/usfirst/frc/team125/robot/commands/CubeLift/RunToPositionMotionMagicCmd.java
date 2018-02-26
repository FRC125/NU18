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
        Robot.cubeLift.closeGrabbers();
        Robot.ledController.setRunningMotionMagic(true);
        switch (position) {
            case Intake:
                Robot.intake.intakePistonDown();
                break;
            case ScoreSwitch:
            case ScoreScale:
                Robot.intake.intakePistonDown();
                break;
            case PreClimb:
            case ClimbingBar:
                Robot.intake.intakePistonUp();
                break;
            case ChinUp:
                Robot.cubeLift.unpin();
                Robot.intake.intakePistonDown();
                break;
            default:
                break;

        }
        Robot.cubeLift.startMotionMagic(this.position);
    }

    protected void execute() {
        Robot.ledController.setRunningMotionMagic(true);
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
        Robot.ledController.setRunningMotionMagic(false);
        Robot.cubeLift.stopElevator();
    }

    protected void interrupted() {
        end();
    }
}