package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveForwardToDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveResetGyro;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnLeftAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightAngle;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drive to the center of the field.
 */
public class DriveToCenter extends CommandGroup {
	public DriveToCenter(int turn) {
		DriveSystem drive = DriveSystem.getInstance();
		// Drive to the center of the field
		if (drive.getDistance() <= RobotMap.AUTONOMOUS_DRIVE_FORWARD_DISTANCE_TO_CENTER)
			addSequential(new DriveForwardToDistance(
					RobotMap.AUTONOMOUS_DRIVE_BACKWARD_DISTANCE_TO_CENTER));
		else
			addSequential(new DriveForwardToDistance(
					RobotMap.AUTONOMOUS_DRIVE_FORWARD_DISTANCE_TO_CENTER));

		// Turn right to move the lift inside the center field boundaries
		if (turn > 0)
			addSequential(new DriveTurnRightAngle(turn));
		else
			// the turn is input as a negative, so it must be inverted to be
			// used in turning left
			addSequential(new DriveTurnLeftAngle(-1 * turn));
	}
}
