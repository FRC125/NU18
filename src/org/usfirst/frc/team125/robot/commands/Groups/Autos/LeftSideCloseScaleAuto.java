package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.LeftSideCloseScalePaths;

public class LeftSideCloseScaleAuto extends CommandGroup {
    Command driveToScale = new DrivePathCmd(LeftSideCloseScalePaths.toScale);
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevatorToScalePos = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreScale);
    Command scoreCube = new ScoreCmdGrp();

    public LeftSideCloseScaleAuto() {
        //addSequential(secureCube);
        addSequential(driveToScale);
        //addSequential(liftElevatorToScalePos, 3);
        //addSequential(scoreCube);
    }

}
