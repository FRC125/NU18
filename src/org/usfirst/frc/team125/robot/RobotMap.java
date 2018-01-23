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
    public static final int DOUBLELIFT_LIFTER_FORWARD = 8;
    public static final int DOUBLELIFT_LIFTER_REVERSE = 7;
    public static final int DOUBLELIFT_RELEASE = 6;

    //Intake Solenoids
    public static final int INTAKE_CLAMP = 5;
    public static final int INTAKE_RETRACT_FORWARD = 4;
    public static final int INTAKE_RETRACT_REVERSE = 3;

    //Cube Lift
    public static final int ELEVATOR_CLAMP = 2;
    public static final int ELEVATOR_RELEASE = 1;


    //Digital Input
    public static final int INTAKE_LIMIT_SWITCH = 0;

}
