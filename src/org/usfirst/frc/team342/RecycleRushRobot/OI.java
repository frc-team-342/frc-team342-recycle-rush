package org.usfirst.frc.team342.RecycleRushRobot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team342.RecycleRushRobot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
	private Joystick driveController;
	private static final OI INSTANCE = new OI();
	
	private OI() {
		this.driveController = new Joystick(RobotMap.JOYSTICK_DRIVE_CONTROL);
	}
		
	public static OI getInstance() {
		return INSTANCE;
	}
	
	public Joystick getJoystick() {
		return driveController;
	}
	
	
}

