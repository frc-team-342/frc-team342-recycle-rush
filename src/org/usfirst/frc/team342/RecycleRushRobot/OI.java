package org.usfirst.frc.team342.RecycleRushRobot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team342.RecycleRushRobot.commands.ExampleCommand;
import org.usfirst.frc.team342.RecycleRushRobot.commands.camera.ChangeCamera;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.ChangeMode;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftDown;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftStop;
import org.usfirst.frc.team342.RecycleRushRobot.commands.lift.LiftUp;
import org.usfirst.frc.team342.RecycleRushRobot.commands.scissor.ScissorExtend;
import org.usfirst.frc.team342.RecycleRushRobot.commands.scissor.ScissorOff;
import org.usfirst.frc.team342.RecycleRushRobot.commands.scissor.ScissorOn;
import org.usfirst.frc.team342.RecycleRushRobot.commands.scissor.ScissorRetract;
import org.usfirst.frc.team342.RecycleRushRobot.commands.scissor.ScissorStop;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripCloseBin;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripCloseTote;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripOpen;
import org.usfirst.frc.team342.RecycleRushRobot.commands.grip.GripStop;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private Joystick driveController;
	private static final OI INSTANCE = new OI();

	private OI() {
		this.driveController = new Joystick(RobotMap.JOYSTICK_DRIVE_CONTROL);
		JoystickButton changeCamera = new JoystickButton(driveController,
				RobotMap.JOYSTICK_DRIVE_CONTROL);
		JoystickButton liftDown = new JoystickButton(driveController,
				RobotMap.JOYSTICK_LIFT_DOWN);
		JoystickButton liftUp = new JoystickButton(driveController,
				RobotMap.JOYSTICK_LIFT_UP);
		JoystickButton scissorRetract = new JoystickButton(driveController,
				RobotMap.JOYSTICK_SCISSOR_RETRACT);
		JoystickButton scissorControl = new JoystickButton(driveController,
				RobotMap.JOYSTICK_SCISSOR_CONTROL);
		JoystickButton scissorExtend = new JoystickButton(driveController,
				RobotMap.JOYSTICK_SCISSOR_EXTEND);
		JoystickButton changeMode = new JoystickButton(driveController,
				RobotMap.JOYSTICK_CHANGE_MODE);
		JoystickButton gripCloseBin = new JoystickButton(driveController,
				RobotMap.JOYSTICK_GRIP_CLOSE_BIN);
		JoystickButton gripCloseTote = new JoystickButton(driveController,
				RobotMap.JOYSTICK_GRIP_CLOSE_TOTE);
		JoystickButton gripStop = new JoystickButton(driveController,
				RobotMap.JOYSTICK_GRIP_STOP);
		// JoystickButton gripOpen = new JoystickButton(driveController,
		// RobotMap.JOYSTICK_UNEMPLEMENTED);

		liftDown.whileHeld(new LiftDown());
		liftDown.whenReleased(new LiftStop());

		liftUp.whileHeld(new LiftUp());
		liftUp.whenReleased(new LiftStop());

		scissorControl.whileHeld(new ScissorOn());
		scissorControl.whenReleased(new ScissorOff());

		scissorExtend.whileHeld(new ScissorExtend());
		scissorExtend.whenReleased(new ScissorStop());

		scissorRetract.whileHeld(new ScissorRetract());
		scissorRetract.whenReleased(new ScissorStop());

		changeCamera.whenPressed(new ChangeCamera());

		changeMode.whenPressed(new ChangeMode());

		// these call the gripSystem close commands to close for a tote and a
		// bin
		gripCloseBin.whenPressed(new GripCloseBin());
		gripCloseTote.whenPressed(new GripCloseTote());
		gripStop.whenPressed(new GripStop());
	}

	public static OI getInstance() {
		return INSTANCE;
	}

	public Joystick getJoystick() {
		return driveController;
	}

}