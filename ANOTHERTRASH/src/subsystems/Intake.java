package subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Intake {
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
		
		
	}
	//run intakes
	public void runIntake() {
		motorintake1.set(ControlMode.PercentOutput, 1.0);
		motorintake2.set(ControlMode.PercentOutput, 0.75);//0.75 max reverse
	}
	//stop the intakes by setting neutral mode to brake 
	public void stop() {
		motorintake1.setNeutralMode(NeutralMode.Brake);
		motorintake2.setNeutralMode(NeutralMode.Brake);
	}
	public void runIntakeReverse() {
	
		motorintake1.set(ControlMode.PercentOutput, -1.0);
		motorintake2.set(ControlMode.PercentOutput, -0.75);
	}
	public void stopIntake() {
		
		motorintake1.set(ControlMode.PercentOutput, 0.0);
		motorintake2.set(ControlMode.PercentOutput, 0.0);
	}
	

}
