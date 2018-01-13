/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team125.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.subsystems.Intake;

/**
 * An example command.  You can replace me with your own command.
 */
public class RunIntakeForward extends Command {
	public RunIntakeForward() {
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.intake.runIntake(.5);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}


	@Override
	protected void end() {
		Robot.intake.stopIntake();
	}

	@Override
	protected void interrupted() {
	}
}
