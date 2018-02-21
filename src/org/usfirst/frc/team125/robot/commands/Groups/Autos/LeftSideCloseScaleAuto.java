package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Groups.AutoLiftCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeDownCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.LeftSideCloseScalePaths;

public class LeftSideCloseScaleAuto extends CommandGroup {
    Command intakeDown = new IntakeDownCmd();
    Command driveToScale = new DrivePathCmd(LeftSideCloseScalePaths.toScale);
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevatorA = new AutoLiftCmdGrp(0.5, CubeLift.Positions.ScoreScale);
    Command scoreCube = new ScoreCmdGrp();

    public LeftSideCloseScaleAuto() {
        addSequential(intakeDown);
        addSequential(new WaitCommand(0.25));
        addSequential(secureCube);
        addParallel(liftElevatorA);
        addSequential(driveToScale);
        addSequential(scoreCube);
    }

}
