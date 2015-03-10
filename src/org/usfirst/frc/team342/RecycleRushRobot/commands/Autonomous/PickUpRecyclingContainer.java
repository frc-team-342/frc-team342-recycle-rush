package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveResetGyro;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveStrafeLeftTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveRotateLeftAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveRotateRightAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripClose1;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripClose2;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpRelativeEncoder;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpToEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Pick up either a tote or a container (exclusive or) then drive to the center
 * of the field. This has not yet been tested.
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
		addParallel(new GripClose2());
		addParallel(new LiftUpToEncoder(
				RobotMap.AUTONOMOUS_LIFT_UP_ENCODER_VALUE));

		// Drive straight to the left to get out of the way quickly in
		// autonomous in case another robot is charging at you like a wild bull
		// at Rodeo
		addSequential(new DriveStrafeLeftTime());

		// Turn left to face the center of the field.
		addSequential(new DriveRotateLeftAngle(68));

		// reset the gyro
		addSequential(new DriveResetGyro());
		
		// Drive to the center of the field and rotate left
		addSequential(new DriveToCenter(80));
	}
}
