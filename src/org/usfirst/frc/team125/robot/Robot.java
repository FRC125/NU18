package org.usfirst.frc.team125.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team125.robot.commands.CubeLift.ResetCubeLiftEncoderCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.ToggleElevatorSafetyCmd;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.CenterAutos.CenterLeftAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.CenterAutos.CenterLeftFastAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.CenterAutos.CenterRightAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.CenterAutos.CenterRightFastAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SituationalAutos.DriveStraightAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SwitchOnlyAutos.LeftSideCloseSwitchAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SwitchOnlyAutos.LeftSideFarSwitchAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SwitchOnlyAutos.RightSideCloseSwitchAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SwitchOnlyAutos.RightSideFarSwitchAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SwitchToScaleAutos.*;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos.*;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos.Special.LeftSideCloseTwoScaleFastFastSpecialAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos.Special.LeftSideFarJustDriveSlowFastAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos.TurnInPlaceAutos.LeftSideCloseTwoScaleTurnInPlaceFastFastAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos.TurnInPlaceAutos.LeftSideFarTwoScaleTurnInPlaceSlowFastAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos.Variable.LeftSideCloseNullScoreFastFastAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos.Variable.LeftSideFarTwoScaleSlowFastVariableAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.GenericAuto3;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.GenericAuto5;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.TurnInPlaceAuto;
import org.usfirst.frc.team125.robot.subsystems.*;

public class Robot extends IterativeRobot {

    public static Drivetrain drivetrain = new Drivetrain();
    public static Intake intake = new Intake();
    public static DoubleLift doubleLift = new DoubleLift();
    public static MotoredDoubleLift motorDoubleLift = new MotoredDoubleLift();
    public static CubeLift cubeLift = new CubeLift();
    public static LEDController ledController = new LEDController();
    public static OI oi;

    Command autoCommand;

    private enum Sides {
        Left,
        Right,
        Center,
    }

    private enum Autos {
        SwitchOnly,
        ScaleToSwitch,
        SwitchToScale,
        TwoScale,
        TwoScaleVariable,
        TwoScaleSpecial,
        TurnInPlaceTwoScale,
        Situational,
        DoNothing,
    }

    private enum SwitchSettings {
        Fast,
        Normal,
    }

    private enum ScaleSettings {
        SlowFast,
        Fast,
        Normal,
    }

    String gameData;

    SendableChooser sideSelector;
    SendableChooser autoSelector;
    SendableChooser switchSettingsSelector;
    SendableChooser scaleSettingsSelector;

    //Center Autos
    Command centerLeftAuto = new CenterLeftAuto();
    Command centerRightAuto = new CenterRightAuto();
    Command centerLeftFastAuto = new CenterLeftFastAuto();
    Command centerRightFastAuto = new CenterRightFastAuto();

    /* Scale To Switch Autos
    Command leftSideCloseScaleCloseSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.LeftSideCloseScaleCloseSwitchAuto();
    Command leftSideCloseScaleFarSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.LeftSideCloseScaleFarSwitchAuto();
    Command leftSideFarScaleCloseSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.LeftSideFarScaleCloseSwitchAuto();
    Command leftSideFarScaleFarSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.LeftSideFarScaleFarSwitchAuto();
    Command rightSideCloseScaleCloseSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.RightSideCloseScaleCloseSwitchAuto();
    Command rightSideCloseScaleFarSwitchAuto = new RightSideCloseScaleFarSwitchAuto();
    Command rightSideFarScaleCloseSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.RightSideFarScaleCloseSwitchAuto();
    Command rightSideFarScaleFarSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.RightSideFarScaleFarSwitchAuto();
    */

    //Switch Only Autos
    Command leftSideCloseSwitchAuto = new LeftSideCloseSwitchAuto();
    Command leftSideFarSwitchAuto = new LeftSideFarSwitchAuto();
    Command rightSideCloseSwitchAuto = new RightSideCloseSwitchAuto();
    Command rightSideFarSwitchAuto = new RightSideFarSwitchAuto();

