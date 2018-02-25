package org.usfirst.frc.team125.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team125.robot.RobotMap;

public class LEDController extends Subsystem {

    private Spark blinkinLED = new Spark(RobotMap.BLINKIN);

    private boolean runningMotionMagic = false;

    private boolean smartIntakeTriggered = false;

    public void setRunningMotionMagic(boolean val) {
        runningMotionMagic = val;
    }

    public void setSmartIntakeTriggered(boolean val) {
        smartIntakeTriggered = val;
    }

    private class LEDAutoUpdater implements Runnable {
        int p = 0;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                updateLEDStatus();
                SmartDashboard.putNumber("p counter", p);
                p++;
            }
        }
    }

    public LEDController() {
        Thread thread = new Thread(new LEDAutoUpdater());
        thread.start();
    }

    public void setLEDRed() {
        blinkinLED.set(0.61);
    }

    public void setLEDStrobeRed() {
        blinkinLED.set(-0.11);
    }

    public void setLEDGreen() {
        blinkinLED.set(0.77);
    }

    public void setLEDYellow() {
        blinkinLED.set(0.67);
    }

    public void updateLEDStatus() {
        if(runningMotionMagic) {
            setLEDStrobeRed();
        } else if (smartIntakeTriggered) {
            setLEDYellow();
        } else {
            setLEDRed();
        }
    }

    @Override
    protected void initDefaultCommand() {
    }
}
