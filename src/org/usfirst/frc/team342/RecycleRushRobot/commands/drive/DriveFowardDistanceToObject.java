package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveFowardDistanceToObject extends Command {
	GripSystem grip;
	DriveSystem drive;
	double driveSpeed;
	int targetDistance;

	int counter;

	/**
	 * Drives forward until the front sensor detects an object, then it drives a
	 * little further because the sensor is not accurate.
	 * 
	 * @param speed
	 *            the speed as a double at which to drive forward
	 */
	public DriveFowardDistanceToObject(double speed) {
		// Instantiate drive system and grip system
		drive = DriveSystem.getInstance();
		grip = GripSystem.getInstance();

		// take control of the grip and drive
		requires(drive);
		requires(grip);

		// set the speed and distance to go
		driveSpeed = speed;
	}

	@Override
	protected void initialize() {
		// set the counter to 0
		counter = 0;
	}

	@Override
	protected void execute() {
		// start driving forward
		drive.forward(driveSpeed);
		// when the ultrasonic detects small value start adding to the counter
		// to stop driving forward
		if (grip.getPotentiometer() < 60)
			counter++;
	}

	@Override
	protected boolean isFinished() {
		// finish if the ultrasonic has been near an object for 800 loops
		return counter > 800;
	}

	@Override
	protected void end() {
		// stop the drive
		drive.stop();
	}

	@Override
	protected void interrupted() {
		// this is never going to be interuted anyway
		end();
	}

}
