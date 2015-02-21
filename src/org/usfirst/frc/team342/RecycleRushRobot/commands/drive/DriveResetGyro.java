package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary;

public class DriveResetGyro extends Command {

	private DriveSystem drive;

	public DriveResetGyro() {
		drive = DriveSystem.getInstance();
	}

	@Override
	protected void initialize() {
		// Display message reflecting gyro-resetation
		FRCNetworkCommunicationsLibrary.HALSetErrorData("Reseting the gyro..."
				+ "\n");
	}

	@Override
	protected void execute() {
		// reset the gyro
		drive.resetGyro();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		FRCNetworkCommunicationsLibrary
				.HALSetErrorData("Gyro succesfully reset" + "\n");
	}

	@Override
	protected void interrupted() {
		FRCNetworkCommunicationsLibrary.HALSetErrorData("ERROR RESETING GYRO"
				+ "\n" + "THIS SHOULD NOT EVEN BE POSSIBLE!!!!!!!!!!" + "\n");
		end();
	}

}
