package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary;

public class DriveSystem extends Subsystem {

	// Declare Drive System objects
	private static final DriveSystem INSTANCE = new DriveSystem();

	private final RobotDrive robotDrive;
	private final Jaguar frontLeftJaguar;
	private final Jaguar rearLeftJaguar;
	private final Jaguar frontRightJaguar;
	private final Jaguar rearRightJaguar;
	private final Gyro gyro;
	private final AnalogInput ultrasonic;
	private double InverseDrive;

	// slows down the drive for better control
	private final double ROTATION_HANDICAP = 1.0;
	private final double DRIVE_DEAD_ZONE_MAX = 0.15;
	private final double DRIVE_DEAD_ZONE_MIN = 0.05;

	// Variable to set the speed mode
	private boolean slow;

	public long gyroInitStartTime;

	// Initialize the drive objects
	private DriveSystem() {
		super();

		// Initialize the
		frontLeftJaguar = new Jaguar(RobotMap.PWM_FRONT_LEFT_DRIVE_MOTOR);
		rearLeftJaguar = new Jaguar(RobotMap.PWM_REAR_LEFT_DRIVE_MOTOR);
		frontRightJaguar = new Jaguar(RobotMap.PWM_FRONT_RIGHT_DRIVE_MOTOR);
		rearRightJaguar = new Jaguar(RobotMap.PWM_REAR_RIGHT_DRIVE_MOTOR);

		robotDrive = new RobotDrive(frontLeftJaguar, rearLeftJaguar,
				frontRightJaguar, rearRightJaguar);

		gyro = new Gyro(RobotMap.ANALOG_IO_DRIVE_GYRO);
		ultrasonic = new AnalogInput(RobotMap.ANALOG_IO_DRIVE_ULTRASONIC);

		// initiate the gyro
		gyro.initGyro();
		gyroInitStartTime = System.currentTimeMillis();
		FRCNetworkCommunicationsLibrary
				.HALSetErrorData("The gyro is initializing" + "\n"
						+ "DO NOT TOUCH THE ROBOT!!!" + "\n");

		// Set the safety to not print line annoying print lines
		robotDrive.setSafetyEnabled(false);

		// inverts the motors, because they have to be inverted
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);

		slow = false;
		// Set the robot to drive straight, a value of -1 will inverse the drive
		InverseDrive = 1.0;
	}

	public static DriveSystem getInstance() {
		return INSTANCE;
	}

	/**
	 * Drive using the joy stick axes
	 * 
	 * @param joystick
	 *            The drive joy stick from the OI
	 */
	public void driveWithJoystick(Joystick joystick) {
		// set drive variables
		double x = joystick.getX() * InverseDrive;
		double y = joystick.getY() * InverseDrive;
		double rotation = joystick.getZ() * ROTATION_HANDICAP;
		double combined = x + y + rotation;

		// Drive the robot
		// This is the only non field-oriented drive function
		if (combined > DRIVE_DEAD_ZONE_MAX || combined < DRIVE_DEAD_ZONE_MAX)
			robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0.0);
		else
			robotDrive.mecanumDrive_Cartesian(0.0, 0.0, 0.0, 0.0);
	}

	/**
	 * Drive forward at the given speed.
	 * 
	 * @param speed
	 *            A value from -1.0 to 1.0 for speed of drive forward
	 */
	public void forward(double speed) {
		robotDrive.mecanumDrive_Cartesian(0.0, -1.0 * speed, 0.0,
				gyro.getAngle());
	}

	/**
	 * Drive backward at the given speed.
	 * 
	 * @param speed
	 *            A value from -1.0 to 1.0 for speed of drive backward
	 */
	public void reverse(double speed) {
		// I think this has to be negative 1 because the drive is intended for
		// joy stick

		robotDrive.mecanumDrive_Cartesian(0.0, -1.0 * speed, 0.0,
				gyro.getAngle());
	}

	/**
	 * Drive the robot right without turning
	 * 
	 * @param speed
	 *            A value from -1.0 to 1.0 for speed of strafe left
	 */
	public void strafeRight(double speed) {
		robotDrive.mecanumDrive_Cartesian(1.0 * speed, 0.0, 0.0,
				gyro.getAngle());
	}

	/**
	 * Drive the robot left without turning
	 * 
	 * @param speed
	 *            A value from -1.0 to 1.0 for speed of strafe right
	 */
	public void strafeLeft(double speed) {
		robotDrive.mecanumDrive_Cartesian(-1.0 * speed, 0.0, 0.0,
				gyro.getAngle());
	}

	/**
	 * Turn the robot at the given speed
	 * 
	 * @param speed
	 *            A value from -1.0 to 1.0 for speed of the robot turn
	 */
	public void turn(double speed) {
		robotDrive.mecanumDrive_Cartesian(0, 0, speed, gyro.getAngle());
	}

	/**
	 * Set the robot speed to 0
	 */
	public void stop() {
		robotDrive.mecanumDrive_Polar(0.0, 0.0, 0.0);
	}

	/**
	 * @return the gyro output
	 */
	public double getAngle() {
		return gyro.getAngle();
	}

	/**
	 * @return the ultrasonic value
	 */
	public int getDistance() {
		return ultrasonic.getValue();
	}

	/**
	 * set the current gyro heading to 0
	 */
	public void resetGyro() {
		gyro.reset();
	}

	/**
	 * change the drive speed for slower speed and better control
	 */
	public void toggleSlow() {
		// toggle the slow setting
		slow = !slow;
		if (slow)
			// If the new value is slow set the max output slow
			robotDrive.setMaxOutput(0.48);
		else
			// Or else if the new value is not slow set the max output to not
			// slow
			robotDrive.setMaxOutput(1.0);
	}

	/**
	 * Inverse the drive speed by multiplying it by negative 1
	 */
	public void inverseDrive() {
		InverseDrive *= -1.0;
	}

	@Override
	protected void initDefaultCommand() {

	}
}
