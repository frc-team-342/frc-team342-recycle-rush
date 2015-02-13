package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTurnRightAngle extends Command {
	DriveSystem drive;
	private double angle;
	private double targetangle;
	private double TURN_RIGHT_POWER = 0.5;

	public DriveTurnRightAngle(int target) {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		angle = drive.getAngle();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		drive.turn(TURN_RIGHT_POWER);
		angle = drive.getAngle();
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
		end();
	}

}
