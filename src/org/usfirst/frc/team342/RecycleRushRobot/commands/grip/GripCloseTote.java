package org.usfirst.frc.team342.RecycleRushRobot.commands.grip;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * GripCloseBin() calls the grip system command to close the gripper on a tote.
 * If interrupted it should exit cleanly.
 */
public class GripCloseTote extends Command {
	GripSystem grip;

	public GripCloseTote() {
		grip = GripSystem.getInstance();
		requires(grip);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return grip.close();
	}

	@Override
	protected void end() {
		grip.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
