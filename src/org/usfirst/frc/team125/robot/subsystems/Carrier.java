package org.usfirst.frc.team125.robot.subsystems;

import org.usfirst.frc.team125.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Carrier extends Subsystem{

	private Solenoid leftPlatformSolenoid = new Solenoid(0, 0);
	private Solenoid rightPlatformSolenoid = new Solenoid(1, 0);
	
	public Carrier() {
		
		//Left side of Solenoid
		//true = out
		//false = in
		this.leftPlatformSolenoid.set(true);
		this.leftPlatformSolenoid.set(false);
		
		//Right side of Solenoid 
		this.rightPlatformSolenoid.set(true);
		this.rightPlatformSolenoid.set(false);
		
	}
	
	public void releaseCarrier() {
		this.leftPlatformSolenoid.set(true);
		this.rightPlatformSolenoid.set(true);
	}
	
	public void retractCarrier() {
		this.leftPlatformSolenoid.set(false);
		this.rightPlatformSolenoid.set(false);
	}
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
