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
import org.usfirst.frc.team125.robot.util.Paths.RightSideFarScalePaths;

public class RightSideFarScaleAuto extends CommandGroup {

    Command driveToFarSwitch = new DrivePathCmd(RightSideFarScalePaths.toFarSwitchLine);
    Command driveElbowTurn = new DrivePathCmd(RightSideFarScalePaths.elbowTurn);
    Command driveStraightAway = new DrivePathCmd(RightSideFarScalePaths.driveStraight);
    Command driveElbowTurnToScale = new DrivePathCmd(RightSideFarScalePaths.elbowTurnToScale);
    Command liftElevatorToScalePos = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreScale);
    Command openClamps = new OpenGrabbersCmd();
    Command punch = new PunchCmd();
    Command unPunch = new UnpunchCmd();

    public RightSideFarScaleAuto() {
        addSequential(driveToFarSwitch);
        addSequential(driveElbowTurn);
        addSequential(driveStraightAway);
        addParallel(liftElevatorToScalePos);
        addSequential(driveElbowTurnToScale);
        addParallel(openClamps);
        addSequential(punch);
        addSequential(new WaitCommand(0.34));
        addSequential(unPunch);
    }

}
