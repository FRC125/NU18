package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.CubeLift.CloseClampCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionCmd;
import org.usfirst.frc.team125.robot.commands.Intake.RunIntakeForwardCmd;

public class IntakeAndClamp extends CommandGroup {

    public IntakeAndClamp() {

        addSequential(new RunIntakeForwardCmd());
        addSequential(new CloseClampCmd());
        //position is currently zero because it isn't tested yet.
        addSequential(new RunToPositionCmd(0));

    }
}
