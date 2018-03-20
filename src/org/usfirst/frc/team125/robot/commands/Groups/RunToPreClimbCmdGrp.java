package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeUpCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;

public class RunToPreClimbCmdGrp extends CommandGroup {

    public RunToPreClimbCmdGrp() {
        addSequential(new RunToPositionMotionMagicCmd(CubeLift.Positions.PreClimb), 3);
        addSequential(new WaitCommand(0.75));
        addSequential(new IntakeUpCmd());


    }
}
