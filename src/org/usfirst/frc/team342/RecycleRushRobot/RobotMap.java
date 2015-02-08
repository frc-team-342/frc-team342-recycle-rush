package org.usfirst.frc.team342.RecycleRushRobot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Drive System
	public static final int CAN_CHANNEL_RIGHT_FRONT_DRIVE_MOTOR = 6;
	public static final int CAN_CHANNEL_LEFT_FRONT_DRIVE_MOTOR = 4;
	public static final int CAN_CHANNEL_LEFT_BACK_DRIVE_MOTOR = 3;
	public static final int CAN_CHANNEL_RIGHT_BACK_DRIVE_MOTOR = 5;

	// Controllers
	public static final int JOYSTICK_DRIVE_CONTROL = 0;
	
	// Autonomous Speed
	public static final double AUTONOMOUS_SPEED = 1.0;
	public static final double AUTONOMOUS_STOP = 0.0;
	public static final double AUTONOMOUS_REVERSE = -1.0;
	public static final double AUTONOMOUS_TURN_RIGHT = 0.5;
	
	//values for the code to know how much to close the gripper, numbers should be based on potentiometer voltage values
	//FOR THE LOVE OF ALL THINGS GOOD DO NOT USE THIS WITHOUT FIRST DETERMINING (AND IMPLEMENTING) 
	//aTHE VALUES TO USE FOR THESE, THEY ARE CURRENTLY RELATIVE
	public static final double TOTE = 1;
	public static final double BIN = 2;
	public static final double FULLOPEN = 3;
	public static final double MINIMUM = TOTE - .2;
}
