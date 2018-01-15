package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    private static final double STICK_DEADBAND = 0.005;

    // Controllers
    private Joystick driverPad = new Joystick(0);
    private Joystick operatorPad = new Joystick(1);


    public OI() {

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
