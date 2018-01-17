package org.usfirst.frc.team125.robot.commands.groups;

import org.usfirst.frc.team125.robot.commands.CloseClampCMD;
import org.usfirst.frc.team125.robot.commands.ElevatorDrive;
import org.usfirst.frc.team125.robot.commands.RunIntakeForwardCMD;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeAndClamp extends CommandGroup {

    public IntakeAndClamp() {
    	
      addSequential(new RunIntakeForwardCMD());
      addSequential(new CloseClampCMD());
      addSequential(new ElevatorDrive());
      
    }
}
