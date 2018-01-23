package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team125.robot.commands.Intake.RunIntakeForwardCmd;
import org.usfirst.frc.team125.robot.commands.Intake.RunIntakeReverseCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.*;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DriveArcadeWithHoldHeadingCmd;
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
    public Button runIntakeForward = new JoystickButton(opPad, joystickMap.RB);
    public Button runIntakeBackward = new JoystickButton(opPad, joystickMap.LB);


    /* Driver Control */
	private Button driveHoldHeading = new JoystickButton(driverPad, joystickMap.LB);

	public OI() {
	    runIntakeForward.whileHeld(new RunIntakeForwardCmd());
	    runIntakeBackward.whileHeld(new RunIntakeReverseCmd());
		driveHoldHeading.whileHeld(new DriveArcadeWithHoldHeadingCmd());
		driveHoldHeading.whenReleased(new DriveArcadeCmd());
	}

    private static final double STICK_DEADBAND = 0.005;

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

