package org.usfirst.frc.team342.RecycleRushRobot.commands.grip;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;

import edu.wpi.first.wpilibj.command.Command;

public class GripStop extends Command {
	GripSystem grip;

	/**
	 * Grip stop stops the grip system motor
	 */
	public GripStop() {
		grip = GripSystem.getInstance();
		requires(grip);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		grip.stop();

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
