package org.usfirst.frc.team342.RecycleRushRobot.commands.grip;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * this function is not yet implemented. If called it should open the gripper
 * all the way.
 */
public class GripClose3 extends Command {
	GripSystem grip;
	boolean isClosed;

	public GripClose3() {
		grip = GripSystem.getInstance();
		requires(grip);
	}

	@Override
	protected void initialize() {
		isClosed = false;
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return grip.moveTo(RobotMap.GRIP_POTENTIOMETER_CLOSED_VALUE_3);
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
