package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.subsystems.Intake;

public class RunIntakeReverseCMD extends Command{

	public RunIntakeReverseCMD() {
		requires(Robot.intake);
	}
	
	@Override
	protected void initialize() {
	}
	
	protected void excecute() {
		Robot.intake.runIntakeReversed(Intake.INTAKE_POWER);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.intake.stopIntake();
	}
	
	protected void interrupted() {
		end();
	}

}
