package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import java.lang.reflect.Array;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.subsystems.DoubleLift;
import org.usfirst.frc.team125.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team125.robot.subsystems.Drivetrain;

public class Robot extends IterativeRobot {

    public static Drivetrain drivetrain = new Drivetrain();
    public static Intake intake = new Intake();
    public static DoubleLift doubleLift = new DoubleLift();
    public static CubeLift cubeLift = new CubeLift();

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
        updateShuffle();
        
    }

    @Override
    public void autonomousInit() {
         /* String gameData = DriverStation.getInstance().getGameSpecificMessage(); */ // HOW TO GET GAME DATA
    	 updateShuffle();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        updateShuffle();
    }

    @Override
    public void teleopInit() {
    	 
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateShuffle();
    }

    @Override
    public void testPeriodic() {

    }
    public void updateShuffle() {
    	SmartDashboard.putNumber("Right Drive Encoder", drivetrain.getEncoderRawRight());
        SmartDashboard.putNumber("Left Drive Encoder", drivetrain.getEncoderRawLeft());
        SmartDashboard.putNumber("Left Distance Meters",drivetrain.getEncoderDistanceMetersLeft());
        SmartDashboard.putNumber("Right distance meters", drivetrain.getEncoderDistanceMetersRight());
    }
        
}
