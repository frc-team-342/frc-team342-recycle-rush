package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveReverseReleativeDistance extends Command {
	DriveSystem drive;
	private int distance;
	private int targetDistance;

	public DriveReverseReleativeDistance(int target) {
		drive = DriveSystem.getInstance();
		requires(drive);
		targetDistance = drive.getDistance() - target;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		drive.forward(RobotMap.AUTONOMOUS_REVERSE);
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
