package org.usfirst.frc.team125.robot.commands.Groups.Autos.CompAutos.SwitchOnlyAutos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Groups.AutoLiftCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Intake.IntakeDownCmd;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.SwitchOnlyPaths.LeftSideFarSwitchPaths;

public class LeftSideFarSwitchAuto extends CommandGroup {
    Command intakeDown = new IntakeDownCmd();
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevator = new AutoLiftCmdGrp(0.75, CubeLift.Positions.ScoreSwitch);
    Command driveToBeforeSwitch = new DrivePathCmd(LeftSideFarSwitchPaths.toBeforeSwitchTurn);
    Command driveToSwitch = new DrivePathCmd(LeftSideFarSwitchPaths.turnToSwitch);
    Command scoreCube = new ScoreCmdGrp();


    public LeftSideFarSwitchAuto() {
        addSequential(intakeDown);
        addSequential(new WaitCommand(0.25));
        addSequential(secureCube);
        addParallel(liftElevator);
        addSequential(driveToBeforeSwitch);
        addSequential(driveToSwitch);
        addSequential(scoreCube);
    }

}
