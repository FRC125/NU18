package org.usfirst.frc.team125.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The mechansim to doubleLifter another robot (including a seperate release)
 */
public class DoubleLift extends Subsystem {

    private DoubleSolenoid doubleLifter = new DoubleSolenoid(RobotMap.DOUBLELIFT_LIFTER_FORWARD, RobotMap.DOUBLELIFT_LIFTER_REVERSE);
    private Solenoid release = new Solenoid(RobotMap.DOUBLELIFT_RELEASE);
    private static final boolean RELEASE_CARRIER_SET = true;
    private static final boolean UNRELEASE_CARRIER_SET = false;
    private static final DoubleSolenoid.Value DROP_LIFT_VALUE = DoubleSolenoid.Value.kReverse;
    private static final DoubleSolenoid.Value LIFT_LIFT_VALUE = DoubleSolenoid.Value.kForward;

    public DoubleLift() {
        this.doubleLifter.set(LIFT_LIFT_VALUE); // We want it up
        this.release.set(false); // We want it not out, hard coded for safety
    }

    public void releaseCarrier() {
        this.release.set(RELEASE_CARRIER_SET);
    }

    public void unreleaseCarrier() { this.release.set(UNRELEASE_CARRIER_SET); }

    public void dropLift() {
        this.doubleLifter.set(DROP_LIFT_VALUE);
    }

    public void liftLift() {
        this.doubleLifter.set(LIFT_LIFT_VALUE);
    }

    @Override
    protected void initDefaultCommand() {
    }
}
