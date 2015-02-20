package org.usfirst.frc.team342.RecycleRushRobot.commands.grip;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * this function is not yet implemented. If called it should open the gripper
 * all the way.
 */
public class GripClose extends Command {
	GripSystem grip;
	
	public GripClose() {
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
