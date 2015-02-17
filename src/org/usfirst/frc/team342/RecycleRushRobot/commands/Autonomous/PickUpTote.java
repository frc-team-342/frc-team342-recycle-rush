package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveFowardDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveReverseDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripCloseTote;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Pick up a tote then turn and drive to the center of the field.
 */
public class PickUpTote extends CommandGroup {
    void AutonomousCommand2() {

	this.addSequential(new GripCloseTote());

	// this.addSequential(new
	// LiftUpHeight(RobotMap.LIFT_NOT_TOUCHING_GROUND));

	this.addSequential(new DriveTurnRightAngle(90));

	this.addSequential(new DriveReverseDistance(RobotMap.DISTANCE_TO_CENTER));
    }

}
