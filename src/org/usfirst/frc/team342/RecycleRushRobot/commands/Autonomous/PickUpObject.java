package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnLeftAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripClose;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Pick up either a tote or a container (exclusive or) then drive to the center
 * of the field. This has not yet been tested.
 */
public class PickUpObject extends CommandGroup {
	/**
	 * @param tote
	 *            a boolean value to determine whether the robot is going to
	 *            lift the tote or container. This actually only changes the
	 *            direction the robot will turn, so if you need the robot to
	 *            turn the opposite direction just invert this value.
	 */
	public PickUpObject(boolean tote) {
		// Close the grip, this will close the same for containers and totes.
		addSequential(new GripClose());

		// If the boolean is true turn right to face the center of the field,
		// else turn left to face the center of the field.
		if (tote)
			addSequential(new DriveTurnRightAngle(90));
		else
			addSequential(new DriveTurnLeftAngle(90));

		// Dive to the center of the field.
		addSequential(new DriveToCenter(90));
	}
}
