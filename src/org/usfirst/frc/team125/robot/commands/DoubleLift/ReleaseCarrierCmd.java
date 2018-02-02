package org.usfirst.frc.team125.robot.commands.DoubleLift;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

<<<<<<< HEAD
public class ReleaseCarrierCmd extends Command {

    public ReleaseCarrierCmd() {
        requires(Robot.doubleLift);
    }

    protected void initialize() {
        Robot.doubleLift.releaseCarrier();
    }

    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
=======
public class ReleaseCarrierCmd extends Command{

	public ReleaseCarrierCmd() {
		requires(Robot.doubleLift);
	}
	
	protected void initialize() {
		Robot.doubleLift.releaseCarrier();
	}
	
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
	}

	protected void interrupted() {
	}
>>>>>>> week3-testing
}
