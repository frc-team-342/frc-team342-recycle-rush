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
	public static final int ANALOG_IO_GRIP_FRONT_COLLISION = 3;
	public static final int DIGITAL_IO_GRIP_LIMIT_SWITCH_OUTER_LIMIT = 8;
	public static final int DIGITAL_IO_GRIP_LIMIT_SWITCH_INNER_LIMIT = 9;

	// Autonomous drive constants
	public static final double AUTONOMOUS_DRIVE_FORWARD_SPEED = 0.3;
	public static final double AUTONOMOUS_DRIVE_REVERSE_SPEED = 0.3;
	public static final double AUTONOMOUS_DRIVE_STRAFE_RIGHT_SPEED = 0.3;
	public static final double AUTONOMOUS_DRIVE_STRAFE_LEFT_SPEED = 1.0;
	// TODO master the rotation speeds, there is a compromise between speed and
	// accuracy
	public static final double AUTONOMOUS_DRIVE_ROTATE_RIGHT_SPEED = 0.3;
	public static final double AUTONOMOUS_DRIVE_ROTATE_LEFT_SPEED = 0.5;

	// Autonomous rotation angle constants
	public static final int AUTONOMOUS_DRIVE_ROTATE_RIGHT_ANGLE = 77;
	public static final int AUTONOMOUS_DRIVE_ROTATE_LEFT_ANGLE = 77;

	// Autonomous distances to drive using ultrasonic
	public static final int AUTONOMOUS_DRIVE_FORWARD_DISTANCE_TO_CENTER = 1900;
	// Autonomous distance from tote to bin
	public static final int AUTONOMOUS_DRIVE_FORWARD_DISTANCE_TO_TOTE_FROM_CONTAINER = 80;
	// Autonomous time to drive if there is no way to detect a tote in the front
	public static final int AUTONOMOUS_DRIVE_FORWARD_TIME_BETWEEN_TOTES = 300;

	// Autonomous lift speeds
	public static final double AUTONOMOUS_LIFT_UP_SPEED = 1.0;
	public static final double AUTONOMOUS_LIFT_DOWN_SPEED = 0.6;

	// TODO figure out good encoder values for various tasks such as lifting to
	// the height of one tote, two totes and three totes
	// Autonomous lift encoder values
	public static final int AUTONOMOUS_LIFT_UP_ENCODER_VALUE = 2000;
	public static final int AUTONOMOUS_LIFT_DOWN_ENCODER_VALUE = 100;

	// Autonomous lift to relative values
	public static final int AUTONOMOUS_LIFT_UP_RELATIVE_ENCODER_VALUE = 50;
	public static final int AUTONOMOUS_LIFT_DOWN_RELATIVE_ENCODER_VALUE = 50;

	// Autonomous lift times when encoder is not on robot
	public static final int AUTONOMOUS_LIFT_UP_TIME_VALUE = 1200;
	public static final int AUTONOMOUS_LIFT_DOWN_TIME_VALUE = 1000;

	// Set the value for the dead zone for the controllers
	public static final double GAMEPAD_DEADZONE = 0.2;

	// Grip potentiometer values for various close commands
	public static final int GRIP_POTENTIOMETER_CLOSED_VALUE_1 = 180;
	public static final int GRIP_POTENTIOMETER_CLOSED_VALUE_2 = 443;
	public static final int GRIP_POTENTIOMETER_CLOSED_VALUE_3 = 650;

	// Grip speed
	public static final double GRIP_SPEED = 0.9;
}
