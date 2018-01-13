package org.usfirst.frc.team125.robot.subsystems;

import org.usfirst.frc.team125.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * 
 * The mechansim to lift another robot (including a seperate release)
 */
public class DoubleLift extends Subsystem{

	private Solenoid leftPlatformSolenoid = new Solenoid(0, 0);
	
	public DoubleLift() {
		
		//Left side of Solenoid
		//true = out
		//false = in
		this.leftPlatformSolenoid.set(true);
		this.leftPlatformSolenoid.set(false);
		
	
	}
	
	public void releaseCarrier() {
		this.leftPlatformSolenoid.set(true);
	}
	
	public void retractCarrier() {
		this.leftPlatformSolenoid.set(false);
	}
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
