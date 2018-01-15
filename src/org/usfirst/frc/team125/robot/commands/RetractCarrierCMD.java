package org.usfirst.frc.team125.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team125.robot.Robot;

public class RetractCarrierCMD extends Command {

	public RetractCarrierCMD() {
			requires(Robot.doubleLift);
		}
		
	protected void initialize() {
		Robot.doubleLift.lift();
	}
		
	protected void excecute() {
	}
		
    @Override
    protected boolean isFinished() {
			return true;
		}

    protected void end() {
    }
		
    protected void inturrupted() {
    }
}
