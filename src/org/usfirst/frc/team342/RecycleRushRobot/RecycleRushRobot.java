package org.usfirst.frc.team342.RecycleRushRobot;

import java.util.Arrays;

import org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous.DriveToCenter;
import org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous.PickUpRecyclingContainer;
import org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous.PickUpThreeTotes;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveWithJoystick;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.CameraVisionRedux;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.ScissorSystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RecycleRushRobot extends IterativeRobot {
	private DriveSystem drive;
	private LiftSystem lift;
	private OI oi;
	private ScissorSystem scissor;
	private CameraVisionRedux camera;
	private GripSystem grip;

	private Command autonomousCommand;
	private DriverStation station;

	private DriveWithJoystick runnow;

	// Initialize old array of value from dash board for autonomous selection.
	private boolean[] oldArray = { true, false, false, false };

	// Declare a variable to store the angle to turn in degrees for autonomous
	private int angle;
	// The robot turn functions are inexact and these help to turn the robot to
	// the correct direction.

	private boolean gyroInitialized;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = OI.getInstance();
		gyroInitialized = false;
		drive = DriveSystem.getInstance();
		lift = LiftSystem.getInstance();
		scissor = ScissorSystem.getInstance();
		camera = CameraVisionRedux.getInstance();
		grip = GripSystem.getInstance();

		SmartDashboard.putBoolean("DB/Button 0", true);
		SmartDashboard.putBoolean("DB/Button 1", false);
		SmartDashboard.putBoolean("DB/Button 2", false);
		SmartDashboard.putBoolean("DB/Button 3", false);
		// Set the default to turn right.
		SmartDashboard.putString("DB/String 0", "right");
		// anymore
		FRCNetworkCommunicationsLibrary.HALSetErrorData("You're not my dad.");
	}

	/**
	 * Only allow one button to be pressed in dash board while disabled. This is
	 * used to get the autonomous mode when autonomous is initialized.
	 */
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		// Declare array to hold new values from dash board.
		boolean[] newArray = new boolean[4];

		// Set the values to the array from the dash board.
		for (int i = 0; i < 4; i++) {
			newArray[i] = SmartDashboard.getBoolean("DB/Button " + i);
		}

		// If the arrays are different then xor the arrays and store the values.
		if (!Arrays.equals(oldArray, newArray)) {
			for (int i = 0; i < 4; i++) {
				oldArray[i] = oldArray[i] ^ newArray[i];
				SmartDashboard.putBoolean("DB/Button " + i, oldArray[i]);
			}
		}

		// Only test the string occasionally.
		if (Math.floor((80 * Math.random())) == 0) {
			String board = SmartDashboard.getString("DB/String 0");
			if (board.startsWith("r") || board.startsWith("R"))
				angle = RobotMap.AUTONOMOUS_DRIVE_ROTATE_RIGHT_ANGLE;
			else if (board.startsWith("l") || board.startsWith("L"))
				angle = -1 * RobotMap.AUTONOMOUS_DRIVE_ROTATE_LEFT_ANGLE;
			// If this runs, someone made a mistake
			else {
				FRCNetworkCommunicationsLibrary
						.HALSetErrorData("ERROR!!!"
								+ "\n"
								+ "YOU HAD ONE JOB!!!\n"
								+ "YOU MISSPELLED EITHER LEFT OR RIGHT AND "
								+ "NOW THE ROBOT IS GOING TO GO RIGHT NO MATTER WHAT AND "
								+ "IT IS ALL YOUR FAULT!!!" + "\n");
				angle = RobotMap.AUTONOMOUS_DRIVE_ROTATE_RIGHT_ANGLE;
			}
		}

		if ((System.currentTimeMillis() >= drive.gyroInitStartTime + 5000)
				&& !gyroInitialized) {
			FRCNetworkCommunicationsLibrary
					.HALSetErrorData("The gyro has been initialized; "
							+ "Stay In Milk, Drink Your Drugs, Don't Do School"
							+ "\n");
			gyroInitialized = true;
		}
	}

	/**
	 * Sets the autonomous mode to the one selected in the button.
	 */
	@Override
	public void autonomousInit() {

		// Drive to center
		if (oldArray[0]) {
			autonomousCommand = new DriveToCenter(angle);
			SmartDashboard.putString("DB/String 5", "Drive to center and turn");
			FRCNetworkCommunicationsLibrary
					.HALSetErrorData("Autonomous Mode: \"Drive to center and turn\""
							+ " activated.");
		}

		// Pick up recycling container
		else if (oldArray[1]) {
			autonomousCommand = new PickUpRecyclingContainer(angle);
			SmartDashboard.putString("DB/String 5",
					"Pick up container, drive to center and turn");
			FRCNetworkCommunicationsLibrary
					.HALSetErrorData("Autonomous Mode: \"Pick up container, drive to center and turn\""
							+ " activated.");
		}

		// ALL YOUR TOTES ARE BELONG TO US!!!
		else if (oldArray[2]) {
			autonomousCommand = new PickUpThreeTotes();
			SmartDashboard.putString("DB/String 5", "Pick up three totes");
			FRCNetworkCommunicationsLibrary
					.HALSetErrorData("Autonomous Mode: \"Pick up three totes then drive to center and turn\""
							+ " activated.");
		}

		// unused button
		// else if (oldArray[3]) {
		// autonomousCommand = new PickUpObject(true, angle);
		// FRCNetworkCommunicationsLibrary
		// .HALSetErrorData("Autonomous Mode: 'Pick up tote, drive to center and turn'"
		// + " activated." + "\n");
		// }

		if (angle >= 0)
			FRCNetworkCommunicationsLibrary
					.HALSetErrorData("The autonomous robot will turn right "
							+ angle + " degrees." + "\n");
		else if (angle < 0)
			FRCNetworkCommunicationsLibrary
					.HALSetErrorData("The autonomous robot will turn left "
							+ angle + " degrees." + "\n");

		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * Initialize the joy stick
	 */
	@Override
	public void teleopInit() {
		runnow = new DriveWithJoystick();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		runnow.start();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.setEnabled(true);
		LiveWindow.run();
		// Running in test mode is very error-full.
		FRCNetworkCommunicationsLibrary.HALSetErrorData("'7H15' 15 4N 3RR0R\n");
	}
}
