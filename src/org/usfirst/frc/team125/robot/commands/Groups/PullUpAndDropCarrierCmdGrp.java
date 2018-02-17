package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.*;
import org.usfirst.frc.team125.robot.commands.DoubleLift.DropLiftCmd;
import org.usfirst.frc.team125.robot.commands.DoubleLift.ReleaseCarrierCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.LeftSideCloseScalePaths;

public class PullUpAndDropCarrierCmdGrp extends CommandGroup {

    public PullUpAndDropCarrierCmdGrp() {
        addSequential(new UnpinCmd());
        addSequential(new RunToPositionMotionMagicCmd(CubeLift.Positions.ChinUp));
        addSequential(new ReleaseCarrierCmd());
    }

}
