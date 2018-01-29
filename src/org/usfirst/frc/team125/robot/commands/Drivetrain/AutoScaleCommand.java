package org.usfirst.frc.team125.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.util.AutoPaths;

public class AutoScaleCommand extends CommandGroup{

    public AutoScaleCommand() {
        addSequential(new DrivePathCmd(AutoPaths.toSwitch));
        //addSequential(new DrivePathReverseCmd(AutoPaths.backUp));
        //addSequential(new DrivePathCmd(AutoPaths.postBackup));
    }

}
