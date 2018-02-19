package org.usfirst.frc.team125.robot.util;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.GenericHID.*;

public class AnalogButton extends Button {

    private GenericHID joystick;
    private int axisNum;
    private double threshHold = 0.5;

    public AnalogButton(GenericHID joystick, int axisNum, double threshHold){
        this.joystick = joystick;
        this.axisNum = axisNum;
        this.threshHold = threshHold;
    }

    public boolean buttonPressed(){

        if(threshHold < 0){
            return joystick.getRawAxis(axisNum) < threshHold;
        }else{
            return joystick.getRawAxis(axisNum) > threshHold;
        }

    }

    @Override
    public boolean get() {
        return false;
    }
}
