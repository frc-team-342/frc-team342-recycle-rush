package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTurnRightAngle extends Command {
	DriveSystem drive;
	private double angle;
	private double targetangle;

	public DriveTurnRightAngle(int target) {
		drive = DriveSystem.getInstance();
		requires(drive);
		targetangle = target + drive.getAngle();
	}

	@Override
	protected void initialize() {
		angle = drive.getAngle();
	}

	@Override
	protected void execute() {
		drive.turn(RobotMap.AUTONOMOUS_TURN_RIGHT);
		angle = drive.getAngle();
	}

	@Override
	protected boolean isFinished() {
		return (angle >= targetangle);
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
