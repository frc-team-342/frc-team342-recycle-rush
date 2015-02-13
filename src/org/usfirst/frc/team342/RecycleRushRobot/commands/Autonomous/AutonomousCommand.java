package org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous;

import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveFowardDistance;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveFowardTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveReverseTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnLeftTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightAngle;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightTime;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends CommandGroup {
	DriveSystem drive;
	private final int DRIVE_FORWARD_DISTANCE = 130;
	private final long LIFT_UP_TIME = 1000;

	public AutonomousCommand() { // Go to center
		// TODO Auto-generated constructor stub
		drive = DriveSystem.getInstance();
		requires(this.drive);

		//this.addSequential(new DriveTurnRightAngle(90));

		this.addSequential(new DriveFowardDistance(DRIVE_FORWARD_DISTANCE));
	}
	
	/*
	
	// lift a container then turn right and drive to center of field
	public AutonomousCommand() {
		// TODO Auto-generated constructor stub
		drive = DriveSystem.getInstance();
        requires(this.drive);
	
		this.addSequential(new GripCloseContainer);

		this.addSequential(new LiftUpTime(LIFT_UP_TIME);
		
		this.addSequential(new DriveTurnRightAngle(90));

		this.addSequential(new DriveFowardDistance(DRIVE_FORWARD_DISTANCE));
	}
	
	*/
	
/*
	
	// lift a container then turn right and drive to center of field
	public AutonomousCommand() {
		// TODO Auto-generated constructor stub
		drive = DriveSystem.getInstance();
        requires(this.drive);
	
		this.addSequential(new GripCloseContainer);

		this.addSequential(new LiftSomething());
		
		this.addSequential(new DriveTurnLeftAngle(90));

		this.addSequential(new DriveFowardDistance(DRIVE_FORWARD_DISTANCE));
	}
	
	*/
}
