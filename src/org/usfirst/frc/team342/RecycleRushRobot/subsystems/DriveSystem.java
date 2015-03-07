package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary;

public class DriveSystem extends Subsystem {

	// Declare Drive System objects
	private static final DriveSystem INSTANCE = new DriveSystem();

	private final RobotDrive robotDrive;
	private final Jaguar frontLeftjaguar;
	private final Jaguar rearLeftjaguar;
	private final Jaguar frontRightjaguar;
	private final Jaguar rearRightjaguar;
	private final Gyro gyro;
	private final AnalogInput ultrasonic;
	private double InverseDrive;

	// slows down the drive for better control
	private final double driveHandicap = 1.0;

	// Variable to store the drive mode (field oriented or robot oriented)
	private boolean mode;

	// Variable to set the speed mode
	private boolean slow;

	public long gyroInitStartTime;

	// Initialize the drive objects
	private DriveSystem() {
		super();

		// Initialize the
		frontLeftjaguar = new Jaguar(RobotMap.PWM_FRONT_LEFT_DRIVE_MOTOR);
		rearLeftjaguar = new Jaguar(RobotMap.PWM_REAR_LEFT_DRIVE_MOTOR);
		frontRightjaguar = new Jaguar(RobotMap.PWM_FRONT_RIGHT_DRIVE_MOTOR);
		rearRightjaguar = new Jaguar(RobotMap.PWM_REAR_RIGHT_DRIVE_MOTOR);

		robotDrive = new RobotDrive(frontLeftjaguar, rearLeftjaguar,
				frontRightjaguar, rearRightjaguar);

		gyro = new Gyro(RobotMap.ANALOG_IO_DRIVE_GYRO);
		ultrasonic = new AnalogInput(RobotMap.ANALOG_IO_DRIVE_ULTRASONIC);

		// TODO the gyro does not work correctly
		// initiate the gyro
		// gyro.initGyro();
		gyroInitStartTime = System.currentTimeMillis() - 10000;
		FRCNetworkCommunicationsLibrary
				.HALSetErrorData("The gyro is initializing" + "\n"
						+ "DO NOT TOUCH THE ROBOT!!!" + "\n");

		// Set the safety to not print line annoying print lines
		robotDrive.setSafetyEnabled(false);

		// inverts the motors, because they have to be inverted
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);

		mode = false;
		slow = false;
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
		double rotation = joystick.getZ() * driveHandicap;
		if (mode) {
			double angle = gyro.getAngle();
			robotDrive.mecanumDrive_Cartesian(x, y, rotation, angle);
		} else
			robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0);
	}

	/**
	 * Inverts the drive mode, used for switching between field oriented and
	 * robot oriented
	 */
	public void changeMode() {
		mode = !mode;
	}

	/**
	 * Drive forward at the given speed.
	 * 
	 * @param speed
	 *            The speed to drive forward at
	 */
	public void forward(double speed) {
		robotDrive.mecanumDrive_Cartesian(0.0, -1 * speed, 0.0, 0.0);
	}

	/**
	 * Drive backward at the given speed.
	 * 
	 * @param speed
	 *            The speed to drive backward at
	 */
	public void reverse(double speed) {
		robotDrive.mecanumDrive_Cartesian(0.0, -1.0 * speed, 0.0, 0.0);
	}

	/**
	 * drive the robot right without turning
	 * 
	 * @param speed
	 *            The speed to strafe left at
	 */
	public void strafeRight(double speed) {
		robotDrive.mecanumDrive_Cartesian(1.0 * speed, 0.0, 0.0, 0.0);
	}

	/**
	 * drive the robot left without turning
	 * 
	 * @param speed
	 *            The speed to strafe right at
	 */
	public void strafeLeft(double speed) {
		robotDrive.mecanumDrive_Cartesian(-1.0 * speed, 0.0, 0.0,
				0.0);
	}

	/**
	 * set the robot speed to 0
	 */
	public void stop() {
		robotDrive.mecanumDrive_Polar(0.0, 0.0, 0.0);
	}

	/**
	 * turn the robot at the given speed
	 * 
	 * @param speed
	 *            a value from -1.0 to 1.0 for speed of the robot turn
	 */
	public void turn(double speed) {
		robotDrive.mecanumDrive_Cartesian(0, 0, speed, 0);
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
	 * change the drive speed for better control
	 */
	public void toggleSpeed() {
		// toggle the slow setting
		slow = !slow;
		if (slow)
			// if the new value is slow set the max output slow
			robotDrive.setMaxOutput(0.48);
		else
			// if the new value is not slow set the max output to not slow
			robotDrive.setMaxOutput(1.0);
	}

	public void inverseDrive() {
		InverseDrive *= -1.0;
	}

	@Override
	protected void initDefaultCommand() {

	}
}
