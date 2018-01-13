package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RunIntakeReverse extends Command{
	public RunIntakeReverse() {
		requires(Robot.intake);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	protected void excecute() {
		Robot.intake.runIntakeReversed(0.5);
	}

	@Override
	protected boolean isFinished() {
	
		return false;
	}
	
	@Override
	protected void end() {
		Robot.intake.stopIntake();
	}
	
	protected void inturrupted() {
		
	}

}
