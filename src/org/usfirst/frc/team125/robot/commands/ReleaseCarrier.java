package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReleaseCarrier extends Command{
	public ReleaseCarrier() {
		requires(Robot.carrier);
	}
	
	protected void initialize() {
		Robot.carrier.releaseCarrier();
	}
	
	protected void excecute() {

	}
	
	
	@Override
	protected boolean isFinished() {
		
		return true;
	}
	
	protected void end() {
		
	}
	
	protected void inturrupted() {
		
	}

}
