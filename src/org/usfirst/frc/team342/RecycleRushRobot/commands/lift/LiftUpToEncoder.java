package org.usfirst.frc.team342.RecycleRushRobot.commands.lift;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

public class LiftUpToEncoder extends Command {
	LiftSystem lift;
	int height;
	int targetHeight;

	public LiftUpToEncoder(int target) {
		lift = LiftSystem.getInstance();
		requires(this.lift);
		targetHeight = target;
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
		return targetHeight <= lift.getEncoderValue();
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
