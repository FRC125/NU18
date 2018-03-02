package org.usfirst.frc.team125.robot.commands.Groups.Autos.PalmettoAutos.ScaleToSwitchAutos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.commands.Groups.AutoLiftCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Intake.AutonomousIntakeCmd;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeDownCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.PalmettoPaths.ScaleToSwitchPaths.LeftSideFarScaleFarSwitchPaths;

public class LeftSideFarScaleFarSwitchAuto extends CommandGroup {
    Command intakeDown = new IntakeDownCmd();
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevatorToScale = new AutoLiftCmdGrp(2.5, CubeLift.Positions.ScoreScale);
    Command driveToBeforeScale = new DrivePathCmd(LeftSideFarScaleFarSwitchPaths.toBeforeScaleTurn);
    Command scoreCube = new ScoreCmdGrp();
    Command bringElevatorToIntake = new RunToPositionMotionMagicCmd(CubeLift.Positions.Intake);
    Command driveToSwitchA = new DrivePathReverseCmd(LeftSideFarScaleFarSwitchPaths.reverse_kTurnToSwitch1A);
    Command intakeCube = new AutonomousIntakeCmd();
    Command driveToSwitchB = new DrivePathCmd(LeftSideFarScaleFarSwitchPaths.kTurnToSwitch1B);
    Command secureCubeAgain = new SecureCubeCmdGrp();
    Command liftElevatorToSwitch = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreSwitch);
    Command scoreCubeAgain = new ScoreCmdGrp();

    public LeftSideFarScaleFarSwitchAuto() {
        /*
        addSequential(intakeDown);
        addSequential(new WaitCommand(0.25));
        addSequential(secureCube);
        */
        addParallel(liftElevatorToScale);
        addSequential(driveToBeforeScale);
        addSequential(scoreCube);
        addSequential(new WaitCommand(0.4));
        addParallel(bringElevatorToIntake);
        addSequential(driveToSwitchA);
        addSequential(new WaitCommand(0.1));
        addParallel(intakeCube, 3);
        addSequential(driveToSwitchB);
        addSequential(secureCubeAgain);
        addSequential(liftElevatorToSwitch, 3);
        addSequential(scoreCubeAgain);
    }

}
