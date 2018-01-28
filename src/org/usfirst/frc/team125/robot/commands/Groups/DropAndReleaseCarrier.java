package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.DoubleLift.DropCarrierCmd;
import org.usfirst.frc.team125.robot.commands.DoubleLift.ReleaseCarrierCmd;

import javax.activation.CommandObject;

public class DropAndReleaseCarrier extends CommandGroup {

    public DropAndReleaseCarrier(){
        addSequential(new DropCarrierCmd());
        addSequential(new ReleaseCarrierCmd());
    }
}