    //Two Scale
    Command leftTwoScaleCloseAuto = new LeftSideCloseTwoScaleAuto();
    Command leftTwoScaleCloseSlowFastAuto = new LeftSideCloseTwoScaleSlowFastAuto();
    Command leftTwoScaleCloseFastFastAuto = new LeftSideCloseTwoScaleFastFastAuto();

    Command leftTwoScaleFarAuto = new LeftSideFarTwoScaleAuto();
    Command leftTwoScaleFarSlowFastAuto = new LeftSideFarTwoScaleSlowFastAuto();
    Command leftTwoScaleFarFastFastAuto = new LeftSideFarTwoScaleFastFastAuto();

    Command leftTwoScaleFarSlowFastVariableAuto = new LeftSideFarTwoScaleSlowFastVariableAuto();

    Command leftTwoScaleCloseFastFastSpecialAuto = new LeftSideCloseTwoScaleFastFastSpecialAuto();

    Command leftSideFarJustDriveSlowFastAuto = new LeftSideFarJustDriveSlowFastAuto();

    Command leftSideCloseNullScoreAuto = new LeftSideCloseNullScoreFastFastAuto();

    Command rightTwoScaleCloseAuto = new RightSideCloseTwoScaleAuto();

    //Turn in Place
    Command leftTwoScaleCloseTurnInPlaceAuto = new LeftSideCloseTwoScaleTurnInPlaceFastFastAuto();
    Command leftTwoScaleFarTurnInPlaceAuto = new LeftSideFarTwoScaleTurnInPlaceSlowFastAuto();


    //Switch to Scale
    Command centerLeftSwitchLeftScaleAuto = new CenterLeftSwitchLeftScaleAuto();
    Command centerLeftSwitchLeftScaleFastAuto = new CenterLeftSwitchLeftScaleFastAuto();

    Command centerLeftSwitchRightScaleAuto = new CenterLeftSwitchRightScaleAuto();
    Command centerLeftSwitchRightScaleFastAuto = new CenterLeftSwitchRightScaleFastAuto();

    Command centerRightSwitchLeftScaleAuto = new CenterRightSwitchLeftScaleAuto();
    Command centerRightSwitchLeftScaleFastAuto = new CenterRightSwitchLeftScaleFastAuto();

    Command centerRightSwitchRightScaleAuto = new CenterRightSwitchRightScaleAuto();
    Command centerRightSwitchRightScaleFastAuto = new CenterRightSwitchRightScaleFastAuto();

    //Situational
    Command driveStraightAuto = new TurnInPlaceAuto();

    //Generic
    Command genericAuto = new GenericAuto3();

    @Override
    public void robotInit() {
        oi = new OI();
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(480, 270);
        camera.setFPS(60);
        drivetrain.timer.start();
        this.cubeLift.setNeutralMode(NeutralMode.Coast);
        sideSelector = new SendableChooser();
        autoSelector = new SendableChooser();
        switchSettingsSelector = new SendableChooser();
        scaleSettingsSelector = new SendableChooser();

        sideSelector.addDefault("Left", Sides.Left); // Left Side
        sideSelector.addObject("Right", Sides.Right); // Right Side
        sideSelector.addObject("Center", Sides.Center); // Right Side

        autoSelector.addDefault("Switch Only", Autos.SwitchOnly);
        autoSelector.addObject("Scale To Switch", Autos.ScaleToSwitch);
        autoSelector.addObject("Switch To Scale", Autos.SwitchToScale);
        autoSelector.addObject("Two Scale", Autos.TwoScale);
        autoSelector.addObject("Two Scale Variable", Autos.TwoScaleVariable);
        autoSelector.addObject("Two Scale Special", Autos.TwoScaleSpecial);
        autoSelector.addObject("Turn In Place Two Scale", Autos.TurnInPlaceTwoScale);
        autoSelector.addObject("Situational", Autos.Situational);
        autoSelector.addObject("Do Nothing", Autos.DoNothing);

        switchSettingsSelector.addDefault("Fast", SwitchSettings.Fast);
        switchSettingsSelector.addObject("Normal", SwitchSettings.Normal);

        scaleSettingsSelector.addDefault("Fast", ScaleSettings.Fast);
        scaleSettingsSelector.addObject("Slow & Fast", ScaleSettings.SlowFast);
        scaleSettingsSelector.addObject("Normal", ScaleSettings.Normal);

        SmartDashboard.putData("Side Selector", sideSelector);
        SmartDashboard.putData("Auto Selector", autoSelector);
        SmartDashboard.putData("Switch Settings", switchSettingsSelector);
        SmartDashboard.putData("Scale Settings", scaleSettingsSelector);
    }

