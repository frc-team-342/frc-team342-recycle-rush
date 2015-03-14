package org.usfirst.frc.team342.RecycleRushRobot.commands.lift;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

public class LiftDownToBottom extends Command {
	LiftSystem lift;

	public LiftDownToBottom() {
		lift = LiftSystem.getInstance();
		requires(lift);
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
		return lift.bottomLimit();
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
