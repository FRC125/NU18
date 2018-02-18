package subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Intake {
	TalonSRX motorintake1 = new TalonSRX(1);
	TalonSRX motorintake2 = new TalonSRX(2);
	
	public void takein() {
		this.motorintake1.configPeakOutputForward(1, 0);
		this.motorintake2.configPeakOutputReverse(-1, 0);
		motorintake1.set(ControlMode.PercentOutput, 1);
		
	}

}
