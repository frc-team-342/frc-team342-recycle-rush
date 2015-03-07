package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveInverter extends Command {
	DriveSystem drive;

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		drive = DriveSystem.getInstance();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		drive.inverseDrive();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
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