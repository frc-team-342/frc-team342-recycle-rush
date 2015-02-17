package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveFowardDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveReverseDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnLeftAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * drives to the center of the field.
 */
public class DriveToCenter extends CommandGroup {
    public DriveToCenter() {
	this.addSequential(new DriveFowardDistance(RobotMap.DISTANCE_TO_CENTER));

	this.addSequential(new DriveTurnRightAngle(90));
    }

}
