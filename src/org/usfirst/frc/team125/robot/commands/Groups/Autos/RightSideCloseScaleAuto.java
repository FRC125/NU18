package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.CloseGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicAutonomousCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeDownCmd;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeUpCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.RightSideCloseScalePaths;

public class RightSideCloseScaleAuto extends CommandGroup {
    Command driveToScale = new DrivePathCmd(RightSideCloseScalePaths.toScale);
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevatorToScalePos = new RunToPositionMotionMagicAutonomousCmd(CubeLift.Positions.ScoreScale);
    Command scoreCube = new ScoreCmdGrp();


    public RightSideCloseScaleAuto() {
        addSequential(secureCube);
        addParallel(liftElevatorToScalePos, 5);
        addSequential(driveToScale);
        addSequential(scoreCube);
    }

}
