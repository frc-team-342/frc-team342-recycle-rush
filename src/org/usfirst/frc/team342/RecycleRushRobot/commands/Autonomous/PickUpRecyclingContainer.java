package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveResetGyro;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveRotateLeftAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveStrafeLeftTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripMove2;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Pick up a container then drive to the center of the field.
 */
public class PickUpRecyclingContainer extends CommandGroup {

	/**
	 * Pick up a recycling container , then strafe left quickly, then turn and
	 * drive to the center of the field, and finally orient the robot to fit in
	 * the space better.
	 * 
	 * @param angle
	 *            the angle to turn after the robot is in the center of the
	 *            field
	 */
	public PickUpRecyclingContainer(int angle) {
		// Close the grip to a specified value.
		// TODO the turn angles are supposed to make the robot turn 90 degrees,
		// but the turn is not exact
		addParallel(new GripMove2());
		addSequential(new LiftUpTime((long) 0.2
				* RobotMap.AUTONOMOUS_LIFT_UP_TIME_VALUE));
		addParallel(new LiftUpTime((long) 0.8
				* RobotMap.AUTONOMOUS_LIFT_UP_TIME_VALUE));
		// addSequential(new LiftUpToEncoder(
		// RobotMap.AUTONOMOUS_LIFT_UP_ENCODER_VALUE));

		// Drive straight to the left to get out of the way quickly in
		// autonomous in case another robot is charging at you like a wild bull
		// at Rodeo
		addSequential(new DriveStrafeLeftTime());

		// Turn left to face the center of the field.
		addSequential(new DriveRotateLeftAngle(
				RobotMap.AUTONOMOUS_DRIVE_ROTATE_LEFT_ANGLE));

		// Reset the gyro so the value will be zero for field oriented drive in
		// autonomous
		addSequential(new DriveResetGyro());

		// Drive to the center of the field and rotate
		addSequential(new DriveToCenter(angle));
	}
}
