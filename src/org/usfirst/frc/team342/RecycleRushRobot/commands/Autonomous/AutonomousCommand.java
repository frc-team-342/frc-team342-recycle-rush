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

	public AutonomousCommand() {
		// TODO Auto-generated constructor stub
		drive = DriveSystem.getInstance();
        requires(this.drive);

		this.addSequential(new DriveTurnRightAngle(90));

		this.addSequential(new DriveFowardDistance(DRIVE_FORWARD_DISTANCE));
	}
	
}
