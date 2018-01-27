package org.usfirst.frc.team125.robot;

import org.usfirst.frc.team125.robot.commands.CubeLift.*;
import org.usfirst.frc.team125.robot.commands.Drivetrain.*;
import org.usfirst.frc.team125.robot.commands.DoubleLift.*;
import org.usfirst.frc.team125.robot.commands.Intake.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team125.robot.util.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//Controllers
	public Joystick driverPad = new Joystick(0);
    public Joystick opPad = new Joystick(1);

	/* Operator Control */
    public Button runIntakeForward = new JoystickButton(opPad, JoystickMap.RB);
    public Button runIntakeBackward = new JoystickButton(opPad, JoystickMap.LB);

	//Intake Controls
	private Button forwardIntakeButton = new JoystickButton(opPad, 1);
	private Button reverseIntakeButton = new JoystickButton(opPad, 2);
	private Button releaseCarrierButton = new JoystickButton(opPad, 3);
	private Button retractCarrierButton = new JoystickButton(opPad, 4);
	private Button changeClampButton = new JoystickButton(opPad, 5);
	private Button changeGrabberButton = new JoystickButton(driverPad, 1);
	private Button openGrabberButton = new JoystickButton(driverPad, 2);
	private Button closeGrabberButton = new JoystickButton(driverPad, 3);

	private Button checkSmartIntake = new JoystickButton(driverPad, 4);

    /* Driver Control */
	private Button driveHoldHeading = new JoystickButton(driverPad, JoystickMap.LB);

	private static final double STICK_DEADBAND = 0.005;
	
	public OI() {

		//Intake
		runIntakeForward.whileHeld(new RunIntakeForwardCmd());
		runIntakeBackward.whileHeld(new RunIntakeReverseCmd());
        
		//Clamp
		this.checkSmartIntake.whileHeld(new UpdateCubeSwitchCmd());
		
		//Carrier
		this.releaseCarrierButton.whenPressed(new ReleaseCarrierCmd());

	    //Hold heading
		driveHoldHeading.whileHeld(new DriveArcadeWithHoldHeadingCmd());
		driveHoldHeading.whenReleased(new DriveArcadeCmd());
	}


	private static double stickDeadband(double value, double deadband, double center) {
		return (value < (center + deadband) && value > (center - deadband)) ? center : value;
	}

	public double getDriverLeftStickY() {
		return stickDeadband(this.driverPad.getRawAxis(1), STICK_DEADBAND, 0.0);
	}

	public double getDriverLeftStickX() {
		return stickDeadband(this.driverPad.getRawAxis(0), STICK_DEADBAND, 0.0);
	}

	public double getDriverRightStickY() {
		return stickDeadband(this.driverPad.getRawAxis(5), STICK_DEADBAND, 0.0);
	}

	public double getDriverRightStickX() {
		return stickDeadband(this.driverPad.getRawAxis(4), STICK_DEADBAND, 0.0);
	}

	public double getDriverTriggerSum() {
		return this.driverPad.getRawAxis(3) - this.driverPad.getRawAxis(2); //TODO: Check Axis (Right - Left)
	}

}

