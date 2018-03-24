package org.usfirst.frc.team125.robot;

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
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.CenterAutos.CenterRightAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.RightSideCloseScaleFarSwitchAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SituationalAutos.DriveStraightAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SwitchOnlyAutos.LeftSideCloseSwitchAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SwitchOnlyAutos.LeftSideFarSwitchAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SwitchOnlyAutos.RightSideCloseSwitchAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SwitchOnlyAutos.RightSideFarSwitchAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos.LeftSideCloseTwoScaleAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos.LeftSideFarTwoScaleAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos.RightSideCloseTwoScaleAuto;
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
        Situational,
        DoNothing,
    }

    String gameData;

    SendableChooser sideSelector;
    SendableChooser autoSelector;

    //Center Autos
    Command centerLeftAuto = new CenterLeftAuto();
    Command centerRightAuto = new CenterRightAuto();

    //Scale To Switch Autos
    Command leftSideCloseScaleCloseSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.LeftSideCloseScaleCloseSwitchAuto();
    Command leftSideCloseScaleFarSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.LeftSideCloseScaleFarSwitchAuto();
    Command leftSideFarScaleCloseSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.LeftSideFarScaleCloseSwitchAuto();
    Command leftSideFarScaleFarSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.LeftSideFarScaleFarSwitchAuto();
    Command rightSideCloseScaleCloseSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.RightSideCloseScaleCloseSwitchAuto();
    Command rightSideCloseScaleFarSwitchAuto = new RightSideCloseScaleFarSwitchAuto();
    Command rightSideFarScaleCloseSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.RightSideFarScaleCloseSwitchAuto();
    Command rightSideFarScaleFarSwitchAuto = new org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos.RightSideFarScaleFarSwitchAuto();

    //Switch Only Autos
    Command leftSideCloseSwitchAuto = new LeftSideCloseSwitchAuto();
    Command leftSideFarSwitchAuto = new LeftSideFarSwitchAuto();
    Command rightSideCloseSwitchAuto = new RightSideCloseSwitchAuto();
    Command rightSideFarSwitchAuto = new RightSideFarSwitchAuto();

    //Two Scale
    Command leftTwoScaleCloseAuto = new LeftSideCloseTwoScaleAuto();
    Command leftTwoScaleFarAuto = new LeftSideFarTwoScaleAuto();
    Command rightTwoScaleCloseAuto = new RightSideCloseTwoScaleAuto();

    //Situational
    Command driveStraightAuto = new DriveStraightAuto();

    @Override
    public void robotInit() {
        oi = new OI();
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(480, 270);
        camera.setFPS(60);
        drivetrain.timer.start();
        sideSelector = new SendableChooser();
        autoSelector = new SendableChooser();
        sideSelector.addDefault("Left", Sides.Left); // Left Side
        sideSelector.addObject("Right", Sides.Right); // Right Side
        sideSelector.addObject("Center", Sides.Center); // Right Side
        autoSelector.addDefault("Switch Only", Autos.SwitchOnly);
        autoSelector.addObject("Scale To Switch", Autos.ScaleToSwitch);
        autoSelector.addObject("Two Scale", Autos.TwoScale);
        autoSelector.addObject("Situational", Autos.Situational);
        autoSelector.addObject("Do Nothing", Autos.DoNothing);
        SmartDashboard.putData("Side Selector", sideSelector);
        SmartDashboard.putData("Auto Selector", autoSelector);
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        updateSmartdashboard();
    }


    @Override
    public void autonomousInit() {
        this.drivetrain.disableRamping();

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
            switch (gameData.substring(1, 2)) {
                case "L":
                    autoCommand = leftTwoScaleCloseAuto;
                    break;
                case "R":
                    autoCommand = leftTwoScaleFarAuto; // TODO: MAKE IT RIGHT AGAIN
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

        //Commands
        SmartDashboard.putData("Toggle elevator safety", new ToggleElevatorSafetyCmd());
        SmartDashboard.putData("Reset cube lift encoder", new ResetCubeLiftEncoderCmd());
    }

}
