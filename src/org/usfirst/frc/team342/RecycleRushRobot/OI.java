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

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private Joystick driveController;
	private static final OI INSTANCE = new OI();

	private OI() {
		this.driveController = new Joystick(RobotMap.JOYSTICK_DRIVE_CONTROL);
		JoystickButton liftDown = new JoystickButton(driveController, 2);
		JoystickButton liftUp = new JoystickButton(driveController, 3);
		JoystickButton clawControl = new JoystickButton(driveController, 5);
		JoystickButton clawExtend = new JoystickButton(driveController, 6);
		JoystickButton clawRetract = new JoystickButton(driveController, 4);
		JoystickButton changeCamera = new JoystickButton(driveController, 1);
		JoystickButton changeMode = new JoystickButton(driveController, 7);

		liftDown.whileHeld(new LiftDown());
		liftDown.whenReleased(new LiftStop());

		liftUp.whileHeld(new LiftUp());
		liftUp.whenReleased(new LiftStop());

		clawControl.whileHeld(new ScissorOn());
		clawControl.whenReleased(new ScissorOff());

		clawExtend.whileHeld(new ScissorExtend());
		clawExtend.whenReleased(new ScissorStop());

		clawRetract.whileHeld(new ScissorRetract());
		clawRetract.whenReleased(new ScissorStop());

		changeCamera.whenPressed(new ChangeCamera());

		changeMode.whenPressed(new ChangeMode());
	}

	public static OI getInstance() {
		return INSTANCE;
	}

	public Joystick getJoystick() {
		return driveController;
	}

}