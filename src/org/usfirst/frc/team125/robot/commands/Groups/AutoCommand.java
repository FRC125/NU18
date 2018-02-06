package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import jaci.pathfinder.Waypoint;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.util.AutoPaths;

public class AutoCommand extends CommandGroup {
    Command a = new DrivePathCmd(AutoPaths.oneMeter);
    Command b = new DrivePathReverseCmd(AutoPaths.oneMeter);
    Command c = new DrivePathCmd(AutoPaths.oneMeter);
    Command d = new DrivePathReverseCmd(AutoPaths.oneMeter);
    Command e = new DrivePathCmd(AutoPaths.sPath);
    public AutoCommand() {
        addSequential(a);
        addSequential(b);
        addSequential(c);
        addSequential(d);
        addSequential(e);
    }
}
