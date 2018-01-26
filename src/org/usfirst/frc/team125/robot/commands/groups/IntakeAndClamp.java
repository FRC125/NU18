package org.usfirst.frc.team125.robot.commands.groups;

import org.usfirst.frc.team125.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeAndClamp extends CommandGroup {

    public IntakeAndClamp() {
    	
      addSequential(new RunIntakeForwardCMD());
      addSequential(new CloseClampCMD());
      //position is currently zero because it isn't tested yet.
      addSequential(new RunToPositionCmd(0));
      
    }
}
