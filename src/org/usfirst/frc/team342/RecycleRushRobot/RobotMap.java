package org.usfirst.frc.team342.RecycleRushRobot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Drive System Components
	public static final int PWM_FRONT_RIGHT_DRIVE_MOTOR = 6;
	public static final int PWM_REAR_RIGHT_DRIVE_MOTOR = 7;
	public static final int PWM_FRONT_LEFT_DRIVE_MOTOR = 8;
	public static final int PWM_REAR_LEFT_DRIVE_MOTOR = 9;
	public static final int ANALOG_IO_DRIVE_GYRO = 0;
	public static final int ANALOG_IO_DRIVE_ULTRASONIC = 1;

	// Scissor System Components
	public static final int CAN_CHANNELL_SCISSOR_EXTENSION = 0;
	public static final int CAN_CHANNELL_SCISSOR_LIFT = 1;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_OUT = 0;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_IN = 1;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_FORWARD_TILT = 2;
	public static final int DIGITAL_IO_SCISSOR_LIMIT_SWITCH_BACK_TILT = 3;

	// Lift System Components
	public static final int VICTOR_SP_LIFT = 2;
	public static final int DIGITAL_IO_LIFT_LIMIT_SWITCH_UP = 4;
	public static final int DIGITAL_IO_LIFT_LIMIT_SWITCH_DOWN = 5;
	public static final int DIGITAL_IO_LIFT_QUADRATURE_ENCODER_A = 6;
	public static final int DIGITAL_IO_LIFT_QUADRATURE_ENCODER_B = 7;

	// Gripper System Components
	public static final int CAN_CHANNEL_GRIP_OPEN_CLOSE = 3;
	public static final int ANALOG_IO_GRIP_POTENTIOMETER = 2;
	public static final int DIGITAL_IO_GRIP_LIMIT_SWITCH_OUTER_LIMIT = 8;
	public static final int DIGITAL_IO_GRIP_LIMIT_SWITCH_INNER_LIMIT = 9;

	// Autonomous drive constants
	public static final double AUTONOMOUS_DRIVE_FORWARD_SPEED = 0.3;
	public static final double AUTONOMOUS_DRIVE_REVERSE_SPEED = 0.3;
	public static final double AUTONOMOUS_DRIVE_TURN_RIGHT_SPEED = 0.3;
	public static final double AUTONOMOUS_DRIVE_TURN_LEFT_SPEED = 0.3;
	public static final double AUTONOMOUS_DRIVE_STRAFE_RIGHT_SPEED = 0.3;
	public static final double AUTONOMOUS_DRIVE_STRAFE_LEFT_SPEED = 1.0;
	// Autonomous distances to drive using ultrasonic
	public static final int AUTONOMOUS_DRIVE_FORWARD_DISTANCE_TO_CENTER = 2900;
	public static final int AUTONOMOUS_DRIVE_BACKWARD_DISTANCE_TO_CENTER = 2500;
	// Autonomous distance from tote to bin
	public static final int AUTONOMOUS_DRIVE_FORWARD_DISTANCE_TO_TOTE_FROM_CONTAINER = 80;
	
	// Autonomous lift speeds
	public static final double AUTONOMOUS_LIFT_UP_SPEED = 0.3;
	public static final double AUTONOMOUS_LIFT_DOWN_SPEED = 0.3;

	// Autonomous lift encoder values
	// TODO test the encoder
	public static final int AUTONOMOUS_LIFT_UP_ENCODER_VALUE = 1000;
	public static final int AUTONOMOUS_LIFT_DOWN_ENCODER_VALUE = 100;

	// Autonomous lift up time when encoder is not on robot
	public static final int AUTONOMOUS_LIFT_UP_TIME_VALUE = 1200;
	public static final int AUTONOMOUS_LIFT_DOWN_TIME_VALUE = 1000;
	
	// Autonomous grip potentiometer values for various close commands
	public static final int AUTONOMOUS_GRIP_POTENTIOMETER_CLOSED_VALUE_1 = 59;
	public static final int AUTONOMOUS_GRIP_POTENTIOMETER_CLOSED_VALUE_2 = 42;
	public static final int AUTONOMOUS_GRIP_POTENTIOMETER_CLOSED_VALUE_3 = 15;

	// set the value for the dead zone for the controller's
	public static final double GAMEPAD_DEADZONE = 0.2;
	
	// set the lowest value of the grip potentiometer to stop closing
	public static final double GRIP_POTENTIOMETER_CLOSE_VALUE = 0.8;
}
