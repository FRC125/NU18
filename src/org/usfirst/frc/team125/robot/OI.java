package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team125.robot.commands.DriveArcadeCmd;
import org.usfirst.frc.team125.robot.commands.DriveArcadeWithHoldHeadingCmd;
import org.usfirst.frc.team125.robot.commands.DrivePathCmd;

public class OI {
    private static final double STICK_DEADBAND = 0.005;

    // Controllers
    private Joystick driverPad = new Joystick(0);
    private Joystick operatorPad = new Joystick(1);

    private Button driveHoldHeading = new JoystickButton(driverPad, 5);

    public OI() {
        driveHoldHeading.whileHeld(new DriveArcadeWithHoldHeadingCmd());
        driveHoldHeading.whenReleased(new DriveArcadeCmd());
    }

    private static double stickDeadband(double value, double deadband, double center) {
        return (value < (center + deadband) && value > (center - deadband)) ? center : value;
    }

    public double getDriverLeftStickY() { return stickDeadband(this.driverPad.getRawAxis(1), STICK_DEADBAND, 0.0); }

    public double getDriverLeftStickX() {
        return stickDeadband(this.driverPad.getRawAxis(0), STICK_DEADBAND, 0.0);
    }

    public double getDriverRightStickY() { return stickDeadband(this.driverPad.getRawAxis(5), STICK_DEADBAND, 0.0); }

    public double getDriverRightStickX() {
        return stickDeadband(this.driverPad.getRawAxis(4), STICK_DEADBAND, 0.0);
    }

    public double getDriverTriggerSum() {
        return this.driverPad.getRawAxis(3) - this.driverPad.getRawAxis(2); //TODO: Check Axis (Right - Left)
    }

}
