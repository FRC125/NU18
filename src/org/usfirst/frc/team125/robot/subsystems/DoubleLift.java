package org.usfirst.frc.team125.robot.subsystems;



import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team125.robot.RobotMap;

public class DoubleLift extends Subsystem {

    private Solenoid doubleLifter = new Solenoid(RobotMap.DOUBLELIFT_LIFTER);
    private Solenoid release = new Solenoid(RobotMap.DOUBLELIFT_RELEASE);
    private static final boolean RELEASE_CARRIER_SET = true;
    private static final boolean UNRELEASE_CARRIER_SET = false;
    private static final boolean DROP_LIFT_SET = true;
    private static final boolean LIFT_LIFT_SET = false;

    private boolean releaseToggle = false;
    private boolean liftToggle = false;

    public DoubleLift() {
        this.doubleLifter.set(false); // We want it up, hard coded for safety
        this.release.set(false); // We want it not out, hard coded for safety
    }

    public void releaseCarrier() {
        this.release.set(RELEASE_CARRIER_SET);
    }

    public void unreleaseCarrier() {
        this.release.set(UNRELEASE_CARRIER_SET);
    }

    public void toggleRelease() {
        this.releaseToggle = !releaseToggle;
        this.release.set(releaseToggle);
    }

    public void dropLift() {
        this.doubleLifter.set(DROP_LIFT_SET);
    }

    public void liftLift() {
        this.doubleLifter.set(LIFT_LIFT_SET);
    }

    public void toggleLift() {
        this.liftToggle = !liftToggle;
        this.doubleLifter.set(liftToggle);
    }


    @Override
    protected void initDefaultCommand() {
    }
}
