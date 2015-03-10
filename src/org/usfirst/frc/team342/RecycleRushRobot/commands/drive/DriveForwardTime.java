package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardTime extends Command {
	DriveSystem drive;
	long stopTime;

	public DriveForwardTime(long timeToDrive) {
		drive = DriveSystem.getInstance();
		requires(drive);
		stopTime = System.currentTimeMillis() + timeToDrive;
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		drive.forward(0.3);
	}

	@Override
	protected boolean isFinished() {
		return System.currentTimeMillis() >= stopTime;
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
