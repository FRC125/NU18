package org.usfirst.frc.team125.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team125.robot.RobotMap;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DriveArcadeCmd;

import java.io.File;

public class Drivetrain extends Subsystem {

    //Controllers
    private TalonSRX leftDriveMain = new TalonSRX(RobotMap.LEFT_DRIVE_MAIN);
    private VictorSPX leftDriveSlaveA = new VictorSPX(RobotMap.LEFT_DRIVE_SLAVE_A);
    private VictorSPX leftDriveSlaveB = new VictorSPX(RobotMap.LEFT_DRIVE_SLAVE_B);
    private TalonSRX rightDriveMain = new TalonSRX(RobotMap.RIGHT_DRIVE_MAIN);
    private VictorSPX rightDriveSlaveA = new VictorSPX(RobotMap.RIGHT_DRIVE_SLAVE_A);
    private VictorSPX rightDriveSlaveB = new VictorSPX(RobotMap.RIGHT_DRIVE_SLAVE_B);

    private static final double HIGH_POW = 1.0;
    private static final double LOW_POW = -HIGH_POW;
    private static final double RAMP_RATE = 0.25;

    AHRS gyro = new AHRS(I2C.Port.kMXP);

    //Timing
    public Timer timer = new Timer();

    //Gyro logging for driving
    double lastHeadingError = 0.0;
    final double TURN_TO_ANGLE_TOLERANCE = 10.0;

    public Drivetrain() {
        //Slave Control
        this.leftDriveSlaveA.follow(leftDriveMain);
        this.rightDriveSlaveA.follow(rightDriveMain);
        this.leftDriveSlaveB.follow(leftDriveMain);
        this.rightDriveSlaveB.follow(rightDriveMain);

        this.leftDriveMain.configPeakOutputForward(HIGH_POW, 0);
        this.leftDriveMain.configPeakOutputReverse(LOW_POW, 0);
        this.leftDriveMain.configNominalOutputForward(0.0, 0);
        this.leftDriveMain.configNominalOutputReverse(0.0, 0);
        this.leftDriveSlaveA.configPeakOutputForward(HIGH_POW, 0);
        this.leftDriveSlaveA.configPeakOutputReverse(LOW_POW, 0);
        this.leftDriveSlaveA.configNominalOutputForward(0.0, 0);
        this.leftDriveSlaveA.configNominalOutputReverse(0.0, 0);
        this.leftDriveSlaveB.configPeakOutputForward(HIGH_POW, 0);
        this.leftDriveSlaveB.configPeakOutputReverse(LOW_POW, 0);
        this.leftDriveSlaveB.configNominalOutputForward(0.0, 0);
        this.leftDriveSlaveB.configNominalOutputReverse(0.0, 0);

        this.rightDriveMain.configPeakOutputForward(HIGH_POW, 0);
        this.rightDriveMain.configPeakOutputReverse(LOW_POW, 0);
        this.rightDriveMain.configNominalOutputForward(0.0, 0);
        this.rightDriveMain.configNominalOutputReverse(0.0, 0);
        this.rightDriveSlaveA.configPeakOutputForward(HIGH_POW, 0);
        this.rightDriveSlaveA.configPeakOutputReverse(LOW_POW, 0);
        this.rightDriveSlaveA.configNominalOutputForward(0.0, 0);
        this.rightDriveSlaveA.configNominalOutputReverse(0.0, 0);
        this.rightDriveSlaveB.configPeakOutputForward(HIGH_POW, 0);
        this.rightDriveSlaveB.configPeakOutputReverse(LOW_POW, 0);
        this.rightDriveSlaveB.configNominalOutputForward(0.0, 0);
        this.rightDriveSlaveB.configNominalOutputReverse(0.0, 0);


        this.leftDriveMain.setInverted(false);
        this.leftDriveSlaveA.setInverted(false);
        this.leftDriveSlaveB.setInverted(false);
        this.rightDriveMain.setInverted(true);
        this.rightDriveSlaveA.setInverted(true);
        this.rightDriveSlaveB.setInverted(true);

        //Encoder
        this.leftDriveMain.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        this.rightDriveMain.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

        enableRamping();

        resetEncoders();
        enableBreakMode();

        //Gyro
        resetGyro();
    }

    public void enableRamping() {
        this.leftDriveMain.configOpenloopRamp(RAMP_RATE, 0);
        this.leftDriveMain.configClosedloopRamp(RAMP_RATE, 0);
        this.rightDriveMain.configOpenloopRamp(RAMP_RATE, 0);
        this.rightDriveMain.configClosedloopRamp(RAMP_RATE, 0);
    }

