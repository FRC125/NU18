package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.UnpinCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;

public class ChinUpCmdGrp extends CommandGroup {

    public ChinUpCmdGrp() {
        addParallel(new UnpinCmd());
        addSequential(new WaitCommand(0.5));
        addSequential(new RunToPositionMotionMagicCmd(CubeLift.Positions.ChinUp), 2);
    }
}
