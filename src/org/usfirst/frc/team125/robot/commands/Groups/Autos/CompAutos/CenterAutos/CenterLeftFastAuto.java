package org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.CenterAutos;

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
import org.usfirst.frc.team125.robot.commands.Intake.IntakeUpCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.CenterPaths.CenterLeftPath;

public class CenterLeftFastAuto extends CommandGroup {
    Command intakeDown = new IntakeDownCmd();
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevator = new AutoLiftCmdGrp(0.1, CubeLift.Positions.ScoreSwitch);
    Command driveToSwitch = new DrivePathCmd(CenterLeftPath.toSwitch, false);
    Command scoreCube = new ScoreCmdGrp();
    Command bringEleToIntake = new RunToPositionMotionMagicCmd(CubeLift.Positions.Intake);
    Command driveBackToLine = new DrivePathReverseCmd(CenterLeftPath.reverse_goBack, false);
    Command driveToCube = new DrivePathCmd(CenterLeftPath.toCube, false);
    Command intakeCube = new IntakeCmdGrp();
    Command backOffCube = new DrivePathReverseCmd(CenterLeftPath.reverse_backOffCube, false);
    Command liftElevatorAgain = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreSwitch);
    Command driveToSwitchAgain = new DrivePathCmd(CenterLeftPath.toSwitchAgain, false);
    Command liftIntake = new IntakeUpCmd();
    Command scoreCubeAgain = new ScoreCmdGrp();

    //Third Cube
    Command backOffSwitch = new DrivePathReverseCmd(CenterLeftPath.backOffSwitch, false);
    Command turnTowardsCube = new CounterCWAngleTurnCmd(CenterLeftPath.turnTowardsCubes);
    Command bringEleToIntakeAgain = new RunToPositionMotionMagicCmd(CubeLift.Positions.Intake);
    Command driveTowardsCubeAgain = new DrivePathCmd(CenterLeftPath.toCubeAgain, false);
    Command intakeCubeAgain = new IntakeCmdGrp();
    Command liftElevatorAgainAgain = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreSwitch);
    Command backOffCubeAgain = new DrivePathReverseCmd(CenterLeftPath.backOffCubeAgain, false);
    Command turnTowardsSwitch = new CounterCWAngleTurnCmd(CenterLeftPath.turnBack);
    Command driveToSwitchAgainAgain = new DrivePathCmd(CenterLeftPath.toSwitchAgainAgain, false);
    Command scoreCubeAgainAgain = new ScoreCmdGrp();

    public CenterLeftFastAuto() {
        /*
        addSequential(intakeDown);
        addSequential(new WaitCommand(0.25));
        addSequential(secureCube);
        */
        //addParallel(liftElevator);
        addSequential(driveToSwitch);
        addSequential(scoreCube);
        addSequential(new WaitCommand(0.4));
        addParallel(driveBackToLine);
        addSequential(new WaitCommand(1.5));
        addSequential(bringEleToIntake);
        addParallel(driveToCube);
        addSequential(intakeCube);
        addParallel(liftElevatorAgain);
        addSequential(backOffCube);
        addParallel(liftIntake);
        addSequential(driveToSwitchAgain);
        addSequential(scoreCubeAgain);

        //Third Cube
        addSequential(new WaitCommand(0.4));
        addSequential(backOffSwitch);
        addParallel(bringEleToIntakeAgain);
        addSequential(turnTowardsCube);
        addParallel(driveTowardsCubeAgain);
        addSequential(intakeCubeAgain);
        addParallel(liftElevatorAgainAgain);
        addSequential(backOffCubeAgain);
        addSequential(turnTowardsSwitch);
        addSequential(driveToSwitchAgainAgain);
        addSequential(scoreCubeAgainAgain);

    }


}
