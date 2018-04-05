package org.usfirst.frc.team125.robot.commands.Intake.SmartIntake;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class RumbleControllersCmd extends Command {

    public RumbleControllersCmd() {
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.oi.driverPad.setRumble(GenericHID.RumbleType.kLeftRumble, 1.0);
        Robot.oi.driverPad.setRumble(GenericHID.RumbleType.kRightRumble, 1.0);
        Robot.oi.opPad.setRumble(GenericHID.RumbleType.kLeftRumble, 1.0);
        Robot.oi.opPad.setRumble(GenericHID.RumbleType.kRightRumble, 1.0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.oi.driverPad.setRumble(GenericHID.RumbleType.kLeftRumble, 0.0);
        Robot.oi.driverPad.setRumble(GenericHID.RumbleType.kRightRumble, 0.0);
        Robot.oi.opPad.setRumble(GenericHID.RumbleType.kLeftRumble, 0.0);
        Robot.oi.opPad.setRumble(GenericHID.RumbleType.kRightRumble, 0.0);
    }

    protected void interrupted() {
        end();
    }
}
