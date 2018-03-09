package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.PalmettoAutos.CenterAutos.CenterLeftAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.PalmettoAutos.CenterAutos.CenterRightAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.PalmettoAutos.ScaleToSwitchAutos.*;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.PalmettoAutos.SwitchOnlyAutos.LeftSideCloseSwitchAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.PalmettoAutos.SwitchOnlyAutos.LeftSideFarSwitchAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.PalmettoAutos.SwitchOnlyAutos.RightSideCloseSwitchAuto;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.PalmettoAutos.SwitchOnlyAutos.RightSideFarSwitchAuto;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.subsystems.DoubleLift;
import org.usfirst.frc.team125.robot.subsystems.Drivetrain;
import org.usfirst.frc.team125.robot.subsystems.Intake;

public class Robot extends IterativeRobot {

    public static Drivetrain drivetrain = new Drivetrain();
    public static Intake intake = new Intake();
    public static DoubleLift doubleLift = new DoubleLift();
    public static CubeLift cubeLift = new CubeLift();

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
        DoNothing,
    }

    String gameData;

    SendableChooser sideSelector;
    SendableChooser autoSelector;

    //Center Autos
    Command centerLeftAuto = new CenterLeftAuto();
    Command centerRightAuto = new CenterRightAuto();

    //Scale To Switch Autos
    Command leftSideCloseScaleCloseSwitchAuto = new LeftSideCloseScaleCloseSwitchAuto();
    Command leftSideCloseScaleFarSwitchAuto = new LeftSideCloseScaleFarSwitchAuto();
    Command leftSideFarScaleCloseSwitchAuto = new LeftSideFarScaleCloseSwitchAuto();
    Command leftSideFarScaleFarSwitchAuto = new LeftSideFarScaleFarSwitchAuto();
    Command rightSideCloseScaleCloseSwitchAuto = new RightSideCloseScaleCloseSwitchAuto();
    Command rightSideCloseScaleFarSwitchAuto = new RightSideCloseScaleFarSwitchAuto();
    Command rightSideFarScaleCloseSwitchAuto = new RightSideFarScaleCloseSwitchAuto();
    Command rightSideFarScaleFarSwitchAuto = new RightSideFarScaleFarSwitchAuto();

    //Switch Only Autos
    Command leftSideCloseSwitchAuto = new LeftSideCloseSwitchAuto();
    Command leftSideFarSwitchAuto = new LeftSideFarSwitchAuto();
    Command rightSideCloseSwitchAuto = new RightSideCloseSwitchAuto();
    Command rightSideFarSwitchAuto = new RightSideFarSwitchAuto();

    @Override
    public void robotInit() {
        oi = new OI();
        drivetrain.timer.start();
        sideSelector = new SendableChooser();
        autoSelector = new SendableChooser();
        sideSelector.addDefault("Left", Sides.Left); // Left Side
        sideSelector.addObject("Right", Sides.Right); // Right Side
        sideSelector.addObject("Center", Sides.Center); // Right Side
        autoSelector.addDefault("Switch Only", Autos.SwitchOnly);
        autoSelector.addObject("Scale To Switch", Autos.ScaleToSwitch);
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

        if (autoSelector.getSelected().equals(Autos.DoNothing)) {
            autoCommand = new WaitCommand(15);
        }
        else if (sideSelector.getSelected().equals(Sides.Center)) {
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
        } else {
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
        drivetrain.updateLogging();
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
    }

}
