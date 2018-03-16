package org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SituationalAutos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeDownCmd;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.CenterPaths.CenterLeftPath;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.SituationalPaths.DriveStraightPaths;

public class DriveStraightAuto extends CommandGroup {
    Command intakeDown = new IntakeDownCmd();
    Command secureCube = new SecureCubeCmdGrp();
    Command drivePastAutoLine = new DrivePathCmd(DriveStraightPaths.pastAutoLine);


    public DriveStraightAuto() {
        /*
        addSequential(intakeDown);
        addSequential(new WaitCommand(0.25));
        addSequential(secureCube);
        */
        addSequential(drivePastAutoLine);
    }

}
