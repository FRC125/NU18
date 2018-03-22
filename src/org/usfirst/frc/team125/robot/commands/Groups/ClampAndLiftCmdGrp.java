package org.usfirst.frc.team125.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.CloseGrabbersCmd;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Intake.SmartIntake.PulseIntakeCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;

public class ClampAndLiftCmdGrp extends CommandGroup {
    public ClampAndLiftCmdGrp() {
        /*addParallel(new CloseGrabbersCmd());
        addSequential(new PulseIntakeCmd(), 0.5);
        */
        setInterruptible(false);
        addParallel(new PulseIntakeCmd(), 1.0);
        addSequential(new CloseGrabbersCmd());
        addSequential(new WaitCommand(0.34));
        addSequential(new RunToPositionMotionMagicCmd(CubeLift.Positions.Driving));
    }
}
