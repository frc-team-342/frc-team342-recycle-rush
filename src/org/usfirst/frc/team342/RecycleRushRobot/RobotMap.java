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
	public static final int CAN_CHANNEL_GRIP_OPEN_CLOSE = 3;
	public static final int ANALOG_GRIP_POTENTIOMETER_POSITION = 2;
	public static final int ANALOG_GRIP_ULTRASONIC = 3;
	public static final int DIGITAL_IO_GRIP_LIMIT_SWITCH_OUTER_LIMIT = 8;

	// Controllers
	public static final int JOYSTICK_DRIVE_CONTROL = 0;
	public static final int JOYSTICK_CHANGE_CAMERA = 1;
	public static final int JOYSTICK_LIFT_DOWN = 2;
	public static final int JOYSTICK_LIFT_UP = 3;
	public static final int JOYSTICK_SCISSOR_RETRACT = 4;
	public static final int JOYSTICK_SCISSOR_CONTROL = 5;
	public static final int JOYSTICK_SCISSOR_EXTEND = 6;
	public static final int JOYSTICK_CHANGE_MODE = 7;
	public static final int JOYSTICK_GRIP_CLOSE_BIN = 8;
	public static final int JOYSTICK_GRIP_CLOSE_TOTE = 9;
	public static final int JOYSTICK_GRIP_STOP = 10;
	
	//Signifies functions that have been reserved for later to be easily changed in OI comments
	public static final int JOYSTICK_UNEMPLEMENTED = -1;	

	// Autonomous Speed
	public static final double AUTONOMOUS_SPEED = 1.0;
	public static final double AUTONOMOUS_STOP = 0.0;
	public static final double AUTONOMOUS_REVERSE = -1.0;
	public static final double AUTONOMOUS_TURN_RIGHT = 0.5;

	// the gripper calls these as a guide for where to stop the gripper
	public static final double GRIP_TOTE = 1;
	public static final double GRIP_BIN = 2;
	public static final double GRIP_FULL_OPEN = 3;
	public static final double GRIP_MINIMUM_STOP_OPEN = .2;
}
