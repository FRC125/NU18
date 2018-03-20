package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.CloseGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeStopCmd;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeUpCmd;
import org.usfirst.frc.team125.robot.commands.Intake.PulseIntakeCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;

public class ClampAndLiftCmdGrp extends CommandGroup {
    public ClampAndLiftCmdGrp() {
        /*addParallel(new CloseGrabbersCmd());
        addSequential(new PulseIntakeCmd(), 0.5);
        */
        addSequential(new CloseGrabbersCmd());
        addSequential(new WaitCommand(0.34));
        addSequential(new RunToPositionMotionMagicCmd(CubeLift.Positions.Driving));
    }
}
