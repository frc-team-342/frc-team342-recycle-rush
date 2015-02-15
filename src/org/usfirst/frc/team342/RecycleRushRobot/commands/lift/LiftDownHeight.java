package org.usfirst.frc.team342.RecycleRushRobot.commands.lift;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftDownHeight extends Command {
	LiftSystem lift;
	private int stopValue;

	/**
	 * 
	 * @param stopValue
	 *            value from the encoder to stop at
	 */
	public LiftDownHeight(int stopValue) {
		this.stopValue = stopValue;
		this.lift = LiftSystem.getInstance();
		requires(lift);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		lift.liftDown();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return lift.bottomLimit() || lift.getEncoderValue() <= stopValue;
	}

	// Called once after isFinished returns true
	protected void end() {
		lift.liftStop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
	}
}
