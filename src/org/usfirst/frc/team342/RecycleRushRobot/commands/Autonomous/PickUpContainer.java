package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveFowardDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnLeftAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripCloseContainer;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Pick up a container then turn and rive to the center of the field.
 */
public class PickUpContainer extends CommandGroup {
    public PickUpContainer() {

	this.addSequential(new GripCloseContainer());

	// this.addSequential(new
	// LiftUpHeight(RobotMap.LIFT_NOT_TOUCHING_GROUND));

	this.addSequential(new DriveTurnLeftAngle(90));

	this.addSequential(new DriveFowardDistance(RobotMap.DISTANCE_TO_CENTER));
    }

}
