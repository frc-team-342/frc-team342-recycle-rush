package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveRotateRightAngle extends Command {
	DriveSystem drive;
	private double targetAngle;

	public DriveRotateRightAngle(int target) {
		drive = DriveSystem.getInstance();
		requires(drive);
		targetAngle = drive.getAngle() + target;
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		drive.turn(RobotMap.AUTONOMOUS_DRIVE_ROTATE_RIGHT_SPEED);
	}

	@Override
	protected boolean isFinished() {
		return (drive.getAngle() >= targetAngle);
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
