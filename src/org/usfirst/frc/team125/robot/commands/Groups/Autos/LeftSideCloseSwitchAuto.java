package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.OpenGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.PunchCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.UnpunchCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Groups.ClampAndIntakeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.LeftSideCloseSwitchPaths;

public class LeftSideCloseSwitchAuto extends CommandGroup {
    Command driveToSwitch = new DrivePathCmd(LeftSideCloseSwitchPaths.toSwitch);
    Command secureCube = new ClampAndIntakeCmdGrp();
    Command liftElevatorToSwitchPos = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreSwitch);
    Command scoreCube = new ScoreCmdGrp();

    public LeftSideCloseSwitchAuto(){
        addSequential(secureCube);
        addSequential(driveToSwitch);
        addSequential(liftElevatorToSwitchPos);
        addSequential(scoreCube);
    }


}
