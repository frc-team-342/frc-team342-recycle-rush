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
	
	// Sensors
	public static final int ACCELEROMETER_ADDRESS = 0x53;
	public static final int GYRO_ADDRESS = 0x68;
	public static final int COMPASS_ADDRESS = 0x1e;
	
	// Sensor Registers
	public static final int ACCELEROMETER_REG_POWERCTL = 0x2d;
	public static final int ACCELEROMETER_REG_AXES = 0x32;
	
	public static final int GYRO_REG_DLPFFS = 0x16;
	public static final int GYRO_REG_AXES = 0x1b;
	
	public static final int COMPASS_REG_AXES = 0x03;
	
	// Ratio of G's per on least significant bit for the accelerometer, used for conversion to G's
	public static final double GsPerLSB = 0.00390625;
	public static final double degreesPerLSB = 1;//14.375/16;
	
	// Joystick Buttons
	
}
