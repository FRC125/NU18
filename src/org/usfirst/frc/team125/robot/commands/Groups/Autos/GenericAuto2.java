package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.util.Paths.GenericPaths;

public class GenericAuto2 extends CommandGroup {

    boolean runSlow = false;
    Command driveSwitchA = new DrivePathReverseCmd(GenericPaths.reverse_kTurnToSwitch1AGeneric, runSlow);
    Command driveSwitchB = new DrivePathCmd(GenericPaths.kTurnToSwitch1BGeneric, runSlow);
    Command driveScaleA = new DrivePathReverseCmd(GenericPaths.reverse_kTurnToScaleAGeneric, runSlow);
    Command driveScaleB = new DrivePathCmd(GenericPaths.kTurnToScaleBGeneric, runSlow);

    public GenericAuto2() {
        addSequential(driveSwitchA);
        addSequential(driveSwitchB);
        addSequential(driveScaleA);
        addSequential(driveScaleB);
        //addSequential(driveTwo);
    }

}
