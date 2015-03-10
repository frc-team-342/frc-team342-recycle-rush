package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveForwardTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveRotateRightAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripClose1;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripClose2;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripClose3;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftDownToEncoder;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpRelativeEncoder;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpToEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickUpThreeTotes extends CommandGroup {

	public PickUpThreeTotes() {
		// TODO Make a valiant attempt to pick up three totes in autonomous

		// Grip first tote
		// uses the most-closed setting
		addSequential(new GripClose1());

		// lift up
		addSequential(new LiftUpToEncoder(
				RobotMap.AUTONOMOUS_LIFT_UP_ENCODER_VALUE));

		// drive forward to second tote
		addSequential(new DriveForwardTime(
				RobotMap.AUTONOMOUS_DRIVE_FORWARD_TIME_BETWEEN_TOTES));

		// lower the lift
		addSequential(new LiftUpToEncoder(
				RobotMap.AUTONOMOUS_LIFT_UP_ENCODER_VALUE));

		// open grip
		addSequential(new GripClose2());

		// lower the lift
		addSequential(new LiftDownToEncoder(
				RobotMap.AUTONOMOUS_LIFT_DOWN_ENCODER_VALUE));

		// close the grip
		addSequential(new GripClose1());

		// lift the lift to the height of 1 tote
		addSequential(new LiftUpToEncoder(
				RobotMap.AUTONOMOUS_LIFT_UP_ENCODER_VALUE));

		// drive to the third
		addSequential(new DriveForwardTime(
				RobotMap.AUTONOMOUS_DRIVE_FORWARD_TIME_BETWEEN_TOTES));

		// lower the lift
		addSequential(new LiftDownToEncoder(
				RobotMap.AUTONOMOUS_LIFT_DOWN_ENCODER_VALUE));

		// open grip
		addSequential(new GripClose2());

		// lower the lift
		// addSequential(new LiftDownToEncoder(RobotMap.));

		// close the grip
		addSequential(new GripClose1());

		// lift the lift a little
		addSequential(new LiftUpRelativeEncoder(100));

		// turn right
		addSequential(new DriveRotateRightAngle(90));

		// drive to the center
		addSequential(new DriveToCenter(90));

		// lower the lift
		addSequential(new LiftDownToEncoder(50));

		// open grip to get full points!
		addSequential(new GripClose3());
	}

}
