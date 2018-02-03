package org.usfirst.frc.team125.robot;

import org.usfirst.frc.team125.robot.commands.CubeLift.*;
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
    public Button outtake = new JoystickButton(opPad, JoystickMap.LB);
    public Button intake = new JoystickButton(opPad, JoystickMap.RB);
    public Button changeClampPosition = new JoystickButton(opPad, JoystickMap.A);
    public Button clampOut = new JoystickButton(opPad, JoystickMap.X);
    public Button clampIn = new JoystickButton(opPad, JoystickMap.Y);
    public Button resetElevatorEnc = new JoystickButton(opPad, JoystickMap.B);
    public Button runEleLow = new JoystickButton(opPad, JoystickMap.BACK);
    public Button runEleHi = new JoystickButton(opPad, JoystickMap.START);
    public Button EMERGENCY_QUIT = new JoystickButton(opPad,JoystickMap.R3);


    //commented out these buttons since they aren't being used rn.
    //public Button readyCarrier = new JoystickButton(opPad, JoystickMap.B);
    //public Button liftCarrier = new JoystickButton(opPad, JoystickMap.Y);
    //public Button releasePin = new JoystickButton(opPad, JoystickMap.X);


    /* Driver Control */
    private Button driveHoldHeading = new JoystickButton(driverPad, JoystickMap.LB);

    private static final double STICK_DEADBAND = 0.05;

    public OI() {

        //Intake
        outtake.whileHeld(new OuttakeCmd());
        intake.whileHeld(new IntakeCmd());

        //Clamp
        changeClampPosition.whenPressed(new ChangeGrabberPositionCmd());
        clampIn.whenPressed(new CloseClampCmd());
        clampOut.whenPressed(new OpenClampCmd());

        //Elevator
        resetElevatorEnc.whenPressed(new ResetEncoderCmd());
        runEleLow.whenPressed(new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreSwitch));
        runEleHi.whenPressed(new RunToPositionMotionMagicCmd(CubeLift.Positions.Intake));
        EMERGENCY_QUIT.whenPressed(new ElevatorDriveCmd());

        //Carrier
        //readyCarrier.whenPressed(new DropAndReleaseCarrier());
        //liftCarrier.whenPressed(new LiftCarrierCmd());
        //releasePin.whenPressed(new ReleasePinCmd());

        //Hold heading
        driveHoldHeading.whileHeld(new DriveArcadeWithHoldHeadingCmd());
        driveHoldHeading.whenReleased(new DriveArcadeCmd());
    }


    private static double stickDeadband(double value, double deadband, double center) {
        return (value < (center + deadband) && value > (center - deadband)) ? center : value;
    }

    public double getDriverLeftStickY() {
        return stickDeadband(this.driverPad.getRawAxis(1), STICK_DEADBAND, 0.0);
    }

    public double getDriverLeftStickX() {
        return stickDeadband(this.driverPad.getRawAxis(0), STICK_DEADBAND, 0.0);
    }

    public double getDriverRightStickY() {
        return stickDeadband(this.driverPad.getRawAxis(5), STICK_DEADBAND, 0.0);
    }

    public double getDriverRightStickX() {
        return stickDeadband(this.driverPad.getRawAxis(4), STICK_DEADBAND, 0.0);
    }

    public double getDriverTriggerSum() {
        return this.driverPad.getRawAxis(3) - this.driverPad.getRawAxis(2); //TODO: Check Axis (Right - Left)
    }

    public double getOpLeftStickY() {
        return stickDeadband(this.opPad.getRawAxis(1), STICK_DEADBAND, 0.0);
    }

}

