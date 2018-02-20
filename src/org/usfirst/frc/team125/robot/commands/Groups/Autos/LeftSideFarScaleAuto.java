package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Groups.AutoLiftCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.LeftSideFarScalePaths;

public class LeftSideFarScaleAuto extends CommandGroup {

    Command driveToBeforeScaleTurn = new DrivePathCmd(LeftSideFarScalePaths.toBeforeScaleTurn);
    Command driveToScale = new DrivePathCmd(LeftSideFarScalePaths.turnToScale);
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevatorA = new AutoLiftCmdGrp(0.5, CubeLift.Positions.ScoreScale);
    Command scoreCube = new ScoreCmdGrp();


    public LeftSideFarScaleAuto() {
        addSequential(secureCube);
        addParallel(liftElevatorA);
        addSequential(driveToBeforeScaleTurn);
        addSequential(driveToScale);
        addSequential(scoreCube);
    }

}
