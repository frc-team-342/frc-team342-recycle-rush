package org.usfirst.frc.team342.RecycleRushRobot.commands.lift;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftUpTime extends Command {
	LiftSystem lift;
	private long startTime;
	private long duration;

	public LiftUpTime(long time) {
		duration = time;
		lift = LiftSystem.getInstance();
		requires(lift);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		startTime = System.currentTimeMillis();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		lift.up();
		duration = System.currentTimeMillis() - startTime;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (lift.topLimit() || duration <= System.currentTimeMillis());
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		lift.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