    public void disableRamping() {
        this.leftDriveMain.configOpenloopRamp(0.0, 0);
        this.leftDriveMain.configClosedloopRamp(0.0, 0);
        this.rightDriveMain.configOpenloopRamp(0.0, 0);
        this.rightDriveMain.configClosedloopRamp(0.0, 0);
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

    public boolean turnToAngle(double angle) {
        double error = angle - gyro.getAngle();
        double turn = DrivetrainProfiling.gp * error + (DrivetrainProfiling.gd *
                ((error - lastHeadingError) / DrivetrainProfiling.dt));
        this.leftDriveMain.set(ControlMode.PercentOutput, turn);
        this.rightDriveMain.set(ControlMode.PercentOutput, -turn);
        lastHeadingError = error;
        SmartDashboard.putNumber("turn to angle error", error);
        return Math.abs(error) <= TURN_TO_ANGLE_TOLERANCE;
    }

    public void resetLastHeadingError() {
        this.lastHeadingError = 0.0;
    }

    public double getGyroRate() {
        return gyro.getRate();
    }

    public double getLeftVelocity() {
        return (leftDriveMain.getSelectedSensorVelocity(0) * Math.PI * DrivetrainProfiling.wheel_diameter) / (DrivetrainProfiling.ticks_per_rev) * 10;
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
        return (getEncoderRawRight() * Math.PI * DrivetrainProfiling.wheel_diameter) / DrivetrainProfiling.ticks_per_rev;
    }

    public double getEncoderDistanceMetersLeft() {
        return (getEncoderRawLeft() * Math.PI * DrivetrainProfiling.wheel_diameter) / DrivetrainProfiling.ticks_per_rev;
    }

    public int getEncoderRawLeft() {
        return leftDriveMain.getSelectedSensorPosition(0);
    }

    public int getEncoderRawRight() {
        return rightDriveMain.getSelectedSensorPosition(0);
    }

    public double getAngle() {
        return -gyro.getAngle();
    }

    public void resetGyro() {
        this.gyro.reset();
    }

    public double generateHashCode(Waypoint[] path) {
        double hash = 1.0;
        for (int i = 0; i < path.length; i++) {
            hash = ((path[i].x * 3) + (path[i].y * 7) + (path[i].angle * 11) + (DrivetrainProfiling.kv * 21));
        }
        return (int) Math.abs(hash * 1000) * path.length;
    }

    public EncoderFollower[] pathSetup(Waypoint[] path) {
        EncoderFollower left = new EncoderFollower();
        EncoderFollower right = new EncoderFollower();
        Trajectory.Config cfg = new Trajectory.Config(Trajectory.FitMethod.HERMITE_QUINTIC, Trajectory.Config.SAMPLES_HIGH,
                Drivetrain.DrivetrainProfiling.dt, Drivetrain.DrivetrainProfiling.max_velocity, Drivetrain.DrivetrainProfiling.max_acceleration, Drivetrain.DrivetrainProfiling.max_jerk);
        String pathHash = String.valueOf(generateHashCode(path));
        SmartDashboard.putString("Path Hash", pathHash);
        Trajectory toFollow;
        File trajectory = new File("/home/lvuser/paths/" + pathHash + ".csv");
        if (!trajectory.exists()) {
            toFollow = Pathfinder.generate(path, cfg);
            Pathfinder.writeToCSV(trajectory, toFollow);
            System.out.println(pathHash + ".csv not found, wrote to file");
        } else {
            System.out.println(pathHash + ".csv read from file");
            toFollow = Pathfinder.readFromCSV(trajectory);
        }

        TankModifier modifier = new TankModifier(toFollow).modify((Drivetrain.DrivetrainProfiling.wheel_base_width));
        DrivetrainProfiling.last_gyro_error = 0.0;
        left = new EncoderFollower(modifier.getLeftTrajectory());
        right = new EncoderFollower(modifier.getRightTrajectory());
        left.configureEncoder(getEncoderRawLeft(), DrivetrainProfiling.ticks_per_rev, DrivetrainProfiling.wheel_diameter);
        right.configureEncoder(getEncoderRawRight(), DrivetrainProfiling.ticks_per_rev, DrivetrainProfiling.wheel_diameter);
        left.configurePIDVA(DrivetrainProfiling.kp, DrivetrainProfiling.ki, DrivetrainProfiling.kd, DrivetrainProfiling.kv, DrivetrainProfiling.ka);
        right.configurePIDVA(DrivetrainProfiling.kp, DrivetrainProfiling.ki, DrivetrainProfiling.kd, DrivetrainProfiling.kv, DrivetrainProfiling.ka);
        return new EncoderFollower[]{
                left, // 0
                right, // 1
        };
    }

    public void resetForPath() {
        isProfileFinished = false;
        resetEncoders();
        resetGyro();
    }


    public void resetPathAngleOffset() {
        DrivetrainProfiling.path_angle_offset = 0.0;
    }

    private boolean isProfileFinished = false;

    public boolean getIsProfileFinished() {
        return isProfileFinished;
    }

    /*
    If going !reverse going forward x is positive, going left y is positive, turning left is positive
    If going reverse going backwards x is positive, going right y is negative, turning left is negative
     */
    public void pathFollow(EncoderFollower[] followers, boolean reverse) {
        EncoderFollower left = followers[0];
        EncoderFollower right = followers[1];
        double l;
        double r;
        double localGp = DrivetrainProfiling.gp;
        if (!reverse) {
            localGp *= -1;
            l = left.calculate(-getEncoderRawLeft());
            r = right.calculate(-getEncoderRawRight());
        } else {
            l = left.calculate(getEncoderRawLeft());
            r = right.calculate(getEncoderRawRight());
        }

        double gyro_heading = reverse ? -getAngle() - DrivetrainProfiling.path_angle_offset : getAngle() + DrivetrainProfiling.path_angle_offset;
        double angle_setpoint = Pathfinder.r2d(left.getHeading());
        SmartDashboard.putNumber("Angle setpoint", angle_setpoint);
        double angleDifference = Pathfinder.boundHalfDegrees(angle_setpoint - gyro_heading);
        SmartDashboard.putNumber("Angle difference", angleDifference);

        double turn = localGp * angleDifference + (DrivetrainProfiling.gd *
                ((angleDifference - DrivetrainProfiling.last_gyro_error) / DrivetrainProfiling.dt));

        DrivetrainProfiling.last_gyro_error = angleDifference;

        if (left != null && !left.isFinished()) {
            SmartDashboard.putNumber("Left diff", left.getSegment().x + this.getEncoderDistanceMetersLeft());
            SmartDashboard.putNumber("Left set vel", left.getSegment().velocity);
            SmartDashboard.putNumber("Left set pos", left.getSegment().x);
            SmartDashboard.putNumber("Left calc voltage", l);
            SmartDashboard.putNumber("Commanded seg heading", left.getHeading());
            SmartDashboard.putNumber("Left + turn", l + turn);
            SmartDashboard.putNumber("Left seg acceleration", left.getSegment().acceleration);
            SmartDashboard.putNumber("Path angle offset", DrivetrainProfiling.path_angle_offset);
            SmartDashboard.putNumber("Angle offset w/ new path angle offset", angleDifference + DrivetrainProfiling.path_angle_offset);
        }
        if (!reverse) {
            drive(l + turn, r - turn);
        } else {
            drive(-l + turn, -r - turn);
        }

        if (left.isFinished() && right.isFinished()) {
            isProfileFinished = true;
            DrivetrainProfiling.path_angle_offset = 0.0;
        }
    }


    public void updateAccelDashboard() {
        SmartDashboard.putNumber("Accel X", gyro.getWorldLinearAccelX());
        SmartDashboard.putNumber("Accel Y", gyro.getWorldLinearAccelY());
        SmartDashboard.putNumber("Accel Z", gyro.getWorldLinearAccelZ());
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveArcadeCmd());
    }

