package org.usfirst.frc.team125.robot;

import org.usfirst.frc.team125.robot.commands.CubeLift.*;
import org.usfirst.frc.team125.robot.commands.DoubleLift.ToggleReleaserCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.*;
import org.usfirst.frc.team125.robot.commands.Intake.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command Groups that allow control of the robot.
 */
public class OI {

    //Controllers
    public Joystick driverPad = new Joystick(0);
    public Joystick opPad = new Joystick(1);

    /* Operator Control */
    //Cube Lift
    public Button clampOut = new JoystickButton(opPad, JoystickMap.RB);
    public Button clampIn = new JoystickButton(opPad, JoystickMap.LB);
    public Button runEleClimb = new JoystickButton(opPad, JoystickMap.START);
    public Button runEleScale = new JoystickButton(opPad, JoystickMap.Y);
    public Button runEleSwitch = new JoystickButton(opPad, JoystickMap.X);
    public Button runEleIntake = new JoystickButton(opPad, JoystickMap.A);
    public Button EMERGENCY_QUIT = new JoystickButton(opPad,JoystickMap.R3);

    //Double Lift
    public Button swapDoubleLiftRelease = new JoystickButton(opPad, JoystickMap.B);


    //commented out these buttons since they aren't being used rn.
    //public Button readyCarrier = new JoystickButton(opPad, JoystickMap.B);
    //public Button liftCarrier = new JoystickButton(opPad, JoystickMap.Y);

    /* Driver Control */
    private Button driveHoldHeading = new JoystickButton(driverPad, JoystickMap.LB);

    private static final double STICK_DEADBAND = 0.05;

    public OI() {
        //Intake
        if(opPad.getRawAxis(JoystickMap.LEFT_TRIGGER) >= 0.5){
            new IntakeCmd();
        }

        if(opPad.getRawAxis(JoystickMap.RIGHT_TRIGGER) >= 0.5){
            new OuttakeCmd();
        }

        //Cubelift Clamp
        clampIn.whenPressed(new CloseClampCmd());
        clampOut.whenPressed(new OpenClampCmd());

        //Elevator
        EMERGENCY_QUIT.whenPressed(new ElevatorDriveCmd());
        //Elevator Positions
        runEleSwitch.whenPressed(new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreSwitch));
        runEleScale.whenPressed(new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreScale));
        runEleClimb.whenPressed(new RunToPositionMotionMagicCmd(CubeLift.Positions.Climbing));
        runEleIntake.whenPressed(new RunToPositionMotionMagicCmd(CubeLift.Positions.Intake));

        //Double lift
        swapDoubleLiftRelease.whenPressed(new ToggleReleaserCmd());

        //Driver
        driveHoldHeading.whileHeld(new DriveArcadeWithHoldHeadingCmd());
        driveHoldHeading.whenReleased(new DriveArcadeCmd());
    }


    private static double stickDeadband(double value, double deadband, double center) {
        return (value < (center + deadband) && value > (center - deadband)) ? center : value;
    }

    public double getDriverLeftStickY() {
        return stickDeadband(this.driverPad.getRawAxis(JoystickMap.LEFT_Y), STICK_DEADBAND, 0.0);
    }

    public double getDriverLeftStickX() {
        return stickDeadband(this.driverPad.getRawAxis(JoystickMap.LEFT_X), STICK_DEADBAND, 0.0);
    }

    public double getDriverRightStickY() {
        return stickDeadband(this.driverPad.getRawAxis(JoystickMap.RIGHT_Y), STICK_DEADBAND, 0.0);
    }

    public double getDriverRightStickX() {
        return stickDeadband(this.driverPad.getRawAxis(JoystickMap.RIGHT_X), STICK_DEADBAND, 0.0);
    }

    public double getDriverTriggerSum() {
        return this.driverPad.getRawAxis(3) - this.driverPad.getRawAxis(2); //TODO: Check Axis (Right - Left)
    }

    public double getOpRightTrigger(){
        return this.opPad.getRawAxis(JoystickMap.RIGHT_TRIGGER);
    }

    public double getOpLeftTrigger(){
        return this.opPad.getRawAxis(JoystickMap.LEFT_TRIGGER);
    }

    public double getOpLeftStickY() {
        return stickDeadband(this.opPad.getRawAxis(1), STICK_DEADBAND, 0.0);
    }

}

