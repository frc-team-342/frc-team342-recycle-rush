package org.usfirst.frc.team342.RecycleRushRobot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Drive System Units
	public static final int CAN_CHANNEL_RIGHT_FRONT_DRIVE_MOTOR = 6;
	public static final int CAN_CHANNEL_LEFT_FRONT_DRIVE_MOTOR = 4;
	public static final int CAN_CHANNEL_LEFT_BACK_DRIVE_MOTOR = 3;
	public static final int CAN_CHANNEL_RIGHT_BACK_DRIVE_MOTOR = 5;
	public static final int ANALOG_IO_DRIVE_GYRO = 0;
	public static final int ANALOG_IO_DRIVE_ULTRASONIC = 1;

	// Scissor System Units
	public static final int CAN_CHANNELL_SCISSOR_EXTENSION = 0;
	public static final int CAN_CHANNELL_SCISSOR_LIFT = 1;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_OUT = 0;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_IN = 1;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_FORWARD_TILT = 2;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_BACK_TILT = 3;

	// Lift System Units
	public static final int VICTOR_SP_LIFT = 2;
	public static final int DIGITAL_IO_LIFT_LIMIT_SWITCH_UP = 4;
	public static final int DIGITAL_IO_LIFT_LIMIT_SWITCH_DOWN = 5;
	public static final int DIGITAL_IO_LIFT_QUADRATURE_ENCODER_A = 6;
	public static final int DIGITAL_IO_LIFT_QUADRATURE_ENCODER_B = 7;

	// Gripper System Units
	public static final int CAN_CHANNEL_GRIP_OPEN_CLOSE = 3;
	public static final int ANALOG_IO_GRIP_ULTRASONIC = 3;
	public static final int DIGITAL_IO_GRIP_LIMIT_SWITCH_OUTER_LIMIT = 8;
	public static final int DIGITAL_IO_GRIP_LIMIT_SWITCH_INNER_LIMIT = 9;

	// Autonomous speeds
	public static final double AUTONOMOUS_SPEED = 0.3;
	public static final double AUTONOMOUS_REVERSE = -0.3;
	public static final double AUTONOMOUS_TURN_RIGHT = 0.3;
	public static final double AUTONOMOUS_TURN_LEFT = -0.3;

	public static final double AUTONOMOUS_LIFT_SPEED_UP = 0.2;
	public static final double AUTONOMOUS_LIFT_SPEED_DOWN = -0.2;
	
	// Autonomous distances to drive using ultrasonic
	public static final int AUTONOMOUS_FORWARD_DISTANCE_TO_CENTER = 2900;
	public static final int AUTONOMOUS_BACKWARD_DISTANCE_TO_CENTER = 2500;
	
	// Autonomous distance from tote to close
	public static final int AUTONOMOUS_DISTANCE_TO_TOTE = 10;

	// TODO test the encoder
	public static final int AUTONOMOUS_LIFT_UP_ENCODER_VALUE = 1000;
	public static final int AUTONOMOUS_LIFT_DOWN_ENCODER_VALUE = 100;

	// used to lift the encode off the ground before driving
	public static final int AUTONOMOUS_LIFT_FLOAT_ENCODER_VALUE = 10;

	// set the value for the dead zone for the controllers
	public static final double GAMEPAD_DEADZONE = 0.01;

}
