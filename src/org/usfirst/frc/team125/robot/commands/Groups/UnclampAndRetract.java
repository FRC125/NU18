package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.CubeLift.OpenClampCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionCmd;

public class UnclampAndRetract extends CommandGroup {

    public UnclampAndRetract() {
        addSequential(new OpenClampCmd());
        //position is currently zero because it isn't tested yet.
        addSequential(new RunToPositionCmd(0));
    }
}
