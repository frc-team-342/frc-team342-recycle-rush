package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary;

public class DriveReadDebug extends Command {

	private DriveSystem drive;
	private LiftSystem lift;
	private GripSystem grip;

	public DriveReadDebug() {
		drive = DriveSystem.getInstance();
		lift = LiftSystem.getInstance();
		grip = GripSystem.getInstance();
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		System.out.println("Drive System " + "\t" + "Ultrasonic: "
				+ drive.getDistance() + "\t" + "Gyro: " + drive.getAngle()
				+ "\n" + "GripSystem " + "\t" + "Ultrasonic: "
				+ grip.getUltrasonic() + "\n" + "Lift " + "\t" + "Encoder: "
				+ lift.getEncoderValue());

		FRCNetworkCommunicationsLibrary.HALSetErrorData("Drive System " + "\t" + "Ultrasonic: "
				+ drive.getDistance() + "\t" + "Gyro: " + drive.getAngle()
				+ "\n" + "GripSystem " + "\t" + "Ultrasonic: "
				+ grip.getUltrasonic() + "\n" + "Lift " + "\t" + "Encoder: "
				+ lift.getEncoderValue() + "\n");
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
