package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.util.Paths.GenericPaths;

public class GenericAuto extends CommandGroup {

    Command driveOne = new DrivePathReverseCmd(GenericPaths.pathOne, true);
    Command driveTwo = new DrivePathCmd(GenericPaths.pathTwo, true);
    Command driveSwitchGeneric = new DrivePathCmd(GenericPaths.toSwitchGeneric, false);
    Command driveGoBackGeneric = new DrivePathReverseCmd(GenericPaths.reverse_goBackGeneric, false);
    Command driveToCubeGeneric = new DrivePathCmd(GenericPaths.toCubeGeneric, false);
    Command driveBackOffCubeGeneric = new DrivePathReverseCmd(GenericPaths.reverse_backOffCubeGeneric, false);
    Command driveToSwitchAgainGeneric = new DrivePathCmd(GenericPaths.toSwitchAgainGeneric, false);
    public GenericAuto() {
        addSequential(driveSwitchGeneric);
        addSequential(driveGoBackGeneric);
        addSequential(driveToCubeGeneric);
        addSequential(driveBackOffCubeGeneric);
        addSequential(driveToSwitchAgainGeneric);
        //addSequential(driveTwo);
    }

}
