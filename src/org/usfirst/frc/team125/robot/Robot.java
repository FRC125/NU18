package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import java.lang.reflect.Array;

import org.usfirst.frc.team125.robot.commands.CubeLift.ResetEncoderCmd;
import org.usfirst.frc.team125.robot.commands.Intake.UpdateCubeSwitchCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.subsystems.DoubleLift;
import org.usfirst.frc.team125.robot.subsystems.Intake;
import org.usfirst.frc.team125.robot.subsystems.Drivetrain;
import org.usfirst.frc.team125.robot.commands.Drivetrain.*;
import org.usfirst.frc.team125.robot.util.AutoPaths;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

public class Robot extends IterativeRobot {

    public static Drivetrain drivetrain = new Drivetrain();
    public static Intake intake = new Intake();
    public static DoubleLift doubleLift = new DoubleLift();
    public static CubeLift cubeLift = new CubeLift();

    public static OI oi;

	Command autoCommand = new AutoCommand();

    @Override
    public void robotInit() {
        oi = new OI();
        drivetrain.timer.start();

    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        updateSmartdashboard();
        cubeLift.calibrateElevator();
        Scheduler.getInstance().run();
    }


	@Override
	public void autonomousInit() {
		/* String gameData = DriverStation.getInstance().getGameSpecificMessage(); */ // HOW TO GET GAME DATA
		autoCommand.start();
	}

    @Override
    public void autonomousPeriodic(){
        cubeLift.calibrateElevator();
        updateSmartdashboard();
        Scheduler.getInstance().run();
    }

	@Override
	public void teleopInit() {

	}

    public void teleopPeriodic() {
        updateSmartdashboard();
        cubeLift.calibrateElevator();
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {

    }

    private boolean started = false;
    public void updateSmartdashboard() {
        SmartDashboard.putNumber("left dt Enc", this.drivetrain.getEncoderRawLeft());
        SmartDashboard.putNumber("right dt Enc", this.drivetrain.getEncoderRawRight());
        SmartDashboard.putNumber("left dt Meters", this.drivetrain.getEncoderDistanceMetersLeft());
        SmartDashboard.putNumber("right dt Meters", this.drivetrain.getEncoderDistanceMetersRight());
        SmartDashboard.putNumber("left dt Speed", this.drivetrain.getLeftVelocity());
        SmartDashboard.putNumber("right dt Speed", this.drivetrain.getRightVelocity());
        SmartDashboard.putNumber("gyro angle", this.drivetrain.getAngle());
        SmartDashboard.putNumber("elevator enc val", this.cubeLift.getEncPos());
        this.drivetrain.updateAccelDashboard();
        this.cubeLift.updatePIDFOnDashboard();
        this.cubeLift.updatePIDFFromDashboard();
        SmartDashboard.putBoolean("Hall Effect Sensor", this.cubeLift.gethallEffectSensor());

        if(this.cubeLift.gethallEffectSensor()){
            Command cmd = new ResetEncoderCmd();
            cmd.start();
            started = true;
        }else if(started) {
            started = false;
        }
        //333BIG KYLE MEME
        //doodie 8
    }
}
