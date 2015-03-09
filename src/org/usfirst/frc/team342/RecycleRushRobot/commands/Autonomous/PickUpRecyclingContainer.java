package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveStrafeLeftTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnLeftAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripClose1;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpTime;

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
		// Close the grip, this will close the same for containers and totes.
		addSequential(new DriveStrafeLeftTime());
		addSequential(new GripClose1());
		addSequential(new LiftUpTime(RobotMap.AUTONOMOUS_LIFT_UP_TIME_VALUE));

		// Turn left to face the center of the field.
		addSequential(new DriveTurnLeftAngle(90));

		// Drive to the center of the field.
		addSequential(new DriveToCenter(90));
	}
}
