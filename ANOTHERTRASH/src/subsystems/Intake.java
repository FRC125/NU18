package subsystems;

import org.usfirst.frc.team1234567.robot.Robot;
import org.usfirst.frc.team1234567.robot.RobotValues;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
//extend subsystems
public class Intake extends Subsystem{
	TalonSRX motorintake1 = new TalonSRX(1);
	TalonSRX motorintake2 = new TalonSRX(2);
	
	public Intake() {
		//motor1 
		this.motorintake1.configPeakOutputForward(1, 0);
		this.motorintake1.configPeakOutputReverse(-1, 0);
		this.motorintake1.configNominalOutputForward(0.0, 0);
		this.motorintake1.configNominalOutputReverse(0.0, 0);
		
		//motor2 
		this.motorintake2.configPeakOutputForward(1, 0);
		this.motorintake2.configPeakOutputReverse(-1, 0);
		this.motorintake2.configNominalOutputForward(0.0, 0);
		this.motorintake2.configNominalOutputReverse(0.0, 0);
		
		//Neutral-mode
		
		this.motorintake1.setNeutralMode(NeutralMode.Coast);
		this.motorintake2.setNeutralMode(NeutralMode.Coast);
		
	}
	//run intakes
	public void runIntake() {
		motorintake1.set(ControlMode.PercentOutput, RobotValues.INTAKE_LEFT);//1 forward
		motorintake2.set(ControlMode.PercentOutput, - RobotValues.INTAKE_RIGHT);//0.75  reverse
	}
	//stop the intakes by setting neutral mode to brake 
	public void changeBrakeMode() {
		motorintake1.setNeutralMode(NeutralMode.Brake);
		motorintake2.setNeutralMode(NeutralMode.Brake);
	}
	public void runIntakeReverse() {
	
		motorintake1.set(ControlMode.PercentOutput, - RobotValues.INTAKE_LEFT); //reverse of runIntake
		motorintake2.set(ControlMode.PercentOutput, RobotValues.INTAKE_RIGHT);
	}
	public void stopIntake() {
		
		motorintake1.set(ControlMode.PercentOutput, 0.0);
		motorintake2.set(ControlMode.PercentOutput, 0.0);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	

}
