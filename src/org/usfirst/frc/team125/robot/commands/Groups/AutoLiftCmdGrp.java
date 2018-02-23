package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;

public class AutoLiftCmdGrp extends CommandGroup {

    public AutoLiftCmdGrp(double timeBuffer, CubeLift.Positions pos) {
        addSequential(new RunToPositionMotionMagicCmd(CubeLift.Positions.Driving), 1.5);
        addSequential(new WaitCommand(timeBuffer));
        addSequential(new RunToPositionMotionMagicCmd(pos), 3);
    }
}
