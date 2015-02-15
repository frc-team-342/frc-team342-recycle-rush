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
	public static final int ANALOG_IO_DRIVE_GYRO = 0;
	public static final int ANALOG_IO_DRIVE_ULTRASONIC = 1;

	// Scissor System
	public static final int CAN_CHANNELL_SCISSOR_EXTENSION = 0;
	public static final int CAN_CHANNELL_SCISSOR_LIFT = 1;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_OUT = 0;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_IN = 1;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_FORWARD_TILT = 2;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_BACK_TILT = 3;

	// Lift System
	public static final int VICTOR_SP_LIFT = 2;
	public static final int DIGITAL_IO_LIFT_LIMIT_SWITCH_UP = 4;
	public static final int DIGITAL_IO_LIFT_LIMIT_SWITCH_DOWN = 5;
	public static final int DIGITAL_IO_LIFT_QUADRATURE_ENCODER_A = 6;
	public static final int DIGITAL_IO_LIFT_QUADRATURE_ENCODER_B = 7;
	
	// Distance from the ground to set the lift to not drag
	public static final int LIFT_NOT_TOUCHING_GROUND = 10;

	// Gripper System
	public static final int CAN_CHANNEL_GRIP_OPEN_CLOSE = 3;
	public static final int ANALOG_IO_GRIP_POTENTIOMETER_POSITION = 2;
	public static final int ANALOG_IO_GRIP_ULTRASONIC = 3;
	public static final int DIGITAL_IO_GRIP_LIMIT_SWITCH_OUTER_LIMIT = 8;

	// Autonomous
	public static final int DISTANCE_TO_CENTER = 130;
	public static final int DISTANCE_TO_TOTE = 10;
	public static final int LIFT_UP_ENCODER_VALUE = 1000;
	public static final int LIFT_DOWN_ENCODER_VALUE = 100;
	public static final double GRIP_OPEN_POTENTIOMETER = 0.8;
	
}
