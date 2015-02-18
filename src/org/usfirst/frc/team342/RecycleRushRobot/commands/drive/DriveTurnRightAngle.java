package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTurnRightAngle extends Command {
	DriveSystem drive;
	private double angle;
	private double targetangle;

	public DriveTurnRightAngle(int target) {
		drive = DriveSystem.getInstance();
		targetangle = target + drive.getAngle();
	}

	public DriveTurnRightAngle(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public DriveTurnRightAngle(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public DriveTurnRightAngle(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
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
