package org.usfirst.frc.team125.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team125.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team125.robot.util.DebouncedBoolean;

public class Intake extends Subsystem {
	
	//intake motors
	private TalonSRX intakeL = new TalonSRX(RobotMap.INTAKE_LEFT);
	private TalonSRX intakeR = new TalonSRX(RobotMap.INTAKE_RIGHT);
	//switch to TalonSRX  when using protoBoard
	
	private DoubleSolenoid intakePiston = new DoubleSolenoid(RobotMap.INTAKE_RETRACT_FORWARD, RobotMap.INTAKE_RETRACT_REVERSE);
	private Solenoid clamp = new Solenoid(RobotMap.INTAKE_CLAMP);

	private DigitalInput smartIntake = new DigitalInput(RobotMap.INTAKE_LIMIT_SWITCH);
	private static final double minimumSmartIntakeTime = 2.0; // Is 2 seconds too long???
	private DebouncedBoolean smartIntakeDebouncer = new DebouncedBoolean(minimumSmartIntakeTime);

	private static final double RIGHT_INTAKE_SPEED = 1.0;



	public static final double INTAKE_POWER = 1.0;

	public Intake() {
		
		//Left side
		this.intakeL.configPeakOutputForward(1.0, 0);
		this.intakeL.configPeakOutputReverse(-1.0, 0);
		this.intakeL.configNominalOutputForward(0.0, 0);
		this.intakeL.configNominalOutputReverse(0.0, 0);
		
		//Right side
		this.intakeR.configPeakOutputForward(RIGHT_INTAKE_SPEED, 0);
		this.intakeR.configPeakOutputReverse(-RIGHT_INTAKE_SPEED, 0);
		this.intakeR.configNominalOutputForward(0.0, 0);
		this.intakeR.configNominalOutputReverse(0.0, 0);

		this.intakeL.setNeutralMode(NeutralMode.Coast);
		this.intakeR.setNeutralMode(NeutralMode.Coast);

		this.intakePiston.set(DoubleSolenoid.Value.kReverse); // TODO: Check if this is right...
		this.clamp.set(false); // TODO: Check .set()
	}

	public void runIntake(double power) {
		this.intakeL.set(ControlMode.PercentOutput, power);
		this.intakeR.set(ControlMode.PercentOutput, power);
	}
	
	public void runIntakeReversed(double power) {
		this.intakeL.set(ControlMode.PercentOutput, power);
		this.intakeR.set(ControlMode.PercentOutput, power);
	}
	
	public void stopIntake() {
		this.intakeL.set(ControlMode.PercentOutput, 0);
		this.intakeR.set(ControlMode.PercentOutput, 0);
	}
	
	public void openClamp(){
		this.clamp.set(false);
	}
	
	public void closeClamp(){
		this.clamp.set(true);
	}

	public void updateCubeSwitch(boolean val) { // Its going to have to be called during all robot periodic...
		smartIntakeDebouncer.update(val);
		if(smartIntakeDebouncer.get()){
			this.pistonIn();
		} else {
			this.pistonOut();
		}
	}
	
	public void pistonIn() {
		this.intakePiston.set(DoubleSolenoid.Value.kForward);
	}
	
	public void pistonOut() {
		this.intakePiston.set(DoubleSolenoid.Value.kReverse);
	}

	@Override
	protected void initDefaultCommand() {
	}

}
