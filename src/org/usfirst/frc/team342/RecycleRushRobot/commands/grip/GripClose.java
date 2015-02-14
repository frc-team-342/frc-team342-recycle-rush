package org.usfirst.frc.team342.RecycleRushRobot.commands.grip;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;

/**
 * this function is not yet implemented. If called it should open the gripper
 * all the way.
 */
public class GripClose extends Command {
	GripSystem grip;
	private final double GRIP_CLOSED = .1;

	public GripClose() {
		grip = GripSystem.getInstance();
		requires(grip);
	}

	public GripClose(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public GripClose(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public GripClose(String name, double timeout) {
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
		return grip.close(GRIP_CLOSED);
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		grip.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		this.end();
	}

}
