package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveForwardToDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveRotateLeftAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveRotateRightAngle;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drive to the center of the field.
 */
public class DriveToCenter extends CommandGroup {
	public DriveToCenter(int rotate) {
		DriveSystem drive = DriveSystem.getInstance();
		// Drive to the center of the field
		addSequential(new DriveForwardToDistance(
				RobotMap.AUTONOMOUS_DRIVE_FORWARD_DISTANCE_TO_CENTER));

		// Turn right to move the lift inside the center field boundaries
		if (rotate > 0)
			addSequential(new DriveRotateRightAngle(rotate));
		else
			// the turn is input as a negative, so it must be inverted to be
			// used in turning left
			addSequential(new DriveRotateLeftAngle(-1 * rotate));
	}
}
