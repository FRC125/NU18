package org.usfirst.frc.team125.robot;

import org.usfirst.frc.team125.robot.commands.ChangeGrabberPositionCMD;
import org.usfirst.frc.team125.robot.commands.CloseGrabberCMD;
import org.usfirst.frc.team125.robot.commands.OpenGrabberCMD;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

    // Controllers
    public Joystick driverPad = new Joystick(0);
    public Joystick operatorPad = new Joystick(1);
    
	private Button changeGrabberButton = new JoystickButton(operatorPad, 1);
	private Button openGrabberButton = new JoystickButton(operatorPad, 2);
	private Button closeGrabberButton = new JoystickButton(operatorPad, 3);

    public OI() {
    	this.changeGrabberButton.whenPressed(new ChangeGrabberPositionCMD());
    	this.openGrabberButton.whenPressed(new OpenGrabberCMD());
    	this.closeGrabberButton.whenPressed(new CloseGrabberCMD());

    }

    public static double stickDeadband(double value, double deadband, double center) {
        return (value < (center + deadband) && value > (center - deadband)) ? center : value;
    }

    public double getDriverLeftStickY() { return stickDeadband(this.driverPad.getRawAxis(1), 0.005, 0.0); }

    public double getDriverLeftStickX() {
        return stickDeadband(this.driverPad.getRawAxis(0), 0.005, 0.0);
    }

    public double getDriverRightStickY() {
        return stickDeadband(this.driverPad.getRawAxis(5), 0.005, 0.0);
    }

    public double getDriverRightStickX() {
        return stickDeadband(this.driverPad.getRawAxis(4), 0.005, 0.0);
    }

}