package org.usfirst.frc.team125.robot.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DebouncedBoolean {

    private int loopCounter = 0;
    private int minimumLoops;

    public DebouncedBoolean(double minimumSeconds) {
        minimumLoops = (int) Math.ceil(minimumSeconds / 0.02);
    }

    public boolean get() {
        return loopCounter > minimumLoops;
    }

    public void update(boolean value) {
        if (value) {
            loopCounter++;
        } else {
            loopCounter = 0;
        }
        SmartDashboard.putNumber("Loop Counter", loopCounter);
    }

}
