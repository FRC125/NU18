package commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1234567.robot.Robot;


public class RunIntake extends Command{
	public RunIntake() {
		requires(Robot.intakeobject); //require Intake object intakeobject (created)
	}
		
	protected void initialize() {
		
    }

    protected void execute() {
    	Robot.intakeobject.runIntake(); //tell Intake object intakeobject to execute runIntake() from Intake subsystems.
    }

    protected boolean isFinished() {
		return false;
    }

    protected void end() {
    	Robot.intakeobject.stopIntake();
 
    }

    protected void interrupted() {
}
}
