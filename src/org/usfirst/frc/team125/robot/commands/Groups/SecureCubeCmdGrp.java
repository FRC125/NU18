package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.CubeLift.CloseGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.Intake.SmartIntake.PulseIntakeCmd;

public class SecureCubeCmdGrp extends CommandGroup {
    public SecureCubeCmdGrp() {
        addSequential(new PulseIntakeCmd(), 0.25);
        addSequential(new CloseGrabbersCmd());
    }
}
