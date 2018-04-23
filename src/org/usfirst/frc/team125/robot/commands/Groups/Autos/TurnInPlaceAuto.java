package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.Drivetrain.CounterCWAngleTurnCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.util.Paths.GenericPaths;

public class TurnInPlaceAuto extends CommandGroup {

    Command turnInPlace = new CounterCWAngleTurnCmd(180);

    public TurnInPlaceAuto() {
        addSequential(turnInPlace);
    }

}
