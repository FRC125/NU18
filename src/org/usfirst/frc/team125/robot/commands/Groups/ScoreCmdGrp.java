package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.OpenGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.PunchCmd;

public class ScoreCmdGrp extends CommandGroup {
    public ScoreCmdGrp() {
        addSequential(new OpenGrabbersCmd());
        addSequential(new WaitCommand(0.1));
        addSequential(new PunchCmd());
    }
}
