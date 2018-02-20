package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Groups.AutoLiftCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.SecureCubeCmdGrp;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.CenterLeftPath;

public class CenterLeftAuto extends CommandGroup {

    Command driveToScale = new DrivePathCmd(CenterLeftPath.toSwitch);
    Command secureCube = new SecureCubeCmdGrp();
    Command liftElevator = new AutoLiftCmdGrp(0.1, CubeLift.Positions.ScoreSwitch);
    Command scoreCube = new ScoreCmdGrp();


    public CenterLeftAuto() {
        addSequential(secureCube);
        addParallel(liftElevator);
        addSequential(driveToScale);
        addSequential(scoreCube);
    }

}
