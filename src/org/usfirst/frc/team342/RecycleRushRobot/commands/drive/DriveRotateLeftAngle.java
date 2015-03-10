package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveRotateLeftAngle extends Command {
	DriveSystem drive;
	private double targetangle;

	public DriveRotateLeftAngle(int target) {
		drive = DriveSystem.getInstance();
		requires(drive);
		targetangle = drive.getAngle() - target;
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		drive.turn(-1 * RobotMap.AUTONOMOUS_DRIVE_TURN_LEFT_SPEED);
	}

	@Override
	protected boolean isFinished() {
		return (drive.getAngle() <= targetangle);
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
