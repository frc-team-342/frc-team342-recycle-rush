package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

public class DriveFowardTime extends Command {
	DriveSystem drive;
	private long startTime;
	private long duration;

	public DriveFowardTime(long time) {
		// TODO Auto-generated constructor stub
		duration = time;
	}

	public DriveFowardTime(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public DriveFowardTime(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public DriveFowardTime(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		drive = DriveSystem.getInstance();
		startTime = System.currentTimeMillis();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		drive.forward(RobotMap.AUTONOMOUS_SPEED);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if (startTime + duration >= System.currentTimeMillis()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		drive.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
