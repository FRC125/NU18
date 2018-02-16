package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.OpenGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.PunchCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.UnpunchCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.LeftSideFarScalePaths;

public class LeftSideFarScaleAuto extends CommandGroup {

    Command driveToFarScale= new DrivePathCmd(LeftSideFarScalePaths.toScale);
    Command liftElevatorToScalePos = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreScale);
    Command openClamps = new OpenGrabbersCmd();
    Command punch = new PunchCmd();
    Command unPunch = new UnpunchCmd();

    public LeftSideFarScaleAuto() {
        addSequential(driveToFarScale);
        addSequential(liftElevatorToScalePos);
        addParallel(openClamps);
        addSequential(punch);
        addSequential(new WaitCommand(0.34));
        addSequential(unPunch);
    }

}
