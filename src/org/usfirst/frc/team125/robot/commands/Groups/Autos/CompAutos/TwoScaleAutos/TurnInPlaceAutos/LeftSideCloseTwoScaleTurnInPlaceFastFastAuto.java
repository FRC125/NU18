package org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos.TurnInPlaceAutos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.CounterCWAngleTurnCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.commands.Groups.AutoLiftCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.IntakeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeDownCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale.LeftSideCloseTwoScalePaths;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale.TurnInPlacePaths.LeftSideCloseTwoScaleTurnInPlacePaths;

public class LeftSideCloseTwoScaleTurnInPlaceFastFastAuto extends CommandGroup {
    Command intakeDown = new IntakeDownCmd();
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevatorToScale = new AutoLiftCmdGrp(0.5, CubeLift.Positions.ScoreScale);
    Command driveToScale = new DrivePathCmd(LeftSideCloseTwoScaleTurnInPlacePaths.toScale, false);
    Command scoreCube = new ScoreCmdGrp();
    Command turnTowardsSwitch = new CounterCWAngleTurnCmd(LeftSideCloseTwoScaleTurnInPlacePaths.turnToSwitch);
    Command bringElevatorToIntake = new RunToPositionMotionMagicCmd(CubeLift.Positions.Intake);
    Command driveToSwitch = new DrivePathCmd(LeftSideCloseTwoScaleTurnInPlacePaths.toSwitch, false);
    Command intakeCube = new IntakeCmdGrp();
    Command liftElevatorToScaleAgain = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreScale);
    Command turnTowardsScale = new CounterCWAngleTurnCmd(LeftSideCloseTwoScaleTurnInPlacePaths.turnToScale);
    Command driveToScaleAgain = new DrivePathCmd(LeftSideCloseTwoScaleTurnInPlacePaths.toScaleAgain, false);
    Command scoreCubeAgain = new ScoreCmdGrp();


    public LeftSideCloseTwoScaleTurnInPlaceFastFastAuto() {
        /*addSequential(intakeDown);
        addSequential(new WaitCommand(0.25));
        addSequential(secureCube);
        */
        addParallel(liftElevatorToScale);
        addSequential(driveToScale);
        addSequential(scoreCube);
        addSequential(new WaitCommand(0.4));
        addSequential(turnTowardsSwitch);
        addParallel(bringElevatorToIntake);
        addSequential(new WaitCommand(1));
        addParallel(driveToSwitch);
        addSequential(intakeCube);
        addParallel(liftElevatorToScaleAgain);
        addSequential(turnTowardsScale);
        addSequential(driveToScaleAgain);
        addSequential(scoreCubeAgain);
    }

}
