package org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SwitchOnlyAutos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Groups.AutoLiftCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeDownCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.SwitchOnlyPaths.RightSideCloseSwitchPaths;

public class RightSideCloseSwitchAuto extends CommandGroup {
    Command intakeDown = new IntakeDownCmd();
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevator = new AutoLiftCmdGrp(0.5, CubeLift.Positions.ScoreSwitch);
    Command driveToBeforeSwitch = new DrivePathCmd(RightSideCloseSwitchPaths.toBeforeSwitchTurn, true);
    Command driveToSwitch = new DrivePathCmd(RightSideCloseSwitchPaths.turnToSwitch, true);
    Command scoreCube = new ScoreCmdGrp();


    public RightSideCloseSwitchAuto() {
        /*
        addSequential(intakeDown);
        addSequential(new WaitCommand(0.25));
        addSequential(secureCube);
        */
        addSequential(driveToBeforeSwitch);
        addParallel(liftElevator);
        addSequential(driveToSwitch);
        addSequential(scoreCube);
    }

}