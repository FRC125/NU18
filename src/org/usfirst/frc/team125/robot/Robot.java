package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import java.lang.reflect.Array;
import org.usfirst.frc.team125.robot.subsystems.DoubleLift;
import org.usfirst.frc.team125.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team125.robot.subsystems.CubeLift;

import org.usfirst.frc.team125.robot.subsystems.Drivetrain;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {

    public static Drivetrain dt = new Drivetrain();
    public static Intake intake = new Intake();
    public static DoubleLift doubleLift = new DoubleLift();
	public static CubeLift boyfriend = new CubeLift();

    public char[] autoData = new char[3];

    public static OI oi;

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
        SmartDashboard.putNumber("Elevator Encoder Value", boyfriend.getEncPos());
    }

    @Override
    public void autonomousInit() {
        String gameData = DriverStation.getInstance().getGameSpecificMessage();
        //1st switch position
        if (gameData.charAt(0) == 'L') {
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
            SmartDashboard.putNumber("Elevator Encoder Value", boyfriend.getEncPos());
        }

        @Override
        public void testPeriodic() {
        }
        
}

