package org.usfirst.frc.team125.robot.commands.Intake.SmartIntake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;


public class SmartIntakeCmd extends Command {

    public SmartIntakeCmd() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
        Robot.cubeLift.unpunch();
    }

    @Override
    public void execute() {
        System.out.println("exe");
        Robot.cubeLift.unpunch();
        Robot.cubeLift.openGrabbers();
        /*switch (Robot.intake.getSmartIntakeState()) {
            case NotTriggered:
            case BothTriggered:
                Robot.intake.intake();
                break;
            case LeftTriggered:
                Robot.intake.intakeRightSide();
                break;
            case RightTriggered:
                Robot.intake.intakeLeftSide();
                break;
            default:
                break;
        }
        */
        Robot.intake.intake();
    }

    @Override
    protected boolean isFinished() {
        System.out.println("finished");
        return Robot.intake.checkSmartIntakeTriggered();
    }

    @Override
    protected void end() {
        System.out.println("end");
        Robot.intake.stopIntake();
    }

    protected void interrupted() {
        end();
    }

    /*if (Robot.cubeLift.getPosition() != CubeLift.Positions.Intake || Robot.cubeLift.getState() != CubeLift.LiftState.Stationary) {
            Robot.intake.stopIntake(); */
}
