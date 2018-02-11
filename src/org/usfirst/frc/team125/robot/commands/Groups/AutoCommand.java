package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import jaci.pathfinder.Waypoint;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeCmd;
import org.usfirst.frc.team125.robot.commands.Intake.OuttakeCmd;
import org.usfirst.frc.team125.robot.util.AutoPaths;

public class AutoCommand extends CommandGroup {
    Command a = new DrivePathCmd(AutoPaths.toLine);
    Command b = new DrivePathReverseCmd(AutoPaths.backUp);
    Command c = new DrivePathCmd(AutoPaths.toLineFar);
    Command d = new DrivePathReverseCmd(AutoPaths.postToLineFar);
    public AutoCommand() {
        addSequential(a);
        addSequential(b);
        addSequential(c);
        addSequential(d);
    }
}
