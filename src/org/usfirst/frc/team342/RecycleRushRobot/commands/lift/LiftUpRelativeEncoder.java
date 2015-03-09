package org.usfirst.frc.team342.RecycleRushRobot.commands.lift;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

public class LiftUpRelativeEncoder extends Command {
	LiftSystem lift;
	int stopValue;

	/**
	 * Lift the lift the given encoder units
	 * @param encoderValue Value to lift the encoder up
	 */
	public LiftUpRelativeEncoder(int encoderValue) {
		lift = LiftSystem.getInstance();
		stopValue = lift.getEncoderValue() + encoderValue;
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		lift.up();
	}

	@Override
	protected boolean isFinished() {
		return lift.getEncoderValue() >= stopValue;
	}

	@Override
	protected void end() {
		lift.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
