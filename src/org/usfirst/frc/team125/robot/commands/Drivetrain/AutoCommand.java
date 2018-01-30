package org.usfirst.frc.team125.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Waypoint;
import org.usfirst.frc.team125.robot.util.AutoPaths;

public class AutoCommand extends CommandGroup {
    Command a = new DrivePathCmd(AutoPaths.toSwitch);
    Command b = new DrivePathReverseCmd(AutoPaths.backUp);
    public AutoCommand() {
        addSequential(a);
        addSequential(b);
    }
}
