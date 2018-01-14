/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

import java.lang.reflect.Array;

import org.usfirst.frc.team125.robot.subsystems.DoubleLift;
import org.usfirst.frc.team125.robot.subsystems.Intake;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	public static Intake intake = new Intake();
	public static DoubleLift doubleLift = new DoubleLift();

	public static OI oi;

	public char[] autoData = new char[3];

	@Override
	public void robotInit() {
		oi = new OI();

	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		//1st switch position
		if(gameData.charAt(0) == 'L' ) {
			//Auto Code for left side
		} else {
			//Auto Code for right side
		}
		
		//scale position
		if (gameData.charAt(1) == 'L') {
			//Auto Code for left side
		} else {
			//Auto code for right side	
		}
		
		//2nd switch position
		if (gameData.charAt(2) == 'L') {
			//Auto code for left side
		} else {
			//Auto code for right side
		}
 	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}

}
