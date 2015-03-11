package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardUntilCollision extends Command {
	DriveSystem drive;
	GripSystem grip;

	/**
	 * Drives forward until the button in the grip system detects a frontal
	 * collision
	 */
	public DriveForwardUntilCollision() {
		drive = DriveSystem.getInstance();
		grip = GripSystem.getInstance();
		requires(drive);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		drive.forward(RobotMap.AUTONOMOUS_DRIVE_FORWARD_SPEED);
	}

	@Override
	protected boolean isFinished() {
		return grip.isForwardContact();
	}

	@Override
	protected void end() {
		drive.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
