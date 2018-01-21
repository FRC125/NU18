package org.usfirst.frc.team125.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import org.usfirst.frc.team125.robot.RobotMap;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team125.robot.commands.DriveArcadeCmd;

/**
 * 4 Motor Drivetrain Subclass
 */
public class Drivetrain extends Subsystem {

    //Controllers
    private TalonSRX leftDriveMain = new TalonSRX(RobotMap.LEFT_DRIVE_MAIN);
    private TalonSRX leftDriveSlaveA = new TalonSRX(RobotMap.LEFT_DRIVE_SLAVE_A);
    private TalonSRX leftDriveSlaveB = new TalonSRX(RobotMap.LEFT_DRIVE_SLAVE_B);
    private TalonSRX rightDriveMain = new TalonSRX(RobotMap.RIGHT_DRIVE_MAIN);
    private TalonSRX rightDriveSlaveA = new TalonSRX(RobotMap.RIGHT_DRIVE_SLAVE_A);
    private TalonSRX rightDriveSlaveB = new TalonSRX(RobotMap.RIGHT_DRIVE_SLAVE_B);

    AHRS gyro = new AHRS(I2C.Port.kMXP) ;

    //Encoder Stuff
    EncoderFollower left;
    EncoderFollower right;

    //Timing
    public Timer timer = new Timer();

    //Gyro
    double lastHeadingError = 0.0;

    public Drivetrain() {
        //Slave Control
        this.leftDriveSlaveA.follow(leftDriveMain);
        this.rightDriveSlaveA.follow(rightDriveMain);
        this.leftDriveSlaveB.follow(leftDriveMain);
        this.rightDriveSlaveB.follow(rightDriveMain);

        this.leftDriveMain.configPeakOutputForward(1.0, 0);
        this.leftDriveMain.configPeakOutputReverse(-1.0, 0);
        this.leftDriveMain.configNominalOutputForward(0.0, 0);
        this.leftDriveMain.configNominalOutputReverse(0.0, 0);
        this.leftDriveSlaveA.configPeakOutputForward(1.0, 0);
        this.leftDriveSlaveA.configPeakOutputReverse(-1.0, 0);
        this.leftDriveSlaveA.configNominalOutputForward(0.0, 0);
        this.leftDriveSlaveA.configNominalOutputReverse(0.0, 0);
        this.leftDriveSlaveB.configPeakOutputForward(1.0, 0);
        this.leftDriveSlaveB.configPeakOutputReverse(-1.0, 0);
        this.leftDriveSlaveB.configNominalOutputForward(0.0, 0);
        this.leftDriveSlaveB.configNominalOutputReverse(0.0, 0);

        this.rightDriveMain.configPeakOutputForward(1.0, 0);
        this.rightDriveMain.configPeakOutputReverse(-1.0, 0);
        this.rightDriveMain.configNominalOutputForward(0.0, 0);
        this.rightDriveMain.configNominalOutputReverse(0.0, 0);
        this.rightDriveSlaveA.configPeakOutputForward(1.0, 0);
        this.rightDriveSlaveA.configPeakOutputReverse(-1.0, 0);
        this.rightDriveSlaveA.configNominalOutputForward(0.0, 0);
        this.rightDriveSlaveA.configNominalOutputReverse(0.0, 0);
        this.rightDriveSlaveB.configPeakOutputForward(1.0, 0);
        this.rightDriveSlaveB.configPeakOutputReverse(-1.0, 0);
        this.rightDriveSlaveB.configNominalOutputForward(0.0, 0);
        this.rightDriveSlaveB.configNominalOutputReverse(0.0, 0);

        //Inverted or Not...
        this.leftDriveMain.setInverted(false);
        this.leftDriveSlaveA.setInverted(false);
        this.leftDriveSlaveB.setInverted(false);
        this.rightDriveMain.setInverted(true);
        this.rightDriveSlaveA.setInverted(true);
        this.rightDriveSlaveB.setInverted(true);

        //Encoder
        this.leftDriveMain.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        this.rightDriveMain.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

        resetEncoders();
        disableBreakMode();

        //Gyro
        resetGyro();
    }

    public void drive(double powLeft, double powRight) {
        this.leftDriveMain.set(ControlMode.PercentOutput, powLeft);
        this.rightDriveMain.set(ControlMode.PercentOutput, powRight);
    }

    public void driveArcade(double throttle, double turn) {
        this.leftDriveMain.set(ControlMode.PercentOutput, throttle + turn);
        this.rightDriveMain.set(ControlMode.PercentOutput, throttle - turn);
    }

    public void driveHoldHeading(double throttle) {
        double turn = (DrivetrainProfiling.gp * gyro.getAngle()) + (DrivetrainProfiling.gd * (gyro.getAngle() - lastHeadingError));
        this.lastHeadingError = gyro.getAngle();
        this.leftDriveMain.set(ControlMode.PercentOutput, throttle - turn);
        this.rightDriveMain.set(ControlMode.PercentOutput, throttle + turn);
    }

