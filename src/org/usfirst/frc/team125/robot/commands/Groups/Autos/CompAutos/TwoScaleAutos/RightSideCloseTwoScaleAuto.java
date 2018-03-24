package org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.commands.Groups.AutoLiftCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.IntakeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeDownCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale.RightSideCloseTwoScalePaths;

public class RightSideCloseTwoScaleAuto extends CommandGroup {
    Command intakeDown = new IntakeDownCmd();
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevatorToScale = new AutoLiftCmdGrp(0.5, CubeLift.Positions.ScoreScale);
    Command driveToScale = new DrivePathCmd(RightSideCloseTwoScalePaths.toScale);
    Command scoreCube = new ScoreCmdGrp();
    Command bringElevatorToIntake = new RunToPositionMotionMagicCmd(CubeLift.Positions.Intake);
    Command driveToSwitchA = new DrivePathReverseCmd(RightSideCloseTwoScalePaths.reverse_kTurnToSwitch1A);
    Command intakeCube = new IntakeCmdGrp();
    Command driveToSwitchB = new DrivePathCmd(RightSideCloseTwoScalePaths.kTurnToSwitch1B);
    Command liftElevatorToScaleAgain = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreScale);
    Command driveToScaleA = new DrivePathReverseCmd(RightSideCloseTwoScalePaths.reverse_kTurnToScaleA);
    Command driveToScaleB = new DrivePathCmd(RightSideCloseTwoScalePaths.kTurnToScaleB);
    Command scoreCubeAgain = new ScoreCmdGrp();

    public RightSideCloseTwoScaleAuto() {
        /*addSequential(intakeDown);
        addSequential(new WaitCommand(0.25));
        addSequential(secureCube);
        */
        addParallel(liftElevatorToScale);
        addSequential(driveToScale);
        addSequential(scoreCube);
        addSequential(new WaitCommand(0.4));
        addParallel(driveToSwitchA);
        addSequential(new WaitCommand(1));
        addSequential(bringElevatorToIntake);
        addParallel(driveToSwitchB);
        addSequential(intakeCube);
        addParallel(liftElevatorToScaleAgain, 3);
        addSequential(driveToScaleA);
        /*addSequential(driveToScaleB);
        addSequential(scoreCubeAgain);
        */
    }

}
