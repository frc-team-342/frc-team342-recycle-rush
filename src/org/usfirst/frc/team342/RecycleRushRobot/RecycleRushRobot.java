package org.usfirst.frc.team342.RecycleRushRobot;

import edu.wpi.first.wpilibj.IterativeRobot;
//import java.lang.ClassNotFoundException;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team342.RecycleRushRobot.commands.BasicAutonomous;
import org.usfirst.frc.team342.RecycleRushRobot.commands.ExampleCommand;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveWithJoystick;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.CameraVision;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RecycleRushRobot extends IterativeRobot {

	// public static final ExampleSubsystem exampleSubsystem = new
	// ExampleSubsystem();
	private DriveSystem drive;
	private CameraVision camera;
	private OI oi;
	private Command autonomousCommand;
	
	// Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = OI.getInstance();
		// instantiate the command used for the autonomous period
		// autonomousCommand = new ExampleCommand();
		this.drive = DriveSystem.getInstance();
		this.camera = CameraVision.getInstance();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		// if (autonomousCommand != null) autonomousCommand.start();
		autonomousCommand = new BasicAutonomous();
        autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// tele operated starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		// if (autonomousCommand != null) autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		DriveWithJoystick runnow = new DriveWithJoystick();
		runnow.start();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
