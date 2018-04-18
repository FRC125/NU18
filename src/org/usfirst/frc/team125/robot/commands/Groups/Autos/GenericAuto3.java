package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.Drivetrain.CounterCWAngleTurnCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.util.Paths.GenericPaths;

public class GenericAuto3 extends CommandGroup {

    Command turnInPlace = new CounterCWAngleTurnCmd(180);
    Command turnInPlace2 = new CounterCWAngleTurnCmd(-180);

    public GenericAuto3() {
        addSequential(turnInPlace);
        //addSequential(new WaitCommand(2));
        //addSequential(turnInPlace2);
    }

}
