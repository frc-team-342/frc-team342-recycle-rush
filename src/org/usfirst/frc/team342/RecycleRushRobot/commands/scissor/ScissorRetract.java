package org.usfirst.frc.team342.RecycleRushRobot.commands.scissor;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.ScissorSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ScissorRetract extends Command {
	ScissorSystem scissor;

	public ScissorRetract() {
		scissor = ScissorSystem.getInstance();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(scissor);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		scissor.scissorRetract();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		scissor.scissorStop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
