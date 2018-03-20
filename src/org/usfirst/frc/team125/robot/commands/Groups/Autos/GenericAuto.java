package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.ScaleToSwitchPaths.LeftSideCloseScaleFarSwitchPaths;

public class GenericAuto extends CommandGroup {
    Command genericCmd = new DrivePathReverseCmd(LeftSideCloseScaleFarSwitchPaths.reverse_kTurnToSwitch1A);
    Command genericCmd2 = new DrivePathCmd(LeftSideCloseScaleFarSwitchPaths.kTurnToSwitch1B);
    Command genericCmd3 = new IntakeCmd();
    Command genericCmd4 = new RunToPositionMotionMagicCmd(CubeLift.Positions.Intake);
    Command score = new ScoreCmdGrp();

    public GenericAuto() {
        //addSequential(genericCmd);
        addSequential(genericCmd4);
        addSequential(genericCmd3);
        addSequential(new WaitCommand(3));
        addSequential(score);
    }

}
