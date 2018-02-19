package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team125.robot.commands.CubeLift.OpenGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.TogglePinCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.UnpunchCmd;
import org.usfirst.frc.team125.robot.commands.DoubleLift.ToggleLiftCmd;
import org.usfirst.frc.team125.robot.commands.DoubleLift.ToggleReleaserCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DriveArcadeCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DriveArcadeWithHoldHeadingCmd;
import org.usfirst.frc.team125.robot.commands.Groups.PullUpAndDropCarrierCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeCmd;
import org.usfirst.frc.team125.robot.commands.Intake.OuttakeCmd;
import org.usfirst.frc.team125.robot.commands.Intake.ToggleIntakeSolenoidCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.JoystickMap;


public class OI {

    //Controllers
    public Joystick driverPad = new Joystick(0);
    public Joystick opPad = new Joystick(1);

    /* Operator Control */
    public Button runEleScale = new JoystickButton(opPad, JoystickMap.Y);
    public Button runEleSwitch = new JoystickButton(opPad, JoystickMap.X);
    public Button runEleIntake = new JoystickButton(opPad, JoystickMap.A);
    public Button runElePreClimb = new JoystickButton(opPad, JoystickMap.B);
    public Button secureCube = new JoystickButton(opPad, JoystickMap.LB);
    public Button toggleElevatorPin = new JoystickButton(opPad, JoystickMap.L3);
    public Button toggleIntakePistonInOrOut = new JoystickButton(opPad, JoystickMap.R3);
    public Button runEleClimb = new JoystickButton(opPad, JoystickMap.BACK);
    public Button climb = new JoystickButton(opPad, JoystickMap.START);
    public Trigger toggleDoubleLiftDown = new JoystickButton(opPad, JoystickMap.LEFT_TRIGGER);
    public Trigger toggleDoubleLiftLift = new JoystickButton(opPad, JoystickMap.RIGHT_TRIGGER);

    /* Driver Control */
    public Button score = new JoystickButton(driverPad, JoystickMap.X);
    private Button intake = new JoystickButton(driverPad, JoystickMap.A);
    private Button outtake = new JoystickButton(driverPad, JoystickMap.B);


    private static final double STICK_DEADBAND = 0.05;

    public OI() {

        /* Operator Control */
        runEleScale.whenPressed(new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreScale));
        runEleSwitch.whenPressed(new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreSwitch));
        runEleIntake.whenPressed(new RunToPositionMotionMagicCmd(CubeLift.Positions.Intake));
        runElePreClimb.whenPressed(new RunToPositionMotionMagicCmd(CubeLift.Positions.PreClimb));
        secureCube.whenPressed(new SecureCubeCmdGrp());
        toggleElevatorPin.whenPressed(new TogglePinCmd());
        toggleIntakePistonInOrOut.whenPressed(new ToggleIntakeSolenoidCmd());
        runEleClimb.whenPressed(new RunToPositionMotionMagicCmd(CubeLift.Positions.ClimbingBar));
        climb.whenPressed(new PullUpAndDropCarrierCmdGrp());

        //toggleDoubleLiftDown.whenActive(new ToggleReleaserCmd());
        //toggleDoubleLiftLift.whenActive(new ToggleLiftCmd());

        /* Driver Control */
        //Intake and Scoring
        intake.whileHeld(new IntakeCmd());
        intake.whenPressed(new OpenGrabbersCmd());
        outtake.whileHeld(new OuttakeCmd());
        outtake.whenPressed(new OpenGrabbersCmd());
        score.whenPressed(new ScoreCmdGrp());
        score.whenReleased(new UnpunchCmd());
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

    public double getOpRightTrigger() {
        return this.opPad.getRawAxis(JoystickMap.RIGHT_TRIGGER);
    }

    public double getOpLeftTrigger() {
        return this.opPad.getRawAxis(JoystickMap.LEFT_TRIGGER);
    }

    public double getOpLeftStickY() {
        return stickDeadband(this.opPad.getRawAxis(1), STICK_DEADBAND, 0.0);
    }

}

