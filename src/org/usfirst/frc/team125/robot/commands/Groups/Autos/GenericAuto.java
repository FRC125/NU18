package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.util.Paths.GenericPaths;

public class GenericAuto extends CommandGroup {

    boolean runSlow = false;
    Command driveSwitchGeneric = new DrivePathCmd(GenericPaths.toSwitchGeneric, runSlow);
    Command driveGoBackGeneric = new DrivePathReverseCmd(GenericPaths.reverse_goBackGeneric, runSlow);
    Command driveToCubeGeneric = new DrivePathCmd(GenericPaths.toCubeGeneric, runSlow);
    Command driveBackOffCubeGeneric = new DrivePathReverseCmd(GenericPaths.reverse_backOffCubeGeneric, runSlow);
    Command driveToSwitchAgainGeneric = new DrivePathCmd(GenericPaths.toSwitchAgainGeneric, runSlow);

    public GenericAuto() {
        addSequential(driveSwitchGeneric);
        addSequential(driveGoBackGeneric);
        addSequential(driveToCubeGeneric);
        addSequential(driveBackOffCubeGeneric);
        addSequential(driveToSwitchAgainGeneric);
    }

}
