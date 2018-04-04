package org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SwitchToScaleAutos;

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
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.CenterSwitchToScale.CenterLeftSwitchRightScalePaths;

public class CenterLeftSwitchRightScaleAuto extends CommandGroup {
    Command intakeDown = new IntakeDownCmd();
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevator = new AutoLiftCmdGrp(0.1, CubeLift.Positions.ScoreSwitch);
    Command driveToSwitch = new DrivePathCmd(CenterLeftSwitchRightScalePaths.toSwitch, true);
    Command scoreCube = new ScoreCmdGrp();
    Command bringEleToIntake = new RunToPositionMotionMagicCmd(CubeLift.Positions.Intake);
    Command driveBackToLine = new DrivePathReverseCmd(CenterLeftSwitchRightScalePaths.reverse_goBack, true);
    Command driveToCube = new DrivePathCmd(CenterLeftSwitchRightScalePaths.toCube, true);
    Command intakeCube = new IntakeCmdGrp();
    Command backOffCube = new DrivePathReverseCmd(CenterLeftSwitchRightScalePaths.reverse_backOffCube, true);
    Command liftElevatorAgain = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreSwitch);
    Command driveToScale = new DrivePathCmd(CenterLeftSwitchRightScalePaths.toScale, true);


    public CenterLeftSwitchRightScaleAuto() {
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
        addSequential(new WaitCommand(3));
        addSequential(bringEleToIntake);
        addParallel(driveToCube);
        addSequential(intakeCube);
        addParallel(liftElevatorAgain);
        addSequential(backOffCube);
        addSequential(driveToScale);
    }

}
