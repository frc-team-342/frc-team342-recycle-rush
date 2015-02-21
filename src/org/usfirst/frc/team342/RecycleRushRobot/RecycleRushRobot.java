package org.usfirst.frc.team342.RecycleRushRobot;

import java.util.Arrays;

import org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous.DriveToCenter;
import org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous.PickUpObject;
import org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous.PickUpToteAndContainer;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveWithJoystick;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.CameraVisionRedux;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.ScissorSystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
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

	private DriveWithJoystick runnow;

	// Initialize old array of value from dash board for autonomous selection
	private boolean[] oldArray = { true, false, false, false };

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		this.oi = OI.getInstance();
		this.drive = DriveSystem.getInstance();
		this.lift = LiftSystem.getInstance();
		this.scissor = ScissorSystem.getInstance();
		this.camera = CameraVisionRedux.getInstance();
		this.grip = GripSystem.getInstance();

		SmartDashboard.putBoolean("DB/Button 0", true);
	}

	/**
	 * only allow one button to be pressed in dash board while disabled. This is
	 * used to get the autonomous mode when autonomous is initialized.
	 */
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		// declare array to hold new values from dash board
		boolean[] newArray = new boolean[4];

		// set the values to the array from the dash board
		for (int i = 0; i < 4; i++) {
			newArray[i] = SmartDashboard.getBoolean("DB/Button " + i);
		}

		// if the arrays are different then xor the arrays and store the values
		if (!Arrays.equals(oldArray, newArray)) {
			for (int i = 0; i < 4; i++) {
				oldArray[i] = oldArray[i] ^ newArray[i];
				SmartDashboard.putBoolean("DB/Button " + i, oldArray[i]);
			}
		}
	}

	/**
	 * sets the autonomous mode to the one selected in the button
	 */
	@Override
	public void autonomousInit() {
		if (oldArray[0])
			autonomousCommand = new DriveToCenter(90);
		else if (oldArray[1])
			autonomousCommand = new PickUpObject(true);
		else if (oldArray[2])
			autonomousCommand = new PickUpObject(false);
		else if (oldArray[3])
			autonomousCommand = new PickUpToteAndContainer();

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
	 * initialize the joy stick
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

	}
}
