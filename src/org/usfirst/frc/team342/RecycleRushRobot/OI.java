package org.usfirst.frc.team342.RecycleRushRobot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team342.RecycleRushRobot.commands.camera.ChangeCamera;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.ChangeMode;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.ReadDebug;
//import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.ReadDebug;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.ResetGyro;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftDown;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftGetEncoder;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftStop;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUp;
import org.usfirst.frc.team342.RecycleRushRobot.commands.scissor.ScissorDown;
import org.usfirst.frc.team342.RecycleRushRobot.commands.scissor.ScissorExtend;
import org.usfirst.frc.team342.RecycleRushRobot.commands.scissor.ScissorRetract;
import org.usfirst.frc.team342.RecycleRushRobot.commands.scissor.ScissorStop;
import org.usfirst.frc.team342.RecycleRushRobot.commands.scissor.ScissorUp;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripClose;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripCloseContainer;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripCloseTote;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripOpen;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripStop;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private Joystick driveController;
	private Joystick assistJoystick;
	private static final OI INSTANCE = new OI();

	// Joy stick mapping
	public static final int JOYSTICK_DRIVE = 0;
	public static final int JOYSTICK_ASSIST = 1;

	// Joy stick buttons, axes 1 and 2 are for drive control. Axis 3 is not
	// used. POV buttons are unused.
	public static final int JOYSTICK_DRIVE_CHANGE_CAMERA = 1;
	public static final int JOYSTICK_DRIVE_RESET_GYRO = 2;
	public static final int JOYSTICK_DRIVE_SCISSOR_DOWN = 3;
	public static final int JOYSTICK_DRIVE_SCISSOR_RETRACT = 4;
	public static final int JOYSTICK_DRIVE_SCISSOR_UP = 5;
	public static final int JOYSTICK_DRIVE_SCISSOR_EXTEND = 6;
	public static final int JOYSTICK_DRIVE_BUTTON_7 = 7;
	public static final int JOYSTICK_DRIVE_CHANGE_MODE = 8;
	public static final int JOYSTICK_DRIVE_BUTTON_9 = 9;
	public static final int JOYSTICK_DRIVE_BUTTON_10 = 10;
	public static final int JOYSTICK_DRIVE_BUTTON_11 = 11;
	public static final int JOYSTICK_DRIVE_DEGUB_NUMBERS = 12;

	// Game pad buttons. Axes 5 and 6 are not used. Right and left trigger
	// control lift speed. Left thumb stick axes control scissor. The POV
	// buttons are unused.
	public static final int JOYSTICK_ASSIST_GRIP_OPEN = 1; // While held
	public static final int JOYSTICK_ASSIST_BUTTON_2 = 2;
	public static final int JOYSTICK_ASSIST_BUTTON_3 = 3;
	public static final int JOYSTICK_ASSIST_GRIP_CLOSE = 4; // While held
	public static final int JOYSTICK_ASSIST_BUTTON_5 = 5;
	public static final int JOYSTICK_ASSIST_BUTTON_6 = 6;
	public static final int JOYSTICK_ASSIST_BUTTON_7 = 7;
	public static final int JOYSTICK_ASSIST_CHANGE_CAMERA = 8;
	// Thumb stick buttons will probably not be used
	public static final int JOYSTICK_ASSIST_BUTTON_9 = 9;
	public static final int JOYSTICK_ASSIST_BUTTON_10 = 10;

	private OI() {

		// declare controllers
		this.driveController = new Joystick(JOYSTICK_DRIVE);
		this.assistJoystick = new Joystick(JOYSTICK_ASSIST);

		// declare scissor controls for the drive controller
		JoystickButton driveScissorUp = new JoystickButton(driveController,
				JOYSTICK_DRIVE_SCISSOR_UP);
		JoystickButton driveScissorDown = new JoystickButton(driveController,
				JOYSTICK_DRIVE_SCISSOR_DOWN);
		JoystickButton driveScissorExtend = new JoystickButton(driveController,
				JOYSTICK_DRIVE_SCISSOR_EXTEND);
		JoystickButton driveScissorRetract = new JoystickButton(
				driveController, JOYSTICK_DRIVE_SCISSOR_RETRACT);

		// declare the reset gyro button for the drive controller
		JoystickButton driveResetGyro = new JoystickButton(driveController,
				JOYSTICK_DRIVE_RESET_GYRO);

		// declare camera changing button for drive controller
		JoystickButton driveChangeCamera = new JoystickButton(driveController,
				JOYSTICK_DRIVE_CHANGE_CAMERA);

		JoystickButton driveChangeMode = new JoystickButton(driveController,
				JOYSTICK_DRIVE_CHANGE_MODE);

		JoystickButton driveDebugNumbers = new JoystickButton(driveController,
				JOYSTICK_DRIVE_DEGUB_NUMBERS);

		// declare Grip commands for assist joy stick
		JoystickButton assistGripOpen = new JoystickButton(assistJoystick,
				JOYSTICK_ASSIST_GRIP_OPEN);
		JoystickButton assistGripClose = new JoystickButton(assistJoystick,
				JOYSTICK_ASSIST_GRIP_CLOSE);
		// JoystickButton assistGripContainer = new
		// JoystickButton(assistJoystick,
		// JOYSTICK_ASSIST_GRIP_CLOSE_CONTAINER);
		// JoystickButton assistGripTote = new JoystickButton(assistJoystick,
		// JOYSTICK_ASSIST_GRIP_CLOSE_TOTE);

		// declare change camera command for assist joy stick
		JoystickButton assistChangeCamera = new JoystickButton(assistJoystick,
				JOYSTICK_ASSIST_CHANGE_CAMERA);

		// map drive controller scissor controls to scissor commands
		driveScissorUp.whileHeld(new ScissorUp());
		driveScissorDown.whileHeld(new ScissorDown());
		driveScissorExtend.whileHeld(new ScissorExtend());
		driveScissorRetract.whileHeld(new ScissorRetract());

		// map drive controller reset gyro button to reset gyro command
		driveResetGyro.whenPressed(new ResetGyro());

		// map drive controller change camera button to change camera command
		driveChangeCamera.whenPressed(new ChangeCamera());
		
		// map the function to switch between field oriented drive
		driveChangeMode.whenPressed(new ChangeMode());
		
		// Print debugging information
		driveDebugNumbers.whileHeld(new ReadDebug());

		// map assist joy stick grip buttons to grip commands
		assistGripOpen.whileHeld(new GripOpen());
		assistGripClose.whileHeld(new GripClose());
		// assistGripTote.whenPressed(new GripCloseTote());
		// assistGripContainer.whenPressed(new GripCloseContainer());

		// map assist joy stick change camera button to change camera command
		assistChangeCamera.whenPressed(new ChangeCamera());

	}

	public static OI getInstance() {
		return INSTANCE;
	}

	/**
	 * 
	 * @return the main joy stick drive controller
	 */
	public Joystick getJoystick() {
		return driveController;
	}

	/**
	 * 
	 * @return the secondary controller for the lift and scissor
	 */
	public Joystick getController() {
		return assistJoystick;
	}

}
