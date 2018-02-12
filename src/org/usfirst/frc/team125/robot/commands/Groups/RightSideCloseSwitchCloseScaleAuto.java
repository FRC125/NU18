package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.util.AutoPathsConstants;
import org.usfirst.frc.team125.robot.util.RightSideCloseSwitchCloseScalePaths;

public class RightSideCloseSwitchCloseScaleAuto extends CommandGroup {

    public Command driveToFlopPos = new DrivePathCmd(RightSideCloseSwitchCloseScalePaths.toFarSwitchLine);
    public Command grabCube = new DrivePathCmd(RightSideCloseSwitchCloseScalePaths.right_closeSideSwitchCubeGrab);
    public Command backUp = new DrivePathReverseCmd(RightSideCloseSwitchCloseScalePaths.right_backwards_postCloseGrabCube);
    public Command toScale = new DrivePathCmd(RightSideCloseSwitchCloseScalePaths.right_postCloseGrabCubeBackupToScaleClose);
    public RightSideCloseSwitchCloseScaleAuto() {
        addSequential(driveToFlopPos);
        addSequential(new WaitCommand(1));
        addSequential(grabCube);
        addSequential(backUp);
        addSequential(toScale);
    }
}
