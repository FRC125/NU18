package org.usfirst.frc.team125.robot.commands.Drivetrain;

import org.usfirst.frc.team125.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class SetupPathCmd extends Command {

    TankModifier modifier;

    public SetupPathCmd(TankModifier modifier) {
        requires(Robot.drivetrain);
        this.modifier = modifier;
    }

    protected void initialize() {
        Robot.drivetrain.pathSetup(modifier, true);
    }

    protected void execute() {
        Robot.drivetrain.pathSetup(modifier, true);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
