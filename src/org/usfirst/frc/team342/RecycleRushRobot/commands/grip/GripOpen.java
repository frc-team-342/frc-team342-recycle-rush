package org.usfirst.frc.team342.RecycleRushRobot.commands.grip;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;

/**
 *         this function is not yet implemented. If called it should open the
 *         gripper all the way
 */
public class GripOpen extends Command {
	GripSystem grip;

	public GripOpen() {
		requires(grip);
		grip = GripSystem.getInstance();
	}

	public GripOpen(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public GripOpen(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public GripOpen(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
	}

	@Override
	protected boolean isFinished() {
		// called in the isFinished loop because it makes it easier to call in a
		// loop, not sure if this will work
		return grip.gripOpen(RobotMap.GRIP_FULL_OPEN);
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
