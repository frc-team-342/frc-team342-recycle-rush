package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveForwardToDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveReverseToDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpToEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drive to the center of the field. This has not yet been tested.
 */
public class PickUpContainer extends CommandGroup {
	public PickUpContainer() {
		// This is commented out for lack of lift system

		// // Move the lift off the ground before driving
		// this.addSequential(new LiftUpToEncoder(
		// RobotMap.AUTONOMOUS_LIFT_DOWN_ENCODER_VALUE));

		// Drive to the center of the field
		
		this.addSequential(new DriveForwardToDistance(
				RobotMap.AUTONOMOUS_DISTANCE_TO_CENTER));

		// Turn right to move the lift inside the center field boundaries
		this.addSequential(new DriveTurnRightAngle(90));
	}
}
