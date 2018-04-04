package org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.ScaleToSwitchAutos;

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
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.ScaleToSwitchPaths.LeftSideCloseScaleCloseSwitchPaths;

public class LeftSideCloseScaleCloseSwitchFastAuto extends CommandGroup {
    Command intakeDown = new IntakeDownCmd();
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevatorToScale = new AutoLiftCmdGrp(0.5, CubeLift.Positions.ScoreScale);
    Command driveToScale = new DrivePathCmd(LeftSideCloseScaleCloseSwitchPaths.toScale, false);
    Command scoreCube = new ScoreCmdGrp();
    Command bringElevatorToIntake = new RunToPositionMotionMagicCmd(CubeLift.Positions.Intake);
    Command driveToSwitchA = new DrivePathReverseCmd(LeftSideCloseScaleCloseSwitchPaths.reverse_kTurnToSwitch1A, false);
    Command intakeCube = new IntakeCmdGrp();
    Command driveToSwitchB = new DrivePathCmd(LeftSideCloseScaleCloseSwitchPaths.kTurnToSwitch1B, false);
    Command secureCubeAgain = new SecureCubeCmdGrp();
    Command liftElevatorToSwitch = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreSwitch);
    Command scoreCubeAgain = new ScoreCmdGrp();

    public LeftSideCloseScaleCloseSwitchFastAuto() {
        /*addSequential(intakeDown);
        addSequential(new WaitCommand(0.25));
        addSequential(secureCube);
        */
        addParallel(liftElevatorToScale);
        addSequential(driveToScale);
        addSequential(scoreCube);
        addSequential(new WaitCommand(0.4));
        addParallel(bringElevatorToIntake);
        addSequential(driveToSwitchA);
        addParallel(intakeCube, 3);
        addSequential(driveToSwitchB);
        addSequential(secureCubeAgain);
        addSequential(liftElevatorToSwitch, 3);
        addSequential(scoreCubeAgain);
    }

}
