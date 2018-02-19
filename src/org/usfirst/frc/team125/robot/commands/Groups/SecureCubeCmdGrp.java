package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.CubeLift.CloseGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeCmd;

public class SecureCubeCmdGrp extends CommandGroup {
    public SecureCubeCmdGrp() {
        addSequential(new IntakeCmd(), 0.25);
        addSequential(new CloseGrabbersCmd());
    }
}
