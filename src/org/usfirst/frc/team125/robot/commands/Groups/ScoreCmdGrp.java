package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.CubeLift.OpenGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.PunchCmd;

public class ScoreCmdGrp extends CommandGroup {
    public ScoreCmdGrp() {
        addSequential(new OpenGrabbersCmd());
        addSequential(new PunchCmd());
    }
}
