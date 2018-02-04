package org.usfirst.frc.team125.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team125.robot.RobotMap;

public class Flopper extends Subsystem {
    private Solenoid rightFlop = new Solenoid(RobotMap.RIGHT_SIDE_FLOPPER);
    private Solenoid lefrFlop = new Solenoid(RobotMap.LEFT_SIDE_FLOPPER);
    private boolean leftRest = false;
    private boolean rightRest = false;
    private boolean rightDeploy = true;
    private boolean leftDeploy = true;

    public Flopper() {
        rightFlop.set(rightRest);
        rightFlop.set(rightRest);
    }

    public void deployFlopRight() {
        this.lefrFlop.set(leftDeploy);
    }

    public void deployFlopLeft() {
        this.rightFlop.set(rightDeploy);
    }

    public void resetFlopper() {
        this.rightFlop.set(rightRest);
        this.lefrFlop.set(leftRest);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
