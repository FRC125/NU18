package org.usfirst.frc.team125.robot;

public class RobotMap {

    /*
    CTRE Can Devices
     */
    //Drivetrain Motors TODO: Make sure these are correspondant to the actual drivetrain motors on webdash
    public static final int LEFT_DRIVE_MAIN = 60;
    public static final int LEFT_DRIVE_SLAVE_A = 59;
    public static final int LEFT_DRIVE_SLAVE_B = 58;
    public static final int RIGHT_DRIVE_MAIN = 57;
    public static final int RIGHT_DRIVE_SLAVE_A = 56;
    public static final int RIGHT_DRIVE_SLAVE_B =55;

    //Intake Motors
    public static final int INTAKE_RIGHT = 2;
    public static final int INTAKE_LEFT = 3;

    // Elevator Motors
    public static final int ELEVATOR = 54;
    public static final int ELEVATOR_SLAVE_A = 53;
    public static final int ELEVATOR_SLAVE_B = 52;


    /*
    PCM Devices
     */
    //Double Lift
    public static final int DOUBLELIFT_LIFTER_FORWARD = 0;
    public static final int DOUBLELIFT_LIFTER_REVERSE = 1;
    public static final int DOUBLELIFT_RELEASE = 2;

    //Intake Solenoids
    public static final int INTAKE_CLAMP = 3;
    public static final int INTAKE_RETRACT_FORWARD = 4;
    public static final int INTAKE_RETRACT_REVERSE = 5;

    //Cube Lift
    public static final int CLAMP = 6;
    public static final int ELEVATOR_RELEASE = 7;


    //Digital Input
    public static final int INTAKE_LIMIT_SWITCH = 0;

}