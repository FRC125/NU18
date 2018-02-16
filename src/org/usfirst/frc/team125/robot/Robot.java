package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team125.robot.commands.Groups.Autos.*;
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
    //Command turnToAngle = new TurnToAngleCmd(90);

    private enum Sides {
        Left,
        Right,
    }

    private enum Autos {
        SwitchOnly,
        ScaleOnly,
        SwitchToScale,
        ScaleToSwitch,
    }
    String gameData ;
    SendableChooser sideSelector = new SendableChooser();
    SendableChooser autoSelector = new SendableChooser();


    @Override
    public void robotInit() {
        oi = new OI();
        drivetrain.timer.start();
    }

    @Override
    public void disabledInit() {
        gameData = DriverStation.getInstance().getGameSpecificMessage().substring(0,2);
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        updateSmartdashboard();
        sideSelector.addDefault("Left", Sides.Left); // Left Side
        sideSelector.addObject("Right" , Sides.Right); // Right Side
        autoSelector.addDefault("Switch Only", Autos.SwitchOnly);
        autoSelector.addObject("Scale Only", Autos.ScaleOnly);
    }


    @Override
    public void autonomousInit() {
        gameData = DriverStation.getInstance().getGameSpecificMessage().substring(0,2);
        switch (gameData) {

            case "LR" : // GOOD!
               if(sideSelector.getSelected().equals(Sides.Left)) {
                   if(autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                       autoCommand = new LeftSideCloseSwitchAuto();
                   }
                   if(autoSelector.getSelected().equals(Autos.ScaleOnly)) {
                        autoCommand = new LeftSideFarScaleAuto();
                   }
               } else {
                   if(autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                        autoCommand = new RightSideFarSwitchAuto();
                   }
                   if(autoSelector.getSelected().equals(Autos.ScaleOnly)) {
                        autoCommand = new RightSideCloseScaleAuto();
                   }
               }
                break;

            case "RL" : // GOOD!
                if(sideSelector.getSelected().equals(Sides.Left)) {
                    if(autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                        autoCommand = new LeftSideFarSwitchAuto();
                    }
                    if(autoSelector.getSelected().equals(Autos.ScaleOnly)) {
                        autoCommand = new LeftSideCloseScaleAuto();
                    }
                } else {
                    if(autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                        autoCommand = new RightSideCloseSwitchAuto();
                    }
                    if(autoSelector.getSelected().equals(Autos.ScaleOnly)) {
                        autoCommand = new RightSideFarScaleAuto();
                    }
                }
                break;

            case "LL" : //GOOD!
                if(sideSelector.getSelected().equals(Sides.Left)) {
                    if(autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                        autoCommand = new LeftSideCloseSwitchAuto();
                    }
                    if(autoSelector.getSelected().equals(Autos.ScaleOnly)) {
                        autoCommand = new LeftSideCloseScaleAuto();
                    }
                } else {
                    if(autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                        autoCommand = new RightSideFarSwitchAuto();
                    }
                    if(autoSelector.getSelected().equals(Autos.ScaleOnly)) {
                        autoCommand = new RightSideFarScaleAuto();
                    }
                }
                break;

            case "RR" : //GOOD!
                if(sideSelector.getSelected().equals(Sides.Left)) {
                    if(autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                        autoCommand = new LeftSideFarSwitchAuto();
                    }
                    if(autoSelector.getSelected().equals(Autos.ScaleOnly)) {
                        autoCommand = new LeftSideFarScaleAuto();
                    }
                } else {
                    if(autoSelector.getSelected().equals(Autos.SwitchOnly)) {
                        autoCommand = new RightSideCloseSwitchAuto();
                    }
                    if(autoSelector.getSelected().equals(Autos.ScaleOnly)) {
                        autoCommand = new RightSideCloseScaleAuto();
                    }
                }
                break;

            default:
                break;
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
        SmartDashboard.putNumber("Elevator encoder PWP", this.cubeLift.getPulseWidthPosition());
        SmartDashboard.putNumber("Elevator encoder relative position", this.cubeLift.getRelativeEncPos());
        this.drivetrain.updateAccelDashboard();
        this.cubeLift.updatePIDFOnDashboard();
        this.cubeLift.updatePIDFFromDashboard();
        SmartDashboard.putString("Elevator state", this.cubeLift.getState().toString());
        SmartDashboard.putString("Elevator position", this.cubeLift.getPosition().toString());
        SmartDashboard.putNumber("Gyro rate", this.drivetrain.getGyroRate());
        SmartDashboard.putString("Game data" , gameData);
        SmartDashboard.putString("Selected Side", sideSelector.getSelected().toString());
        SmartDashboard.putString("Selected Auto", autoSelector.getSelected().toString());
    }

}
