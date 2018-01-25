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

	private Solenoid lift = new Solenoid(RobotMap.DOUBLELIFT_LIFTER);
	private Solenoid release = new Solenoid(RobotMap.DOUBLELIFT_RELEASE);
	
	public DoubleLift() {
		this.lift.set(false);
		this.release.set(false);
	}
	
	public void releaseCarrier() {
		this.release.set(true);
	} // TODO: Check the .set()
	
	public void lift() {
		this.lift.set(true);
	} // TODO: Check the .set()
	
	@Override
	protected void initDefaultCommand() {
	}

}
