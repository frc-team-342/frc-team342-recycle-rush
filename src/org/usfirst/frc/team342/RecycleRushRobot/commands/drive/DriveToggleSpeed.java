package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToggleSpeed extends Command {
	DriveSystem drive;

	public DriveToggleSpeed() {
		drive = DriveSystem.getInstance();
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		drive.toggleSlow();
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

	}

}
