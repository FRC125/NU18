package org.usfirst.frc.team125.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team125.robot.RobotMap;
import org.usfirst.frc.team125.robot.commands.MotoredDoubleLift.AnalogLiftCmd;

public class MotoredDoubleLift extends Subsystem {

    //DoubleLift Motors
    private IMotorController doubleLiftMain = new VictorSPX(RobotMap.DOUBLE_LIFT_MAIN);
    private IMotorController doubleLiftSlave = new VictorSPX(RobotMap.DOUBLE_LIFT_SLAVE);

    public static final double DOUBLE_LIFT_POWER = 1.0;

    public MotoredDoubleLift() {
        this.doubleLiftSlave.follow(doubleLiftMain);
        this.doubleLiftMain.configPeakOutputForward(DOUBLE_LIFT_POWER, 0);
        this.doubleLiftMain.configPeakOutputReverse(-DOUBLE_LIFT_POWER, 0);
        this.doubleLiftMain.configNominalOutputForward(0.0, 0);
        this.doubleLiftMain.configNominalOutputReverse(0.0, 0);

        this.doubleLiftSlave.configPeakOutputForward(DOUBLE_LIFT_POWER, 0);
        this.doubleLiftSlave.configPeakOutputReverse(-DOUBLE_LIFT_POWER, 0);
        this.doubleLiftSlave.configNominalOutputForward(0.0, 0);
        this.doubleLiftSlave.configNominalOutputReverse(0.0, 0);

        this.doubleLiftMain.setNeutralMode(NeutralMode.Brake);
        this.doubleLiftSlave.setNeutralMode(NeutralMode.Brake);

        this.doubleLiftMain.setInverted(false);
        this.doubleLiftSlave.setInverted(true);
    }

    public void analogLift(double pow) {
        doubleLiftMain.set(ControlMode.PercentOutput, pow);
    }

    public void lift() {
        doubleLiftMain.set(ControlMode.PercentOutput, DOUBLE_LIFT_POWER);
    }

    public void repel() {
        doubleLiftMain.set(ControlMode.PercentOutput, -DOUBLE_LIFT_POWER);
    }

    public void stopDoubleLift() {
        doubleLiftMain.set(ControlMode.PercentOutput, 0.0);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new AnalogLiftCmd());
    }
}
