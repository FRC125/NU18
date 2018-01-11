/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team125.robot;

import org.usfirst.frc.team125.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	//Controllers
	public Joystick opPad = new Joystick(1);
	public Joystick driverPad = new Joystick(0);
	
	//OpPad Buttons
	
	//Intake Controls
	private Button forwardIntakeButton = new JoystickButton(opPad, 1);
	private Button reverseIntakeButton = new JoystickButton(opPad, 2);
	private Button releaseCarrierButton = new JoystickButton(opPad, 3);
	private Button retractCarrierButton = new JoystickButton(opPad, 4);
	
	
	public OI() {
		
		//intake
		this.forwardIntakeButton.whileHeld(new RunIntakeForward());
		this.reverseIntakeButton.whileHeld(new RunIntakeReverse());
		
		//Carrier
		this.releaseCarrierButton.whenPressed(new ReleaseCarrier());
		this.retractCarrierButton.whenPressed(new RetractCarrier());
	}
	
}

