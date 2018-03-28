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
        /*if (Robot.cubeLift.getPosition() != CubeLift.Positions.Intake || Robot.cubeLift.getState() != CubeLift.LiftState.Stationary) {
            Robot.intake.stopIntake();
        } else {*/
        Robot.cubeLift.openGrabbers();
        if (Robot.intake.checkRightSmartIntakeTriggered() && !Robot.intake.checkLeftSmartIntakeTriggered()){
            Robot.intake.runIntakeL();
        } else if (Robot.intake.checkLeftSmartIntakeTriggered() && !Robot.intake.checkLeftSmartIntakeTriggered()){
            Robot.intake.runIntakeR();
        } else {
            Robot.intake.intake();
        }
    }
    //}

    @Override
    protected boolean isFinished() {
        System.out.println("finished");
        return Robot.intake.checkLeftSmartIntakeTriggered() && Robot.intake.checkRightSmartIntakeTriggered();
    }

    @Override
    protected void end() {
        System.out.println("end");
        Robot.intake.stopIntake();
    }

    protected void interrupted() {
        end();
    }

}
