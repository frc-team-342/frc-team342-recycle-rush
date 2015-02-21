package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveReverseRelativeDistance extends Command {
	DriveSystem drive;
	private int distance;
	private int targetDistance;

	public DriveReverseRelativeDistance(int target) {
		drive = DriveSystem.getInstance();
		requires(drive);
		targetDistance = drive.getDistance() - target;
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		drive.reverse(RobotMap.AUTONOMOUS_DRIVE_REVERSE_SPEED);
		distance = drive.getDistance();
	}

	@Override
	protected boolean isFinished() {
		// Stop the robot when it gets to the target distance
		return (distance <= targetDistance);
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
