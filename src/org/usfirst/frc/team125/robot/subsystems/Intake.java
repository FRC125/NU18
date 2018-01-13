package org.usfirst.frc.team125.robot.subsystems;

import org.usfirst.frc.team125.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	//intake motors
	private TalonSRX intakeL = new TalonSRX(RobotMap.INTAKE_LEFT);
	private TalonSRX intakeR = new TalonSRX(RobotMap.INTAKE_RIGHT);
	private DoubleSolenoid intakePiston = new DoubleSolenoid(1,1);
	
	public Intake(){
		
		this.intakeL.configPeakOutputForward(1.0, 0);
		this.intakeL.configPeakOutputReverse(-1.0, 0);
		this.intakeL.configNominalOutputForward(0.0, 0);
		this.intakeL.configNominalOutputReverse(0.0, 0);
		
		this.intakeR.configPeakOutputForward(1.0, 0);
		this.intakeR.configPeakOutputReverse(-1.0, 0);
		this.intakeR.configNominalOutputForward(0.0, 0);
		this.intakeR.configNominalOutputReverse(0.0, 0);
		
	}
	
	public void runIntake(double power) {
		this.intakeL.set(ControlMode.PercentOutput, power);
		this.intakeR.set(ControlMode.PercentOutput, -power);
	}
	
	public void runIntakeReversed(double power) {
		this.intakeL.set(ControlMode.PercentOutput, -power);
		this.intakeR.set(ControlMode.PercentOutput, power);
	}
	
	public void stopIntake() {
		this.intakeL.set(ControlMode.PercentOutput, 0);
		this.intakeR.set(ControlMode.PercentOutput, 0);
	}
	
	public void pistonIn() {
		this.intakePiston.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void pistonOut() {
		this.intakePiston.set(DoubleSolenoid.Value.kForward);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	

}
