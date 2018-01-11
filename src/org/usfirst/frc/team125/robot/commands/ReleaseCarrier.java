package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReleaseCarrier extends Command{
	public ReleaseCarrier() {
		requires(Robot.carrier);
	}
	
	protected void initialize() {
		
	}
	
	protected void excecute() {
		Robot.carrier.releaseCarrier();
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void inturrupted() {
		
	}

}
