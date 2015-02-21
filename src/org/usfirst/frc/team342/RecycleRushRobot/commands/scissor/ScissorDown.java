package org.usfirst.frc.team342.RecycleRushRobot.commands.scissor;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.ScissorSystem;

import edu.wpi.first.wpilibj.command.Command;

public class ScissorDown extends Command {
	ScissorSystem scissor;

	public ScissorDown() {
		scissor = ScissorSystem.getInstance();
		requires(scissor);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		scissor.down();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return scissor.isDown();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		scissor.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
