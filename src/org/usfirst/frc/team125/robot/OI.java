package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

    // Controllers
    public Joystick driverPad = new Joystick(0);
    public Joystick operatorPad = new Joystick(1);


    public OI() {

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

    public double getDriverTriggerSum() {
        return this.driverPad.getRawAxis(3) - this.driverPad.getRawAxis(2); //TODO: Check Axis (Right - Left)
    }

}
