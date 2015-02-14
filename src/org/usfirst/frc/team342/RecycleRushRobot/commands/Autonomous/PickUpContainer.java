package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveFowardDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveFowardTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveReverseTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnLeftAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnLeftTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripCloseContainer;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripCloseTote;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUpTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.scissor.ScissorExtend;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickUpContainer extends CommandGroup {
	DriveSystem drive;
	private final int DISTANCE_TO_CENTER = 130;
	private final int DISTANCE_TO_TOTE = 10;
	private final long LIFT_UP_ENCODER_VALUE = 1000;
	private final long LIFT_DOWN_ENCODER_VALUE = 100;
	 
	 // lift a container then turn left and drive to center of field 
	public PickUpContainer() { drive = DriveSystem.getInstance();
		 requires(this.drive);
		 
		 this.addSequential(new GripCloseContainer());
		 
		 this.addSequential(new LiftUpTime(LIFT_UP_ENCODER_VALUE));
		 
		 // turn left 90 degrees 
		 this.addSequential(new DriveTurnLeftAngle(90));
		 
		 this.addSequential(new DriveFowardDistance(DISTANCE_TO_CENTER)); 
	 }

}
