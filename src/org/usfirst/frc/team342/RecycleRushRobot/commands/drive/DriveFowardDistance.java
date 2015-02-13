package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveFowardDistance extends Command {
	DriveSystem drive;
	private double distance;
	private double targetDistance;
	private int rangeCounter ;

	public DriveFowardDistance(int target) {
		// TODO Auto-generated constructor stub
		drive = DriveSystem.getInstance();
		targetDistance = target;
	}

	public DriveFowardDistance(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public DriveFowardDistance(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public DriveFowardDistance(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		rangeCounter = 0;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		drive.forward(RobotMap.AUTONOMOUS_SPEED);
		distance = drive.getDistance();
		if(distance > targetDistance)
			rangeCounter ++;
			
		// get distance here
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return rangeCounter > 9;
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
