package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveFowardDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpHeight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * drives to the center of the field.
 */
public class DriveToCenter extends CommandGroup {
	public DriveToCenter() {

		this.addParallel(new LiftUpHeight(RobotMap.LIFT_NOT_TOUCHING_GROUND));

		this.addSequential(new DriveFowardDistance(RobotMap.DISTANCE_TO_CENTER));
	}

}
