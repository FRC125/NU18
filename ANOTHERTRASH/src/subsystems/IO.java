package subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class IO {
	Joystick jdrive = new Joystick(0); 
	public Button buttonIntake = new JoystickButton(jdrive, 1);
	public Button buttonIntakeReverse = new JoystickButton(jdrive, 2);
}

/*public IO {
	buttonIntake.whileHeld(new )*/
	

