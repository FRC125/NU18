package org.usfirst.frc.team125.robot;

public class RobotMap {

    /*
    Can Devices
     */
    //Drivetrain
    public static final int LEFT_DRIVE_MAIN = 1;
    public static final int LEFT_DRIVE_SLAVE_A = 2;
    public static final int LEFT_DRIVE_SLAVE_B = 3;
    public static final int RIGHT_DRIVE_MAIN = 4;
    public static final int RIGHT_DRIVE_SLAVE_A = 5;
    public static final int RIGHT_DRIVE_SLAVE_B = 6;
    //Elevator
    public static final int RIGHT_ELEVATOR_MAIN = 7;
    public static final int RIGHT_ELEVATOR_SLAVE = 9;
    public static final int LEFT_ELEVATOR_SLAVE_A = 8;
    public static final int LEFT_ELEVATOR_SLAVE_B = 10;
    //Intake
    public static final int INTAKE_RIGHT = 21;
    public static final int INTAKE_LEFT = 20;

    /*
    PCM Device
     */
    //Single Acting Solenoids
    public static final int GRABBERS = 3;
    public static final int RELEASE_PIN = 0;
    public static final int DOUBLELIFT_RELEASE = 2;
    public static final int DOUBLELIFT_LIFTER = 1;
    public static final int PUNCHER = 6;
    //Double Acting Solenoids
    public static final int INTAKE_RETRACT_FORWARD = 4;
    public static final int INTAKE_RETRACT_REVERSE = 5;




    /*
    Other
     */
    //Digital Input
    public static final int INTAKE_LIMIT_SWITCH = 0;
    public static final int CUBELIFT_HALL_EFFECT_SENSOR = 5;
}