package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.Intake.SmartIntake.RumbleControllersCmd;
import org.usfirst.frc.team125.robot.commands.Intake.SmartIntake.SmartIntakeCmd;

public class IntakeCmdGrp extends CommandGroup {

    public IntakeCmdGrp() {
        addSequential(new SmartIntakeCmd());
        addParallel(new RumbleControllersCmd(), 1);
        addSequential(new ClampAndLiftCmdGrp());
    }

}
