package org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.TwoScaleAutos.Special;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.commands.Groups.AutoLiftCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.IntakeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeDownCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale.LeftSideFarJustDrivePaths;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale.LeftSideFarTwoScalePaths;

public class LeftSideFarJustDriveSlowFastAuto extends CommandGroup {
    Command driveToScale = new DrivePathCmd(LeftSideFarJustDrivePaths.toScale, true);

    public LeftSideFarJustDriveSlowFastAuto() {
        /*addSequential(intakeDown);
        addSequential(new WaitCommand(0.25));
        addSequential(secureCube);
        */
        addSequential(driveToScale);
    }

}
