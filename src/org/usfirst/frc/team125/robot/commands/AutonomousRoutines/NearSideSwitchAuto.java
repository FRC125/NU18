package org.usfirst.frc.team125.robot.commands.AutonomousRoutines;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.CubeLift.CloseGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.OpenGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.AutoPaths;

public class NearSideSwitchAuto extends CommandGroup {

    Command closeGrabbers = new CloseGrabbersCmd();
    Command liftToSwitch = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreSwitch);
    Command driveToSwitch = new DrivePathCmd(AutoPaths.toSwitch);
    Command openGrabbers = new OpenGrabbersCmd();
    NearSideSwitchAuto() {
        addSequential(closeGrabbers);
        addParallel(liftToSwitch);
        addSequential(driveToSwitch);
        addSequential(openGrabbers);
    }
}
