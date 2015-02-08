package org.usfirst.frc.team342.RecycleRushRobot.commands.grip;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;


/**
 * @author team347
 * 
 *         GripCloseBin() calls the grip system command to close the gripper on a
 *         bin. If interrupted it should exit cleanly.
 */
public class GripCloseBin extends Command {
	GripSystem grip;
	private final double GRIP_BIN = 2;
	
	public GripCloseBin() {
		requires(grip);
		grip = GripSystem.getInstance();
	}

	public GripCloseBin(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public GripCloseBin(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public GripCloseBin(String name, double timeout) {
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
		return grip.close(GRIP_BIN);
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
