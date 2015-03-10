package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveInverter extends Command {
	DriveSystem drive;

	@Override
	protected void initialize() {
		drive = DriveSystem.getInstance();
	}

	@Override
	protected void execute() {
		drive.inverseDrive();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {
		end();
	}

}
