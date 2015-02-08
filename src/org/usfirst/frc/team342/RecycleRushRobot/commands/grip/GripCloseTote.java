package org.usfirst.frc.team342.RecycleRushRobot.commands.grip;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;

/**
 *         GripCloseBin() calls the grip system command to close the gripper on
 *         a tote. If interrupted it should exit cleanly.
 */
public class GripCloseTote extends Command {
	GripSystem grip;
	private final double GRIP_TOTE = 1;

	public GripCloseTote() {
		requires(grip);
		grip = GripSystem.getInstance();
	}

	public GripCloseTote(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public GripCloseTote(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public GripCloseTote(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return grip.close(GRIP_TOTE);
	}

	@Override
	protected void end() {
		grip.stop();
	}

	@Override
	protected void interrupted() {
		this.end();
	}

}
