package org.usfirst.frc.team125.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import org.usfirst.frc.team125.robot.RobotMap;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team125.robot.commands.DriveTank;

/**
 * 4 Motor Drivetrain Subclass
 */
public class Drivetrain extends Subsystem {

    //Controllers
    private TalonSRX leftDrive = new TalonSRX(RobotMap.LEFT_DRIVE_B);
    private TalonSRX leftDriveSlave = new TalonSRX(RobotMap.LEFT_DRIVE_A);
    private TalonSRX rightDrive = new TalonSRX(RobotMap.RIGHT_DRIVE_B);
    private TalonSRX rightDriveSlave = new TalonSRX(RobotMap.RIGHT_DRIVE_A);

    ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    //Encoder Stuff
    EncoderFollower left;
    EncoderFollower right;

    //Timing
    public Timer timer = new Timer();

    public Drivetrain() {
        //Slave Control
        this.leftDriveSlave.follow(leftDrive);
        this.rightDriveSlave.follow(rightDrive);

        this.leftDrive.configPeakOutputForward(1.0, 0);
        this.leftDrive.configPeakOutputReverse(-1.0, 0);
        this.leftDrive.configNominalOutputForward(0.0, 0);
        this.leftDrive.configNominalOutputReverse(0.0, 0);
        this.leftDriveSlave.configPeakOutputForward(1.0, 0);
        this.leftDriveSlave.configPeakOutputReverse(-1.0, 0);
        this.leftDriveSlave.configNominalOutputForward(0.0, 0);
        this.leftDriveSlave.configNominalOutputReverse(0.0, 0);

        this.rightDrive.configPeakOutputForward(1.0, 0);
        this.rightDrive.configPeakOutputReverse(-1.0, 0);
        this.rightDrive.configNominalOutputForward(0.0, 0);
        this.rightDrive.configNominalOutputReverse(0.0, 0);
        this.rightDriveSlave.configPeakOutputForward(1.0, 0);
        this.rightDriveSlave.configPeakOutputReverse(-1.0, 0);
        this.rightDriveSlave.configNominalOutputForward(0.0, 0);
        this.rightDriveSlave.configNominalOutputReverse(0.0, 0);

        //Encoder
        this.leftDrive.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        this.rightDrive.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

        disableBreakMode();

        //Gyro
        gyro.reset();
        gyro.calibrate();
    }

    public void drive(double powLeft, double powRight) {
        this.leftDrive.set(ControlMode.PercentOutput, powLeft);
        this.rightDrive.set(ControlMode.PercentOutput, powRight);
    }

    public double getLeftVelocity() {
        return (leftDrive.getSelectedSensorVelocity(0) * Math.PI * DrivetrainProfiling.wheel_diameter) / (DrivetrainProfiling.ticks_per_rev)  * 10;
    }

    public double getRightVelocity() {
        return (rightDrive.getSelectedSensorVelocity(0) * Math.PI * DrivetrainProfiling.wheel_diameter) / (DrivetrainProfiling.ticks_per_rev) * 10;
    }

    public double getLeftAcceleration(double lastTime, double lastVelocity) {
        double deltaTime = timer.get() - lastTime;
        double deltaVelocity = getLeftVelocity() - lastVelocity;

        return deltaVelocity / deltaTime;
    }

    public double getRightAcceleration(double lastTime, double lastVelocity) {
        double deltaTime = timer.get() - lastTime;
        double deltaVelocity = getRightVelocity() - lastVelocity;

        return deltaVelocity / deltaTime;
    }

    public void enableBreakMode() {
        this.leftDrive.setNeutralMode(NeutralMode.Brake);
        this.rightDrive.setNeutralMode(NeutralMode.Brake);
    }

    public void disableBreakMode() {
        this.leftDrive.setNeutralMode(NeutralMode.Coast);
        this.rightDrive.setNeutralMode(NeutralMode.Coast);
    }

    public void resetEncoders() {
        this.leftDrive.setSelectedSensorPosition(0, 0, 0);
        this.rightDrive.setSelectedSensorPosition(0, 0, 0);
    }

