package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.util.RightSideCloseSwitchCloseScalePaths;
import org.usfirst.frc.team125.robot.util.RightSideFarSwitchCloseScalePaths;

public class RightSideFarSwitchCloseScaleAuto extends CommandGroup {

    public Command driveToFarSwitch = new DrivePathCmd(RightSideFarSwitchCloseScalePaths.toFarSwitch);
    public Command driveToFarSwitchButBackup = new DrivePathReverseCmd(RightSideFarSwitchCloseScalePaths.backUpAfterSwitch);
    public RightSideFarSwitchCloseScaleAuto() {
        addSequential(driveToFarSwitch);
        addSequential(driveToFarSwitchButBackup);
    }
}
