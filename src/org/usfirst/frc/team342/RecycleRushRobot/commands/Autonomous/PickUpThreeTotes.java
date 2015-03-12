package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveForwardUntilCollision;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveResetGyro;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveRotateRightAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripMove1;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripMove2;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripMove3;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftDownToEncoder;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpRelativeEncoder;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpToEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickUpThreeTotes extends CommandGroup {

	public PickUpThreeTotes() {
		// TODO Make a valiant attempt to pick up three totes in autonomous
		// TODO determine exact values

		// Grip first tote
		// Uses the most-closed setting
		addSequential(new GripMove1());

		// Lift up
		// TODO this would probably work more reliably as a relative value
		addSequential(new LiftUpToEncoder(
				RobotMap.AUTONOMOUS_LIFT_UP_ENCODER_VALUE));

		// Drive forward to the second tote
		addSequential(new DriveForwardUntilCollision());

		// Lower the lift
		// This is parallel because the grip should open at the same time as the
		// lift lowers to save time and hopefully smooth out the gripping
		addParallel(new LiftDownToEncoder(
				RobotMap.AUTONOMOUS_LIFT_DOWN_ENCODER_VALUE));
		// Open grip
		addSequential(new GripMove2());
		// Lower the lift
		addSequential(new LiftDownToEncoder(
				RobotMap.AUTONOMOUS_LIFT_DOWN_ENCODER_VALUE));
		// Close the grip
		addSequential(new GripMove1());
		// Lift the lift to the height of 1 tote
		// TODO this would probably work more reliably as a relative value
		addSequential(new LiftUpToEncoder(
				RobotMap.AUTONOMOUS_LIFT_UP_ENCODER_VALUE));

		// Drive to the third tote
		addSequential(new DriveForwardUntilCollision());

		// Lower the lift
		// This is parallel because the grip should open at the same time as the
		// lift lowers to save time and hopefully smooth out the gripping
		addParallel(new LiftDownToEncoder(
				RobotMap.AUTONOMOUS_LIFT_DOWN_ENCODER_VALUE));
		// Open grip
		addSequential(new GripMove2());
		// Lower the lift
		addSequential(new LiftDownToEncoder(
				RobotMap.AUTONOMOUS_LIFT_DOWN_ENCODER_VALUE));
		// Close the grip
		addSequential(new GripMove1());
		// Lift the lift a little
		addSequential(new LiftUpRelativeEncoder(
				RobotMap.AUTONOMOUS_LIFT_UP_RELATIVE_ENCODER_VALUE));

		// Turn right to face the center of the field
		addSequential(new DriveRotateRightAngle(
				RobotMap.AUTONOMOUS_DRIVE_ROTATE_RIGHT_ANGLE));
		// Reset the gyro after facing towards center
		addSequential(new DriveResetGyro());
		// Drive to the center of the field and rotate
		addSequential(new DriveToCenter(
				RobotMap.AUTONOMOUS_DRIVE_ROTATE_RIGHT_ANGLE));

		// Lower the lift all the way
		addSequential(new LiftDownToEncoder(0));

		// Open grip to get full points!
		addSequential(new GripMove3());
	}

}
