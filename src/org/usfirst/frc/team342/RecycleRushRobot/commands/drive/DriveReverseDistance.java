package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveReverseDistance extends Command {
	DriveSystem drive;
	private double distance;
	private double targetdistance;

	public DriveReverseDistance(int target) {
		// TODO Auto-generated constructor stub
		targetdistance = target;
	}

	public DriveReverseDistance(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public DriveReverseDistance(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public DriveReverseDistance(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		distance = 0;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		drive.forward(-0.3);
		distance = drive.getDistance();
		// get distance here
	}

	@Override
	protected boolean isFinished() {
		// Stop the robot when it gets to the target distance
		return (distance <= targetdistance);
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		drive.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
