package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class SetupPathCmd extends Command {

    TankModifier modifier;

    public SetupPathCmd(TankModifier modifier) {
        requires(Robot.dt);
        this.modifier = modifier;
    }

    protected void initialize() {
        Robot.dt.pathSetup(modifier, true);
    }

    protected void execute() {
        Robot.dt.pathSetup(modifier, true);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
