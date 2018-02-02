package org.usfirst.frc.team125.robot;

public class RobotMap {

    // TODO: Make sure these are right

    //Set to 99 so that they dont match up with anything currently and can be changed later

    //CAN Devices
    public static final int RIGHT_ELEVATOR_MAIN = 7;
    public static final int RIGHT_ELEVATOR_SLAVE = 9;
    public static final int LEFT_ELEVATOR_SLAVE_A = 8;
    public static final int LEFT_ELEVATOR_SLAVE_B = 10;

    //Pneumatics
    public static final int GRABBERS = 0;
    public static final int RELEASE_PIN = 1;

    //Intake Motors
    public static final int INTAKE_RIGHT = 21;
    public static final int INTAKE_LEFT = 20;

    //Carrier Solenoids
    public static final int DOUBLELIFT_LIFTER_FORWARD = 2;
    public static final int DOUBLELIFT_LIFTER_REVERSE = 3;
    public static final int DOUBLELIFT_RELEASE = 4;

    //Intake Solenoids
    public static final int INTAKE_RETRACT_FORWARD = 5;
    public static final int INTAKE_RETRACT_REVERSE = 6;

    //Digital Input
    public static final int INTAKE_LIMIT_SWITCH = 0;
    public static final int CUBELIFT_LIMIT_SWITCH = 1;

    //Drivetrain CAN Devices TODO: Make sure these are correspondant to the actual drivetrain motors on webdash
    public static final int LEFT_DRIVE_MAIN = 1;
    public static final int LEFT_DRIVE_SLAVE_A = 2;
    public static final int LEFT_DRIVE_SLAVE_B = 3;
    public static final int RIGHT_DRIVE_MAIN = 4;
    public static final int RIGHT_DRIVE_SLAVE_A = 5;
    public static final int RIGHT_DRIVE_SLAVE_B = 6;

}