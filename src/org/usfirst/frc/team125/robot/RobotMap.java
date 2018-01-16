/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team125.robot;

public class RobotMap {
	
	//Intake Motors
	public static final int INTAKE_RIGHT = 2;
	public static final int INTAKE_LEFT = 3;
	
	//Carrier Solenoids
	public static final int DOUBLELIFT_LIFTER = 2;
	public static final int DOUBLELIFT_RELEASE = 3;

	//Intake Solenoids
	public static final int INTAKE_CLAMP = 0;
	public static final int INTAKE_RETRACT_FORWARD = 4;
	public static final int INTAKE_RETRACT_REVERSE = 1;

	//Digital Input
	public static final int INTAKE_LIMIT_SWITCH = 5;
  
  //Drivetrain CAN Devices TODO: Make sure these are correspondant to the actual drivetrain motors on webdash
  public static final int LEFT_DRIVE_MAIN = 0;
  public static final int LEFT_DRIVE_SLAVE_A = 1;
  public static final int LEFT_DRIVE_SLAVE_B = 2;
  public static final int RIGHT_DRIVE_MAIN = 3;
  public static final int RIGHT_DRIVE_SLAVE_A = 4;
  public static final int RIGHT_DRIVE_SLAVE_B = 6;
  
}
