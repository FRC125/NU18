package org.usfirst.frc.team125.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.*;

public class UnclampAndRetract extends CommandGroup {

    public UnclampAndRetract(){

        addSequential(new OpenClampCMD());
        //position is currently zero because it isn't tested yet.
        addSequential(new RunToPositionCmd(0));
    }
}
