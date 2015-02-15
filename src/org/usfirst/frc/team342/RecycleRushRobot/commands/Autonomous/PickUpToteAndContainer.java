package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveFowardDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripCloseContainer;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripCloseTote;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripOpenWidth;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftDownHeight;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpHeight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * First lift a tote, then drive forward to a container. Set down the tote, open
 * the grip, lower to the height of the container, grip the container then raise
 * the lift. After that turn and drive to the center of the field.
 */
public class PickUpToteAndContainer extends CommandGroup {
	public void AutonomousCommand() {

		this.addSequential(new GripCloseTote());
		this.addSequential(new LiftUpHeight(RobotMap.LIFT_UP_ENCODER_VALUE));

		this.addSequential(new DriveFowardDistance(RobotMap.DISTANCE_TO_TOTE));

		this.addSequential(new GripOpenWidth(RobotMap.GRIP_OPEN_POTENTIOMETER));
		this.addSequential(new LiftDownHeight(RobotMap.LIFT_DOWN_ENCODER_VALUE));
		this.addSequential(new GripCloseContainer());
		this.addSequential(new LiftUpHeight(RobotMap.LIFT_NOT_TOUCHING_GROUND));

		this.addSequential(new DriveTurnRightAngle(90));

		this.addSequential(new DriveFowardDistance(RobotMap.DISTANCE_TO_CENTER));

	}

}
