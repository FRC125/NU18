package org.usfirst.frc.team125.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * The mechansim to doubleLifter another robot (including a seperate release)
 */
public class DoubleLift extends Subsystem{

	private DoubleSolenoid doubleLifter = new DoubleSolenoid(RobotMap.DOUBLELIFT_LIFTER_FORWARD, RobotMap.DOUBLELIFT_LIFTER_REVERSE);
	private Solenoid release = new Solenoid(RobotMap.DOUBLELIFT_RELEASE);
	
	public DoubleLift() {
		this.doubleLifter.set(DoubleSolenoid.Value.kForward);
		this.release.set(false);
	}
	
	public void releaseCarrier() {
		this.release.set(true);
	} // TODO: Check the .set()

	public void unreleaseCarrier() {
		this.release.set(false);
	}
	
	public void dropLift() {
		this.doubleLifter.set(DoubleSolenoid.Value.kReverse);
	}

	public void liftLift() {
		this.doubleLifter.set(DoubleSolenoid.Value.kForward);
	}
	
	@Override
	protected void initDefaultCommand() {
	}

}
