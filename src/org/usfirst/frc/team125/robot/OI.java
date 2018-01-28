package org.usfirst.frc.team125.robot;

import org.usfirst.frc.team125.robot.commands.CubeLift.*;
import org.usfirst.frc.team125.robot.commands.Drivetrain.*;
import org.usfirst.frc.team125.robot.commands.DoubleLift.*;
import org.usfirst.frc.team125.robot.commands.Groups.DropAndReleaseCarrier;
import org.usfirst.frc.team125.robot.commands.Intake.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team125.robot.util.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command Groups that allow control of the robot.
 */
public class OI {

	//Controllers
	public Joystick driverPad = new Joystick(0);
    public Joystick opPad = new Joystick(1);

	/* Operator Control */
    public Button runIntakeForward = new JoystickButton(opPad, JoystickMap.RB);
    public Button runIntakeBackward = new JoystickButton(opPad, JoystickMap.LB);
    public Button openClamp = new JoystickButton(opPad, JoystickMap.A);
    public Button closeClamp = new JoystickButton(opPad, JoystickMap.B);
	public Button readyCarrier = new JoystickButton(opPad, JoystickMap.X);
	public Button liftCarrier = new JoystickButton(opPad, JoystickMap.Y);

	private Button checkSmartIntake = new JoystickButton(driverPad, 4);

    /* Driver Control */
	private Button driveHoldHeading = new JoystickButton(driverPad, JoystickMap.LB);

	private static final double STICK_DEADBAND = 0.005;
	
	public OI() {

		//Intake
		runIntakeForward.whileHeld(new RunIntakeForwardCmd());
		runIntakeBackward.whileHeld(new RunIntakeReverseCmd());
        
		//Clamp
		checkSmartIntake.whileHeld(new UpdateCubeSwitchCmd());
		openClamp.whileHeld(new OpenClampCmd());
		closeClamp.whileHeld(new CloseClampCmd());

		//Carrier
		readyCarrier.whenPressed(new DropAndReleaseCarrier());
		liftCarrier.whenPressed(new LiftCarrierCmd());

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

