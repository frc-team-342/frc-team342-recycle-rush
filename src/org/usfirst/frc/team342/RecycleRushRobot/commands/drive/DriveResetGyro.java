package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveResetGyro extends Command {

	private DriveSystem drive;

	public DriveResetGyro() {
		drive = DriveSystem.getInstance();
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		// TODO make this print to dashboard
		drive.resetGyro();
		System.out.println("Reseting the gyro...");
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		// TODO Make this print to dashboard
		System.out.println("Gyro succesfully reset");
	}

	@Override
	protected void interrupted() {
		
	}

}