    @Override
    public void disabledInit() {
        this.cubeLift.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        updateSmartdashboard();
    }


    @Override
    public void autonomousInit() {
        this.drivetrain.disableRamping();
        this.cubeLift.setNeutralMode(NeutralMode.Brake);

        String gameDataTemp = DriverStation.getInstance().getGameSpecificMessage();
        if (gameDataTemp != null) {
            gameData = DriverStation.getInstance().getGameSpecificMessage().substring(0, 2);
        } else {
            System.out.println("NO GAME DATA!");
            gameData = "";
        }

        if (autoSelector.getSelected().equals(Autos.DoNothing)) { // Do Nothing
            autoCommand = new WaitCommand(15);
        } else if (sideSelector.getSelected().equals(Sides.Center)) { // Center
            if (switchSettingsSelector.getSelected().equals(SwitchSettings.Normal)) {
                if (autoSelector.getSelected().equals(Autos.SwitchToScale)) {
                    switch (gameData) {
                        case "LR":
                            autoCommand = centerLeftSwitchRightScaleAuto;
                            break;
                        case "RL":
                            autoCommand = centerRightSwitchLeftScaleAuto;
                            break;
                        case "LL":
                            autoCommand = centerLeftSwitchLeftScaleAuto;
                            break;
                        case "RR":
                            autoCommand = centerRightSwitchRightScaleAuto;
                            break;
                        default:
                            autoCommand = new WaitCommand(15);
                            break;
                    }
                } else {
                    switch (gameData.substring(0, 1)) {
                        case "L":
                            autoCommand = centerLeftAuto;
                            break;
                        case "R":
                            autoCommand = centerRightAuto;
                            break;
                        default:
                            autoCommand = new WaitCommand(15);
                            break;
                    }
                }
            } else {
                if (autoSelector.getSelected().equals(Autos.SwitchToScale)) {
                    switch (gameData) {
                        case "LR":
                            autoCommand = centerLeftSwitchRightScaleFastAuto;
                            break;
                        case "RL":
                            autoCommand = centerRightSwitchLeftScaleFastAuto;
                            break;
                        case "LL":
                            autoCommand = centerLeftSwitchLeftScaleFastAuto;
                            break;
                        case "RR":
                            autoCommand = centerRightSwitchRightScaleFastAuto;
                            break;
                        default:
                            autoCommand = new WaitCommand(15);
                            break;
                    }
                } else {
                    switch (gameData.substring(0, 1)) {
                        case "L":
                            autoCommand = centerLeftFastAuto;
                            break;
                        case "R":
                            autoCommand = centerRightFastAuto;
                            break;
                        default:
                            autoCommand = new WaitCommand(15);
                            break;
                    }
                }
            }
        } else if (autoSelector.getSelected().equals(Autos.Situational)) { // Situational
            switch (gameData) {
                case "LR": // GOOD!
                    if (sideSelector.getSelected().equals(Sides.Left)) {
                        autoCommand = leftSideCloseSwitchAuto;
                    } else {
                        autoCommand = rightTwoScaleCloseAuto;
                    }
                    break;
                case "RL": // GOOD!
                    if (sideSelector.getSelected().equals(Sides.Left)) {
                        autoCommand = leftTwoScaleCloseAuto;
                    } else {
                        autoCommand = rightSideCloseSwitchAuto;
                    }
                    break;

                case "LL": //GOOD!
                    if (sideSelector.getSelected().equals(Sides.Left)) {
                        autoCommand = leftTwoScaleCloseAuto;
                    } else {
                        autoCommand = driveStraightAuto;
                    }
                    break;

                case "RR": //GOOD!
                    if (sideSelector.getSelected().equals(Sides.Left)) {
                        autoCommand = driveStraightAuto;
                    } else {
                        autoCommand = rightTwoScaleCloseAuto;
                    }
                    break;

                default:
                    autoCommand = new WaitCommand(15);
                    break;
            }
        } else if (autoSelector.getSelected().equals(Autos.TwoScale)) { // Two Scale
            if (scaleSettingsSelector.getSelected().equals(ScaleSettings.Normal)) {
                switch (gameData.substring(1, 2)) {
                    case "L":
                        autoCommand = leftTwoScaleCloseAuto;
                        break;
                    case "R":
                        autoCommand = leftTwoScaleFarAuto;
                        break;
                    default:
                        autoCommand = new WaitCommand(15);
                        break;
                }
            } else if (scaleSettingsSelector.getSelected().equals(ScaleSettings.Fast)) {
                switch (gameData.substring(1, 2)) {
                    case "L":
                        autoCommand = leftTwoScaleCloseFastFastAuto;
                        break;
                    case "R":
                        autoCommand = leftTwoScaleFarFastFastAuto;
                        break;
                    default:
                        autoCommand = new WaitCommand(15);
                        break;
                }
            } else {
                switch (gameData.substring(1, 2)) {
                    case "L":
                        autoCommand = leftTwoScaleCloseFastFastAuto;
                        break;
                    case "R":
                        autoCommand = leftTwoScaleFarSlowFastAuto;
                        break;
                    default:
                        autoCommand = new WaitCommand(15);
                        break;
                }
            }
        } else if(autoSelector.getSelected().equals(Autos.TwoScaleVariable)) {
            switch (gameData.substring(1, 2)) {
                case "L":
                    autoCommand = leftTwoScaleCloseTurnInPlaceAuto;
                    break;
                case "R":
                    autoCommand = leftSideFarJustDriveSlowFastAuto;
                    break;
                default:
                    autoCommand = new WaitCommand(15);
                    break;
            }
        }
        else if(autoSelector.getSelected().equals(Autos.TurnInPlaceTwoScale)) {
            switch (gameData.substring(1, 2)) {
                case "L":
                    autoCommand = leftTwoScaleCloseTurnInPlaceAuto;
                    break;
                case "R":
                    autoCommand = leftTwoScaleFarTurnInPlaceAuto;
                    break;
                default:
                    autoCommand = new WaitCommand(15);
                    break;
            }
        }
        else if(autoSelector.getSelected().equals(Autos.TwoScaleSpecial)) {
            switch (gameData.substring(1, 2)) {
                case "L":
                    autoCommand = leftTwoScaleCloseTurnInPlaceAuto;
                    break;
                case "R":
                    autoCommand = leftSideFarJustDriveSlowFastAuto;
                    break;
                default:
                    autoCommand = new WaitCommand(15);
                    break;
            }
        } else {
            autoCommand = new DriveStraightAuto();
        }

        /*
        else { // Scale Switch
            switch (gameData) {
                case "LR": // GOOD!
                    if (sideSelector.getSelected().equals(Sides.Left)) {
                        if (autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                            autoCommand = leftSideCloseSwitchAuto;
                        }
                        if (autoSelector.getSelected().equals(Autos.ScaleToSwitch)) {
                            autoCommand = leftSideFarScaleCloseSwitchAuto;
                        }
                    } else {
                        if (autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                            autoCommand = rightSideFarSwitchAuto;
                        }
                        if (autoSelector.getSelected().equals(Autos.ScaleToSwitch)) {
                            autoCommand = rightSideCloseScaleFarSwitchAuto;
                        }
                    }
                    break;
                case "RL": // GOOD!
                    if (sideSelector.getSelected().equals(Sides.Left)) {
                        if (autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                            autoCommand = leftSideFarSwitchAuto;
                        }
                        if (autoSelector.getSelected().equals(Autos.ScaleToSwitch)) {
                            autoCommand = leftSideCloseScaleFarSwitchAuto;
                        }
                    } else {
                        if (autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                            autoCommand = rightSideCloseSwitchAuto;
                        }
                        if (autoSelector.getSelected().equals(Autos.ScaleToSwitch)) {
                            autoCommand = rightSideFarScaleCloseSwitchAuto;
                        }
                    }
                    break;

                case "LL": //GOOD!
                    if (sideSelector.getSelected().equals(Sides.Left)) {
                        if (autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                            autoCommand = leftSideCloseSwitchAuto;
                        }
                        if (autoSelector.getSelected().equals(Autos.ScaleToSwitch)) {
                            autoCommand = leftSideCloseScaleCloseSwitchAuto;
                        }
                    } else {
                        if (autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                            autoCommand = rightSideFarSwitchAuto;
                        }
                        if (autoSelector.getSelected().equals(Autos.ScaleToSwitch)) {
                            autoCommand = rightSideFarScaleFarSwitchAuto;
                        }
                    }
                    break;

                case "RR": //GOOD!
                    if (sideSelector.getSelected().equals(Sides.Left)) {
                        if (autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                            autoCommand = leftSideFarSwitchAuto;
                        }
                        if (autoSelector.getSelected().equals(Autos.ScaleToSwitch)) {
                            autoCommand = leftSideFarScaleFarSwitchAuto;
                        }
                    } else {
                        if (autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                            autoCommand = rightSideCloseSwitchAuto;
                        }
                        if (autoSelector.getSelected().equals(Autos.ScaleToSwitch)) {
                            autoCommand = rightSideCloseScaleCloseSwitchAuto;
                        }
                    }
                    break;

                default:
                    autoCommand = new WaitCommand(15);
                    break;
            }
        }
        */
        //TODO: REMOVE THIS LINE
        //autoCommand = leftTwoScaleCloseFastFastAuto;
        autoCommand.start();
        SmartDashboard.putString("Chosen Auto", autoCommand.toString());
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        updateSmartdashboard();
    }

