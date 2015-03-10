package org.usfirst.frc.team342.RecycleRushRobot.commands.lift;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

public class ResetEncoder extends Command {
	LiftSystem lift;

	/**
	 * reset the encoder to 0, no other comments necessary
	 */
	public ResetEncoder() {
		lift = LiftSystem.getInstance();
		requires(lift);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		lift.resetEncoder();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		// Do nothing
	}

	@Override
	protected void interrupted() {
		end();
	}

}
