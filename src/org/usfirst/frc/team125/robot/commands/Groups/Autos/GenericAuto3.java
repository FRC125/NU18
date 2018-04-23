package org.usfirst.frc.team125.robot.commands.Groups.Autos;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team125.robot.commands.CubeLift.RunToPositionMotionMagicCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.CounterCWAngleTurnCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathCmd;
import org.usfirst.frc.team125.robot.commands.Drivetrain.DrivePathReverseCmd;
import org.usfirst.frc.team125.robot.commands.Groups.IntakeCmdGrp;
import org.usfirst.frc.team125.robot.commands.Groups.ScoreCmdGrp;
import org.usfirst.frc.team125.robot.subsystems.CubeLift;
import org.usfirst.frc.team125.robot.util.Paths.CompPaths.CenterPaths.CenterLeftPath;
import org.usfirst.frc.team125.robot.util.Paths.GenericPaths;

public class GenericAuto3 extends CommandGroup {

    //Third Cube
    Command backOffSwitch = new DrivePathReverseCmd(CenterLeftPath.backOffSwitch, false);
    Command turnTowardsCube = new CounterCWAngleTurnCmd(CenterLeftPath.turnTowardsCubes);
    Command driveTowardsCubeAgain = new DrivePathCmd(CenterLeftPath.toCubeAgain, false);
    Command backOffCubeAgain = new DrivePathReverseCmd(CenterLeftPath.backOffCubeAgain, false);
    Command turnTowardsSwitch = new CounterCWAngleTurnCmd(CenterLeftPath.turnBack);
    Command driveToSwitchAgainAgain = new DrivePathCmd(CenterLeftPath.toSwitchAgainAgain, false);

    public GenericAuto3() {
        //Third Cube
        addSequential(new WaitCommand(0.4));
        addSequential(backOffSwitch);
        addSequential(turnTowardsCube);
        addSequential(driveTowardsCubeAgain);
        addSequential(backOffCubeAgain);
        addSequential(turnTowardsSwitch);
        addSequential(driveToSwitchAgainAgain);
    }

}
