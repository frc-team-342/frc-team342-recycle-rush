package org.usfirst.frc.team342.RecycleRushRobot.commands;

import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveFowardTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveReverseTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnLeftTime;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveTurnRightTime;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BasicAutonomous extends CommandGroup {
	DriveSystem drive;
	
	public BasicAutonomous() {
		// TODO Auto-generated constructor stub
		drive = DriveSystem.getInstance();
		this.addSequential(new DriveFowardTime(1000));
		this.addSequential(new DriveTurnRightTime(1000));
		this.addSequential(new DriveReverseTime(1000));
		this.addSequential(new DriveTurnLeftTime(1000));
		
	}

}
