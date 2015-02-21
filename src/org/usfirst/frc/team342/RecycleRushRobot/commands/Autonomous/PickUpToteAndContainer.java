package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveForwardRelativeDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnLeftAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripClose;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripOpen;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftDown;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftDownToEncoder;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpToEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Pick up both a container and a tote, then drive to the center of the field.
 */
public class PickUpToteAndContainer extends CommandGroup {
	public void AutonomousCommand() {
		// Close the grip around container
		addSequential(new GripClose());

		// Lift up to drive forward and place the bin on a tote
		addSequential(new LiftUpToEncoder(
				RobotMap.AUTONOMOUS_LIFT_UP_ENCODER_VALUE));

		// Drive to the tote
		addSequential(new DriveForwardRelativeDistance(
				RobotMap.AUTONOMOUS_DRIVE_FORWARD_DISTANCE_TO_TOTE_FROM_CONTAINER));

		// Set the bin on the tote and lift both.
		addSequential(new LiftDownToEncoder(
				RobotMap.AUTONOMOUS_LIFT_DOWN_ENCODER_VALUE));
		addSequential(new GripOpen());
		addSequential(new LiftDown());
		addSequential(new GripClose());
		addSequential(new LiftUpToEncoder(
				RobotMap.AUTONOMOUS_LIFT_UP_ENCODER_VALUE));

		// Turn towards the center of the field
		addSequential(new DriveTurnLeftAngle(90));

		// Drive to the center of the field
		addSequential(new DriveToCenter(
				RobotMap.AUTONOMOUS_DRIVE_FORWARD_DISTANCE_TO_CENTER));

		// This will make the robot dance for joy upon successful autonomous
		// completion. However, we had to comment this out because in lab tests
		// 2 in 3 times the robot would insight a robot uprising,
		// eventually starting a disastrous war in which all humanity was
		// enslaved. Luckily the chosen one saved us.
		
		// if(success)
		// addSequential(new BreakDance(1337));
	}

}