    @Override
    public void teleopInit() {
        this.cubeLift.setNeutralMode(NeutralMode.Brake);
        this.drivetrain.enableRamping();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateSmartdashboard();
    }

    @Override
    public void testPeriodic() {

    }

    public void updateSmartdashboard() {
        SmartDashboard.putNumber("Left dt encoder", this.drivetrain.getEncoderRawLeft());
        SmartDashboard.putNumber("Right dt encoder", this.drivetrain.getEncoderRawRight());
        SmartDashboard.putNumber("Left dt meters", this.drivetrain.getEncoderDistanceMetersLeft());
        SmartDashboard.putNumber("Right dt meters", this.drivetrain.getEncoderDistanceMetersRight());
        SmartDashboard.putNumber("Left dt speed", this.drivetrain.getLeftVelocity());
        SmartDashboard.putNumber("Right dt speed", this.drivetrain.getRightVelocity());
        SmartDashboard.putNumber("Gyro angle", this.drivetrain.getAngle());
        SmartDashboard.putNumber("Elevator encoder Quadrature Position", this.cubeLift.getQuadraturePosition());
        this.drivetrain.updateAccelDashboard();
        this.cubeLift.updatePIDFOnDashboard();
        this.cubeLift.updatePIDFFromDashboard();
        SmartDashboard.putString("Elevator state", this.cubeLift.getState().toString());
        SmartDashboard.putString("Elevator position", this.cubeLift.getPosition().toString());
        SmartDashboard.putNumber("Gyro rate", this.drivetrain.getGyroRate());
        SmartDashboard.putNumber("opPad POV", this.oi.opPad.getPOV());
        SmartDashboard.putString("Smart intake state", this.intake.getSmartIntakeState().toString());
        SmartDashboard.putString("Ultra Smart intake state", this.intake.getUltraSmartIntakeState().toString());
        SmartDashboard.putNumber("Ultra Smart intake left inches", this.intake.getUltraSmartIntakeLeftInches());
        SmartDashboard.putNumber("Ultra Smart intake right inches", this.intake.getUltraSmartIntakeRightInches());

        //Commands
        SmartDashboard.putData("Toggle elevator safety", new ToggleElevatorSafetyCmd());
        SmartDashboard.putData("Reset cube lift encoder", new ResetCubeLiftEncoderCmd());
    }

}
