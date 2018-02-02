package org.usfirst.frc.team125.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team125.robot.RobotMap;
import org.usfirst.frc.team125.robot.commands.CubeLift.ElevatorDriveCmd;

/**
 * DoubleLift's DoubleLift for DoubleLifting
 */
public class CubeLift extends Subsystem {

    private TalonSRX rightElevatorLeader = new TalonSRX(RobotMap.RIGHT_ELEVATOR_MAIN);
    private VictorSPX rightElevatorSlave = new VictorSPX(RobotMap.RIGHT_ELEVATOR_SLAVE);
    private VictorSPX leftElevatorSlaveA = new VictorSPX(RobotMap.LEFT_ELEVATOR_SLAVE_A);
    private VictorSPX leftElevatorSlaveB = new VictorSPX(RobotMap.LEFT_ELEVATOR_SLAVE_B);

    private static final double kP = 0.0;
    private static final double kI = 0.0;
    private static final double kD = 0.0;
    private static final double kF = 0.0;

    private static final double TICKS_PER_INCH = 233.0;
    private static final double DISTANCE_PER_TICK = 1.0/TICKS_PER_INCH; // In inches according to 233 clicks per inch -Henry

    //Change from double to single
    //private DoubleSolenoid grabbers = new DoubleSolenoid( 0, 1);
    private Solenoid grabbers = new Solenoid(RobotMap.GRABBERS);

    private Solenoid releasePin = new Solenoid(RobotMap.RELEASE_PIN);

    //private static final double calibrationMinTime = 1.5;
    //private DebouncedBoolean calibrationDebouncer = new DebouncedBoolean(calibrationMinTime);

    private boolean grabberPosition = true;

    private static final int ELEVATOR_TOP = 1;
    private static final int ELEVATOR_BOTTOM = 0;

    private static final boolean CLAMP_SET = true;
    private static final boolean UNCLAMP_SET = false;
    private static final boolean RELEASE_SET = true;
    private static final boolean UNRELEASE_SET = false;

    public CubeLift() {
        this.rightElevatorSlave.follow(rightElevatorLeader);
        this.leftElevatorSlaveA.follow(rightElevatorLeader);
        this.leftElevatorSlaveB.follow(rightElevatorLeader);
        this.leftElevatorSlaveA.setInverted(true);
        this.leftElevatorSlaveB.setInverted(true);
        this.rightElevatorLeader.setInverted(false);
        this.rightElevatorSlave.setInverted(false);
        this.rightElevatorLeader.configPeakOutputForward(1.0, 0);
        this.rightElevatorLeader.configPeakOutputReverse(-1.0, 0);
        this.rightElevatorLeader.configNominalOutputForward(0.0, 0);
        this.rightElevatorLeader.configNominalOutputReverse(0.0, 0);
        this.rightElevatorSlave.configPeakOutputForward(1.0, 0);
        this.rightElevatorSlave.configPeakOutputReverse(-1.0, 0);
        this.rightElevatorSlave.configNominalOutputForward(0.0, 0);
        this.rightElevatorSlave.configNominalOutputReverse(0.0, 0);
        this.leftElevatorSlaveA.configPeakOutputForward(1.0, 0);
        this.leftElevatorSlaveA.configPeakOutputReverse(-1.0, 0);
        this.leftElevatorSlaveA.configNominalOutputForward(0.0, 0);
        this.leftElevatorSlaveA.configNominalOutputReverse(0.0, 0);
        this.leftElevatorSlaveB.configPeakOutputForward(1.0, 0);
        this.leftElevatorSlaveB.configPeakOutputReverse(-1.0, 0);
        this.leftElevatorSlaveB.configNominalOutputForward(0.0, 0);
        this.leftElevatorSlaveB.configNominalOutputReverse(0.0, 0);

        //this.grabbers.set(DoubleSolenoid.Value.kOff);
        //this.grabbers.set(DoubleSolenoid.Value.kForward);
        //this.grabbers.set(DoubleSolenoid.Value.kReverse);

        //Encoder
        this.rightElevatorLeader.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

        //Neutral mode
        this.rightElevatorLeader.setNeutralMode(NeutralMode.Brake);
        this.rightElevatorSlave.setNeutralMode(NeutralMode.Brake);
        this.leftElevatorSlaveA.setNeutralMode(NeutralMode.Brake);
        this.leftElevatorSlaveB.setNeutralMode(NeutralMode.Brake);

        configPIDF(1.0, 0., 0., 0.); // TODO: Tune lol
    }

    public void resetEncoders() {
        this.rightElevatorLeader.setSelectedSensorPosition(0, 0, 0);
    }

    public int getEncPos() {
        return rightElevatorLeader.getSelectedSensorPosition(0);
    }

    public void runToPosition(int pos) {
        rightElevatorLeader.set(ControlMode.Position, pos);
    }

    public void runToPositionMotionMagic(int pos) {
        rightElevatorLeader.set(ControlMode.MotionMagic, pos);
    }

    public void openClamp() {
        grabbers.set(UNCLAMP_SET);
    }

    public void closeClamp() {
        grabbers.set(CLAMP_SET);
    }

    public void changeGrabberPosition() {
        grabberPosition = !grabberPosition;

        grabbers.set(grabberPosition);
    }

    public void releasePin() {
        releasePin.set(RELEASE_SET);
    }

    public void reinsertPin() {
        releasePin.set(UNRELEASE_SET);
    }

    public void stopElevator() {
        rightElevatorLeader.set(ControlMode.PercentOutput, 0.0);
    }

    public void directElevate(double pow) {
        rightElevatorLeader.set(ControlMode.PercentOutput, pow);
    }

    //Will use later once we get hall effect sensor.
    /*public void calibrateElevator() {
        calibrationDebouncer.update(limitSwitch.get());
        if (calibrationDebouncer.get()) {
            resetEncoders();
        }
    }*/

    public void configPIDF(double kP, double kI, double kD, double kF) {
        rightElevatorLeader.config_kP(0, kP, 0);
        rightElevatorLeader.config_kI(0, kI, 0);
        rightElevatorLeader.config_kD(0, kD, 0);
        rightElevatorLeader.config_kF(0, kF, 0);
    }

    /**
     * Set parameters for motion magic control
     *
     * @param cruiseVelocity cruise velocity in sensorUnits per 100ms
     * @param acceleration   cruise acceleration in sensorUnits per 100ms
     */
    public void configMotionMagic(int cruiseVelocity, int acceleration) {
        rightElevatorLeader.configMotionCruiseVelocity(cruiseVelocity, 0);
        rightElevatorLeader.configMotionAcceleration(acceleration, 0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ElevatorDriveCmd());
    }

    public int inchesToClicks(double inches) {
     return (int)(inches/DISTANCE_PER_TICK);
    }

    public void updatePIDFOnDashboard() {
        SmartDashboard.putNumber("kP", kP);
        SmartDashboard.putNumber("kI", kI);
        SmartDashboard.putNumber("kD", kD);
        SmartDashboard.putNumber("kF", kF);
    }
    public void updatePIDFFromDashboard() {
        configPIDF(SmartDashboard.getNumber("kP", kP),
                SmartDashboard.getNumber("kI", kI),
                SmartDashboard.getNumber("kD", kD),
                SmartDashboard.getNumber("kF", kF));
    }
}

