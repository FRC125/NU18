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
      addSequential(new ElevatorDriveCmd());
      
    }
}
