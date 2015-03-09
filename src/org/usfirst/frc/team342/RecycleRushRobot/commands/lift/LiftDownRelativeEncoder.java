package org.usfirst.frc.team342.RecycleRushRobot.commands.lift;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

public class LiftDownRelativeEncoder extends Command {
	LiftSystem lift;
	int stopValue;

	public LiftDownRelativeEncoder(int encoderValue) {
		lift = LiftSystem.getInstance();
		stopValue = lift.getEncoderValue() - encoderValue;
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		lift.down();
	}

	@Override
	protected boolean isFinished() {
		return lift.getEncoderValue() <= stopValue;
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