    public double getEncoderDistanceMetersRight() {
        return (rightDrive.getSelectedSensorPosition(0) * Math.PI * DrivetrainProfiling.wheel_diameter) / DrivetrainProfiling.ticks_per_rev;
    }

    public double getEncoderDistanceMetersLeft() {
        return (leftDrive.getSelectedSensorPosition(0) * Math.PI * DrivetrainProfiling.wheel_diameter) / DrivetrainProfiling.ticks_per_rev;
    }
    
    public double getEncoderRawLeft() {
        return leftDrive.getSelectedSensorPosition(0);
    }

    public double getEncoderRawRight() {
        return rightDrive.getSelectedSensorPosition(0);
    }

    public double getAngle() {
        return gyro.getAngle();
    }

    public void PathSetup(TankModifier modifier, boolean relative) {
        if(relative) {
            resetEncoders();
            gyro.reset();
        }

        DrivetrainProfiling.last_gyro_error = 0.0;
        left = new EncoderFollower(modifier.getLeftTrajectory());
        right = new EncoderFollower(modifier.getRightTrajectory());
        left.configureEncoder(leftDrive.getSelectedSensorPosition(0), DrivetrainProfiling.ticks_per_rev, DrivetrainProfiling.wheel_diameter);
        right.configureEncoder(rightDrive.getSelectedSensorPosition(0), DrivetrainProfiling.ticks_per_rev, DrivetrainProfiling.wheel_diameter);
        left.configurePIDVA(DrivetrainProfiling.kp, DrivetrainProfiling.ki, DrivetrainProfiling.kd, DrivetrainProfiling.kv, DrivetrainProfiling.ka);
        right.configurePIDVA(DrivetrainProfiling.kp, DrivetrainProfiling.ki, DrivetrainProfiling.kd, DrivetrainProfiling.kv, DrivetrainProfiling.ka);
    }

    public void PathFollow() {
        double l = left.calculate(leftDrive.getSelectedSensorPosition(0));
        double r = right.calculate(rightDrive.getSelectedSensorPosition(0));

        double gyro_heading = gyro.getAngle();
        double angle_setpoint = Pathfinder.r2d(left.getHeading());
        double angleDifference = Pathfinder.boundHalfDegrees(angle_setpoint - gyro_heading);

        double turn = DrivetrainProfiling.gp * angleDifference + (DrivetrainProfiling.gd *
                ((angleDifference - DrivetrainProfiling.last_gyro_error) / DrivetrainProfiling.dt));

        DrivetrainProfiling.last_gyro_error = angleDifference;

        drive(l + turn, r - turn);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveTank());
    }

    public static class DrivetrainProfiling {
        //TODO: TUNE CONSTANTS
        public static double kp = 1.5; // 1.5
        public static double kd = 0.775; // 0.775
        public static double gp = 0.06; // 0.06
        public static double gd = 0.03; // 0.03
        public static double ki = 0.0; // Not Used

        //gyro logging
        public static double last_gyro_error = 0.0;

        //hard constants TODO: UPDATE FOR 2018 CONSTANTS ARE OLD FOR 2017
        public static final double max_velocity = 0.8; // Max is 3.2
        public static final double kv = 1 / max_velocity;
        public static final double max_acceleration = 1.676;
        public static final double ka = 0.05;
        public static final double max_jerk = 9.144;
        public static final double wheel_diameter = 0.08255;
        public static final double wheel_base_width = 0.6477;
        public static final int ticks_per_rev = 4096; // 4x CPR
        public static final double dt = 0.02; // Calculated - Confirmed

        public static void setPIDG(double p, double i, double d, double gp, double gd) {
            SmartDashboard.putNumber("kP", p);
            SmartDashboard.putNumber("kI", i);
            SmartDashboard.putNumber("kD", d);
            SmartDashboard.putNumber("gP", gp);
            SmartDashboard.putNumber("gD", gd);
        }

        public static void updatePIDG() {
            kp = SmartDashboard.getNumber("kP", 0.0);
            ki = SmartDashboard.getNumber("kI", 0.0);
            kd = SmartDashboard.getNumber("kD", 0.0);
            gp = SmartDashboard.getNumber("gP", 0.0);
            gd = SmartDashboard.getNumber("gD", 0.0);
        }
    }

}