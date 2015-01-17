package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.OI;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command {
	
	private Joystick joystick;
	
	private DriveSystem drive = DriveSystem.getInstance();

	public DriveWithJoystick() {
		this.requires(this.drive);
		// TODO Auto-generated constructor stub
	}

	public DriveWithJoystick(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public DriveWithJoystick(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public DriveWithJoystick(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		OI oi = OI.getInstance();
		this.joystick = oi.getJoystick();
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		drive.driveWithJoystick(joystick);
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
