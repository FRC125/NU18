package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.CloseGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.OpenGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.PunchCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;

public class ClamAndLiftCmdGrp extends CommandGroup {
    public ClamAndLiftCmdGrp() {
        addSequential(new CloseGrabbersCmd());
        addSequential(new WaitCommand(0.34));
        addSequential(new RunToPositionMotionMagicCmd(CubeLift.Positions.Driving));
    }
}
