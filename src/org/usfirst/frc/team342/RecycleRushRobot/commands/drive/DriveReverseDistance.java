package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveReverseDistance extends Command {
	DriveSystem drive;
	private int distance;
	private int targetdistance;
	
	
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
		drive.reverse(RobotMap.AUTONOMOUS_SPEED);
		//get distance here
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return(distance > targetdistance);
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
