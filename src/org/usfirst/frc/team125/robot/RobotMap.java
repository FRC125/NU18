package org.usfirst.frc.team125.robot;

public class RobotMap {

    /*
    CTRE Can Devices
     */
    //Drivetrain Motors TODO: Make sure these are correspondant to the actual drivetrain motors on webdash
    public static final int LEFT_DRIVE_MAIN = 1;
    public static final int LEFT_DRIVE_SLAVE_A = 2;
    public static final int LEFT_DRIVE_SLAVE_B = 3;
    public static final int RIGHT_DRIVE_MAIN = 4;
    public static final int RIGHT_DRIVE_SLAVE_A = 5;
    public static final int RIGHT_DRIVE_SLAVE_B = 6;

    //Intake Motors
    public static final int INTAKE_RIGHT = 54;
    public static final int INTAKE_LEFT = 53;

    // Elevator Motors
    public static final int ELEVATOR = 52;
    public static final int ELEVATOR_SLAVE_A = 51;
    public static final int ELEVATOR_SLAVE_B = 50;


    /*
    PCM Devices
     */
    //Double Lift
    public static final int DOUBLELIFT_LIFTER_FORWARD = 7;
    public static final int DOUBLELIFT_LIFTER_REVERSE = 6;
    public static final int DOUBLELIFT_RELEASE = 5;

    //Intake Solenoids
    public static final int INTAKE_CLAMP = 4;
    public static final int INTAKE_RETRACT_FORWARD = 3;
    public static final int INTAKE_RETRACT_REVERSE = 2;

    //Cube Lift
    public static final int ELEVATOR_CLAMP = 1;
    public static final int ELEVATOR_RELEASE = 0;


    //Digital Input
    public static final int INTAKE_LIMIT_SWITCH = 0;

}
