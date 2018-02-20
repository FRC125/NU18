package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;

public class ChinUpCmdGrp extends CommandGroup {

    public ChinUpCmdGrp() {
        addSequential(new RunToPositionMotionMagicCmd(CubeLift.Positions.ChinUp), 4);
    }
}
