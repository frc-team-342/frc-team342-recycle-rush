package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTurnLeftAngle extends Command {
	DriveSystem drive;
	private double startAngle;
	private double angle;
	private double targetangle;

	public DriveTurnLeftAngle(int target) {
		targetangle = target;
	}

	@Override
	protected void initialize() {
		drive = DriveSystem.getInstance();
		startAngle = drive.getAngle();
		angle = drive.getAngle();
	}

	@Override
	protected void execute() {
		drive.turn(RobotMap.AUTONOMOUS_TURN_LEFT);
		angle = drive.getAngle() - startAngle;
	}

	@Override
	protected boolean isFinished() {
		return (angle <= targetangle);
	}

	@Override
	protected void end() {
		drive.stop();
	}

	@Override
	protected void interrupted() {
		this.end();
	}

}
