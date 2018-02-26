package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.util.Paths.PalmettoPaths.ScaleToSwitchPaths.LeftSideCloseScaleFarSwitchPaths;

public class GenericAuto extends CommandGroup {
    Command genericCmd = new DrivePathReverseCmd(LeftSideCloseScaleFarSwitchPaths.reverse_kTurnToSwitch1A);
    Command genericCmd2 = new DrivePathCmd(LeftSideCloseScaleFarSwitchPaths.kTurnToSwitch1B);

    public GenericAuto() {
        //addSequential(genericCmd);
        addSequential(genericCmd2);
    }

}
