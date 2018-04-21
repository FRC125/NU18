package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.Drivetrain.CounterCWAngleTurnCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale.TurnInPlacePaths.LeftSideCloseTwoScaleTurnInPlacePaths;

public class GenericAuto6 extends CommandGroup {

    Command turnInPlace = new CounterCWAngleTurnCmd(LeftSideCloseTwoScaleTurnInPlacePaths.turnToSwitch);
    Command driveToSwitch = new DrivePathCmd(LeftSideCloseTwoScaleTurnInPlacePaths.toSwitch, false);
    Command turnInPlace2 = new CounterCWAngleTurnCmd(LeftSideCloseTwoScaleTurnInPlacePaths.turnToScale);
    Command driveToScaleAgain = new DrivePathCmd(LeftSideCloseTwoScaleTurnInPlacePaths.toScaleAgain,false);

    public GenericAuto6() {
        addSequential(turnInPlace);
        addSequential(new WaitCommand(0.25));
        addSequential(driveToSwitch);
        addSequential(new WaitCommand(0.8));
        addSequential(turnInPlace2);
        addSequential(driveToScaleAgain);

    }

}
