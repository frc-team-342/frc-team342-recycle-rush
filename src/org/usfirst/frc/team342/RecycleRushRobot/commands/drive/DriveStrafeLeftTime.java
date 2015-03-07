package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStrafeLeftTime extends Command {
	DriveSystem drive;
	long stopTime;
	
	public DriveStrafeLeftTime() {
		drive = DriveSystem.getInstance();
		requires(drive);
	}

	@Override
	protected void initialize() {
		stopTime = System.currentTimeMillis() + 800;
	}

	@Override
	protected void execute() {
		drive.strafeLeft(RobotMap.AUTONOMOUS_DRIVE_STRAFE_LEFT_SPEED);
	}

	@Override
	protected boolean isFinished() {
		return stopTime <= System.currentTimeMillis();
	}

	@Override
	protected void end() {
		drive.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