    public void resetLastHeadingError() {
        this.lastHeadingError = 0.0;
    }
    public double getLeftVelocity() {
        return (leftDriveMain.getSelectedSensorVelocity(0) * Math.PI * DrivetrainProfiling.wheel_diameter) / (DrivetrainProfiling.ticks_per_rev)  * 10;
    }

    public double getRightVelocity() {
        return (rightDriveMain.getSelectedSensorVelocity(0) * Math.PI * DrivetrainProfiling.wheel_diameter) / (DrivetrainProfiling.ticks_per_rev) * 10;
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
        this.leftDriveMain.setNeutralMode(NeutralMode.Brake);
        this.rightDriveMain.setNeutralMode(NeutralMode.Brake);
    }

    public void disableBreakMode() {
        this.leftDriveMain.setNeutralMode(NeutralMode.Coast);
        this.rightDriveMain.setNeutralMode(NeutralMode.Coast);
    }

    public void resetEncoders() {
        this.leftDriveMain.setSelectedSensorPosition(0, 0, 0);
        this.rightDriveMain.setSelectedSensorPosition(0, 0, 0);
    }

    public double getEncoderDistanceMetersRight() {
        return (rightDriveMain.getSelectedSensorPosition(0) * Math.PI * DrivetrainProfiling.wheel_diameter) / DrivetrainProfiling.ticks_per_rev;
    }

    public double getEncoderDistanceMetersLeft() {
        return (leftDriveMain.getSelectedSensorPosition(0) * Math.PI * DrivetrainProfiling.wheel_diameter) / DrivetrainProfiling.ticks_per_rev;
    }
    
    public double getEncoderRawLeft() {
        return leftDriveMain.getSelectedSensorPosition(0);
    }

    public double getEncoderRawRight() {
        return rightDriveMain.getSelectedSensorPosition(0);
    }

    public double getAngle() {
        return gyro.getAngle();
    }

    public void resetGyro() {
        this.gyro.reset();
    }

    public void pathSetup(TankModifier modifier, boolean relative) {
        if(relative) {
            resetEncoders();
            resetGyro();
        }

        DrivetrainProfiling.last_gyro_error = 0.0;
        left = new EncoderFollower(modifier.getLeftTrajectory());
        right = new EncoderFollower(modifier.getRightTrajectory());
        left.configureEncoder(leftDriveMain.getSelectedSensorPosition(0), DrivetrainProfiling.ticks_per_rev, DrivetrainProfiling.wheel_diameter);
        right.configureEncoder(rightDriveMain.getSelectedSensorPosition(0), DrivetrainProfiling.ticks_per_rev, DrivetrainProfiling.wheel_diameter);
        left.configurePIDVA(DrivetrainProfiling.kp, DrivetrainProfiling.ki, DrivetrainProfiling.kd, DrivetrainProfiling.kv, DrivetrainProfiling.ka);
        right.configurePIDVA(DrivetrainProfiling.kp, DrivetrainProfiling.ki, DrivetrainProfiling.kd, DrivetrainProfiling.kv, DrivetrainProfiling.ka);
    }

    public void pathFollow() {
        double l = left.calculate(leftDriveMain.getSelectedSensorPosition(0));
        double r = right.calculate(rightDriveMain.getSelectedSensorPosition(0));

        double gyro_heading = gyro.getAngle();
        double angle_setpoint = Pathfinder.r2d(left.getHeading());
        double angleDifference = Pathfinder.boundHalfDegrees(angle_setpoint - gyro_heading);

        double turn = DrivetrainProfiling.gp * angleDifference + (DrivetrainProfiling.gd *
                ((angleDifference - DrivetrainProfiling.last_gyro_error) / DrivetrainProfiling.dt));

        DrivetrainProfiling.last_gyro_error = angleDifference;

        drive(l + turn, r - turn);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveArcadeCmd());
    }

    public static class DrivetrainProfiling {
        //TODO: TUNE CONSTANTS
        public static double kp = 0.01;
        public static double kd = 0.0;
        public static double gp = 0.05;
        public static double gd = 0.0;
        public static double ki = 0.0;

        //gyro logging
        public static double last_gyro_error = 0.0;

        //hard constants TODO: UPDATE FOR 2018 CONSTANTS ARE OLD FOR 2017
        public static final double max_velocity = 3.9; // Max is 3.2
        public static final double kv = 1. / max_velocity;
        public static final double max_acceleration = 2.5; // 1.0;
        public static final double ka = 0.05;
        public static final double max_jerk = 9.114;
        public static final double wheel_diameter = 0.126;
        public static final double wheel_base_width = 0.6223;
        public static final int ticks_per_rev = 4096; // CTRE Mag Encoder
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