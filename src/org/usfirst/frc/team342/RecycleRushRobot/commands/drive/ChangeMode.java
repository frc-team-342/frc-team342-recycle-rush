package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.OI;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ChangeMode extends Command {

	private DriveSystem drive = DriveSystem.getInstance();

	public ChangeMode() {

		// TODO Auto-generated constructor stub
	}

	public ChangeMode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public ChangeMode(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public ChangeMode(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		drive.changeMode();
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
