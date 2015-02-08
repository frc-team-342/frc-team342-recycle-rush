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

	// Scissor System
	public static final int CAN_CHANNELL_SCISSOR_EXTENSION = 0;
	public static final int CAN_CHANNELL_SCISSOR_LIFT = 1;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_OUT = 0;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_IN = 1;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_FORWARD_TILT = 2;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_BACK_TILT = 3;

	// Lift System
	public static final int PWM_LIFT_VICTOR_SP = 2;
	public static final int DIGITAL_IO_LIFT_LIMIT_SWITCH_UP = 4;
	public static final int DIGITAL_IO_LIFT_LIMIT_SWITCH_DOWN = 5;
	public static final int DIGITAL_IO_LIFT_QUADRATURE_ENCODER_A = 6;
	public static final int DIGITAL_IO_LIFT_QUADRATURE_ENCODER_B = 7;

	// Gripper System
	public static final int CAN_CHANNEL_GRIPPER_OPEN_CLOSE = 3;
	public static final int ANALOG_GRIPPER_POTENTIOMETER_POSITION = 2;
	public static final int ANALOG_GRIPPER_ULTRASONIC = 3;
	public static final int DIGITAL_IO_GRIPPER_LIMIT_SWITCH_OUTER_LIMIT = 8;

	// Controllers
	public static final int JOYSTICK_DRIVE_CONTROL = 0;

	// Autonomous Speed
	public static final double AUTONOMOUS_SPEED = 1.0;
	public static final double AUTONOMOUS_STOP = 0.0;
	public static final double AUTONOMOUS_REVERSE = -1.0;
	public static final double AUTONOMOUS_TURN_RIGHT = 0.5;

	// values for the code to know how much to close the gripper, numbers should
	// be based on potentiometer voltage values
	// FOR THE LOVE OF ALL THINGS GOOD DO NOT USE THIS WITHOUT FIRST DETERMINING
	// (AND IMPLEMENTING)
	// THE VALUES TO USE FOR THESE, THEY ARE CURRENTLY RELATIVE
	public static final double GRIPPER_TOTE = 1;
	public static final double GRIPPER_BIN = 2;
	public static final double GRIPPER_FULL_OPEN = 3;
	public static final double GRIPPER_MINIMUM_OPEN = GRIPPER_TOTE - .2;
}
