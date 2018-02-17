package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.OpenGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.PunchCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.UnpunchCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.RightSideCloseSwitchPaths;

public class RightSideCloseSwitchAuto extends CommandGroup {
    Command driveToSwitch = new DrivePathCmd(RightSideCloseSwitchPaths.toSwitch);
    Command liftElevatorToSwitchPos = new RunToPositionMotionMagicCmd(CubeLift.Positions.ScoreSwitch);
    Command openClamps = new OpenGrabbersCmd();
    Command punch = new PunchCmd();
    Command unPunch = new UnpunchCmd();

    public RightSideCloseSwitchAuto(){
        addSequential(driveToSwitch);
        addSequential(liftElevatorToSwitchPos);
        addParallel(openClamps);
        addSequential(punch);
        addSequential(new WaitCommand(0.34));
        addSequential(unPunch);

    }

}