    public static class DrivetrainProfiling {
        //TODO: TUNE CONSTANTS
        public static double kp = 0.8; //1.2;
        public static double kd = 0.0;
        public static double gp = 0.0375; // 0.0375
        public static double gd = 0.0; //0.0025
        public static double ki = 0.0;

        //Gyro logging for motion profiling
        public static double last_gyro_error = 0.0;

        //Path to Path offset
        public static double path_angle_offset = 0.0;

        // Slow var
        public static final double max_velocity_slow = 2.2; //4 is real TODO:CHANGE BACK TO 2.2
        public static final double kv_slow = 1.0 / max_velocity_slow; // Calculated for test Drivetrain
        public static final double max_acceleration_slow = 1.9; // Estimated # 3.8
        public static final double ka_slow = 0.05; //0.015
        public static final double max_jerk_slow = 8.0; // 16.0

        // Fast var
        public static final double max_velocity_fast = 4.0; //4 is real
        public static final double kv_fast = 1.0 / max_velocity_fast; // Calculated for test Drivetrain
        public static final double max_acceleration_fast = 5.7; // Estimated # 3.8
        public static final double ka_fast = 0.05; //0.015
        public static final double max_jerk_fast = 24.0; // 16.0

        // The ones that change; SLOW BY DEFAULT
        public static double max_velocity = max_velocity_slow; //4 is real
        public static double kv = kv_slow; // Calculated for test Drivetrain
        public static double max_acceleration = max_acceleration_slow; // Estimated # 3.8
        public static double ka = ka_slow; //0.015
        public static double max_jerk = max_jerk_slow; // 16.0

        public static void setupPathVariables(boolean slow) {
            if(slow) {
                max_velocity = max_velocity_slow;
                kv = kv_slow;
                max_acceleration = max_acceleration_slow;
                ka = ka_slow;
                max_jerk = max_jerk_slow;
            } else {
                max_velocity = max_velocity_fast;
                kv = kv_fast;
                max_acceleration = max_acceleration_fast;
                ka = ka_fast;
                max_jerk = max_jerk_fast;
            }
        }

        // Non Variable Constatns
        public static final double wheel_diameter = 0.125;
        public static final double wheel_base_width = 0.72;
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