package org.usfirst.frc.team125.robot.util;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class CurrentReader {

    public static enum CurrentPorts{
        Drivetrain,
        Intake,
        Cubelift
    }

    public static final double INTAKE_MAX_CURRENT = 45;
    public static final double DRIVETRAIN_MAX_CURRENT = 5;
    public static final double CUBELIFT_MAX_CURRENT = 4;

    public static final int COUNTER_MAX = 100;

    public int currentCounter = 0;

    public static PowerDistributionPanel pdp = new PowerDistributionPanel();

    public CurrentReader(){

    }

    public double getTotalCurrent(CurrentPorts newPorts) {
        double currentVal = 0;
        switch (newPorts) {
            case Drivetrain:
                currentVal = pdp.getCurrent(0) + pdp.getCurrent(1) + pdp.getCurrent(2) + pdp.getCurrent(3)
                        + pdp.getCurrent(4) + pdp.getCurrent(6);
                break;

            case Intake:
                currentVal = pdp.getCurrent(5) + pdp.getCurrent(10);
                break;

            case Cubelift:
                currentVal = pdp.getCurrent(8) + pdp.getCurrent(9) + pdp.getCurrent(7) + pdp.getCurrent(11);
                break;

            default:
                break;

        }

        return currentVal;
    }

    public double getAverageCurrent(CurrentPorts newPorts) {
        double currentVal = 0;
        switch (newPorts) {
            case Drivetrain:
                currentVal = (pdp.getCurrent(0) + pdp.getCurrent(1) + pdp.getCurrent(2) + pdp.getCurrent(3)
                        + pdp.getCurrent(4) + pdp.getCurrent(5)) / 6;
                break;

            case Intake:
                currentVal = (pdp.getCurrent(6) + pdp.getCurrent(7)) / 2;
                break;

            case Cubelift:
                currentVal = (pdp.getCurrent(8) + pdp.getCurrent(9) + pdp.getCurrent(10) + pdp.getCurrent(11)) / 4;
                break;

            default:
                break;

        }

        return currentVal;
    }

}
