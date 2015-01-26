package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTurnLeftTime extends Command {
	DriveSystem drive;
	long startTime;
	long duration;

	public DriveTurnLeftTime(long time) {
		duration = time;
		// TODO Auto-generated constructor stub
	}

	public DriveTurnLeftTime(String name, double timeout) {
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
		drive.turn(-0.5);
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
