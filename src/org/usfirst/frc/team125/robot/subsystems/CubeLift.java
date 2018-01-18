package org.usfirst.frc.team125.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team125.robot.RobotMap;
import org.usfirst.frc.team125.robot.commands.ElevatorDriveCmd;

/**
 * DoubleLift's DoubleLift for DoubleLifting
 */
public class CubeLift extends Subsystem {

    private TalonSRX elevator = new TalonSRX(RobotMap.ELEVATOR);
    private VictorSPX elevatorSlaveA = new VictorSPX(RobotMap.ELEVATOR_SLAVE_A);
    private VictorSPX elevatorSlaveB = new VictorSPX(RobotMap.ELEVATOR_SLAVE_B);
    private DoubleSolenoid grabbers = new DoubleSolenoid( 0, 1);
    private Solenoid elevatorRelease = new Solenoid(RobotMap.ELEVATOR_RELEASE);
    
    private boolean grabberPosition = true;

    public CubeLift() {
        this.elevatorSlaveA.follow(elevator);
        this.elevatorSlaveB.follow(elevator);
        this.elevator.configPeakOutputForward(1.0, 0);
        this.elevator.configPeakOutputReverse(-1.0, 0);
        this.elevator.configNominalOutputForward(0.0, 0);
        this.elevator.configNominalOutputReverse(0.0, 0);
        this.elevatorSlaveA.configPeakOutputForward(1.0, 0);
        this.elevatorSlaveA.configPeakOutputReverse(-1.0, 0);
        this.elevatorSlaveA.configNominalOutputForward(0.0, 0);
        this.elevatorSlaveA.configNominalOutputReverse(0.0, 0);
        this.elevatorSlaveB.configPeakOutputForward(1.0, 0);
        this.elevatorSlaveB.configPeakOutputReverse(-1.0, 0);
        this.elevatorSlaveB.configNominalOutputForward(0.0, 0);
        this.elevatorSlaveB.configNominalOutputReverse(0.0, 0);
        
        this.grabbers.set(DoubleSolenoid.Value.kOff);
        this.grabbers.set(DoubleSolenoid.Value.kForward);
        this.grabbers.set(DoubleSolenoid.Value.kReverse);
        
        //Encoder
        this.elevator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

        //Neutral mode
        this.elevator.setNeutralMode(NeutralMode.Brake);

        configPIDF(0, 0, 0, 0); // TODO: Tune lol
    }

    public void resetEncoders() {
        this.elevator.setSelectedSensorPosition(0, 0, 0);
    }

    public void runToPosition(int pos) {
        elevator.set(ControlMode.Position, pos);
    }

    public void runToPositionMotionMagic(int pos) {
        elevator.set(ControlMode.MotionMagic, pos);
    }

    public void openGrabbers() {
        grabbers.set(DoubleSolenoid.Value.kForward);
    }

    public void closeGrabbers() {
        grabbers.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void changeGrabberPosition() {
    	grabberPosition = !grabberPosition;
    	
    	//Fix this issue with the change position
    }

    public void releasePin() {
        elevatorRelease.set(true);
    }

    public void reinsertPin() {
        elevatorRelease.set(false);
    }

    public void stopElevator() {
        elevator.set(ControlMode.PercentOutput, 0.0);
    }

    public void directElevate(double pow) {
        elevator.set(ControlMode.PercentOutput, pow);
    }

    public void configPIDF(double kP, double kI, double kD, double kF) {
        elevator.config_kP(0, kP, 0);
        elevator.config_kI(0, kI, 0);
        elevator.config_kD(0, kD, 0);
        elevator.config_kF(0, kF, 0);
    }

    /**
     * Set parameters for motion magic control
     * @param cruiseVelocity cruise velocity in sensorUnits per 100ms
     * @param acceleration cruise acceleration in sensorUnits per 100ms
     */
    public void configMotionMagic(int cruiseVelocity, int acceleration) {
        elevator.configMotionCruiseVelocity(cruiseVelocity, 0);
        elevator.configMotionAcceleration(acceleration, 0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ElevatorDriveCmd());
    }

    public int getEncPos() {
        return elevator.getSelectedSensorPosition(0);
    }

}

