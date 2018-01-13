package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RetractCarrier extends Command {
		public RetractCarrier() {
			requires(Robot.carrier);
		}
		
		protected void initialize() {
			Robot.carrier.retractCarrier();
		}
		
		protected void excecute() {

		}
		
		
		@Override
		protected boolean isFinished() {
			// TODO Auto-generated method stub
			return true;
		}
		
		protected void end() {
			
		}
		
		protected void inturrupted() {
			
		}

	}
