package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveForwardToDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drive to the center of the field. This has not yet been tested.
 */
public class PickUpObject extends CommandGroup {
	public PickUpObject() {
		
		
		addSequential(new DriveToCenter(90));
	}
}
