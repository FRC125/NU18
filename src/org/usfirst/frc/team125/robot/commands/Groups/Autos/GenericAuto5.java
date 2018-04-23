package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.Drivetrain.CounterCWAngleTurnCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale.TurnInPlacePaths.LeftSideCloseTwoScaleTurnInPlacePaths;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale.TurnInPlacePaths.LeftSideFarTwoScaleTurnInPlacePaths;

public class GenericAuto5 extends CommandGroup {

    Command turnInPlace = new CounterCWAngleTurnCmd(LeftSideFarTwoScaleTurnInPlacePaths.turnToSwitch);
    Command driveToSwitch = new DrivePathCmd(LeftSideFarTwoScaleTurnInPlacePaths.toSwitch, false);
    Command turnInPlace2 = new CounterCWAngleTurnCmd(LeftSideFarTwoScaleTurnInPlacePaths.turnToScale);
    Command driveToScaleAgain = new DrivePathCmd(LeftSideFarTwoScaleTurnInPlacePaths.toScaleAgain,false);

    public GenericAuto5() {
        addSequential(turnInPlace);
        addSequential(new WaitCommand(0.25));
        addSequential(driveToSwitch);
        addSequential(new WaitCommand(0.8));
        addSequential(turnInPlace2);
        addSequential(driveToScaleAgain);
    }

}
