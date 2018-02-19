package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.UnpinCmd;
import org.usfirst.frc.team125.robot.commands.DoubleLift.ReleaseCarrierCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;

public class PullUpAndDropCarrierCmdGrp extends CommandGroup {

    public PullUpAndDropCarrierCmdGrp() {
        addSequential(new UnpinCmd());
        addSequential(new RunToPositionMotionMagicCmd(CubeLift.Positions.ChinUp));
        addSequential(new ReleaseCarrierCmd());
    }

}
