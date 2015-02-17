package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTurnLeftAngle extends Command {
	DriveSystem drive;
	private double startAngle;
	private double angle;
	private double targetangle;
	private double TURN_LEFT_MAGNITUDE = 0.5;

	public DriveTurnLeftAngle(int target) {
		// TODO Auto-generated constructor stub
		targetangle = target;
	}

	public DriveTurnLeftAngle(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public DriveTurnLeftAngle(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public DriveTurnLeftAngle(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		startAngle = drive.getAngle();
		angle = 0;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		drive.turn(-1 * TURN_LEFT_MAGNITUDE);
		angle = drive.getAngle() - startAngle;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (angle > targetangle);
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		drive.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		this.end();
	}

}
