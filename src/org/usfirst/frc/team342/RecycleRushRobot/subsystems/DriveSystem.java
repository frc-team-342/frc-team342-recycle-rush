package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {

	// Declare Drive System objects
	private static final DriveSystem INSTANCE = new DriveSystem();

	private final RobotDrive robotDrive;
	private final CANJaguar frontLeftjaguar;
	private final CANJaguar rearLeftjaguar;
	private final CANJaguar frontRightjaguar;
	private final CANJaguar rearRightjaguar;
	private final Gyro gyro;
	private final AnalogInput ultrasonic;

	// slows down the drive for better control
	private final double driveHandicap = 0.45;

	// Variable to store the drive mode (field oriented or robot oriented)
	private boolean mode;

	// Variable to set the speed mode
	private boolean slow;

	// Initialize the drive objects
	private DriveSystem() {
		super();

		// Initialize the
		this.frontLeftjaguar = new CANJaguar(
				RobotMap.CAN_CHANNEL_LEFT_FRONT_DRIVE_MOTOR);
		this.rearLeftjaguar = new CANJaguar(
				RobotMap.CAN_CHANNEL_LEFT_BACK_DRIVE_MOTOR);
		this.frontRightjaguar = new CANJaguar(
				RobotMap.CAN_CHANNEL_RIGHT_FRONT_DRIVE_MOTOR);
		this.rearRightjaguar = new CANJaguar(
				RobotMap.CAN_CHANNEL_RIGHT_BACK_DRIVE_MOTOR);

		this.robotDrive = new RobotDrive(frontLeftjaguar, rearLeftjaguar,
				frontRightjaguar, rearRightjaguar);

		this.gyro = new Gyro(RobotMap.ANALOG_IO_DRIVE_GYRO);
		this.ultrasonic = new AnalogInput(RobotMap.ANALOG_IO_DRIVE_ULTRASONIC);

		this.gyro.initGyro();

		// Set the safety to not print line annoying print lines
		robotDrive.setSafetyEnabled(false);

		// inverts the motors, because they have to be inverted
		this.robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		this.robotDrive.setInvertedMotor(MotorType.kFrontRight, true);

		this.mode = true;
		this.slow = false;

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
		double x = joystick.getX();
		double y = joystick.getY();
		double rotation = joystick.getZ() * driveHandicap;
		if (mode) {
			double angle = gyro.getAngle();
			this.robotDrive.mecanumDrive_Cartesian(x, y, rotation, angle);
		} else
			this.robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0);
	}

	/**
	 * Inverts the drive mode, used for switching between field oriented and
	 * robot oriented
	 */
	public void changeMode() {
		mode = !mode;
	}

	/**
	 * Drive forward at the given speed. To drive backward use a negative speed.
	 * 
	 * @param speed
	 *            The speed to drive forward at
	 */
	// TODO Should this use the gyro?
	public void forward(double speed) {
		this.robotDrive.mecanumDrive_Cartesian(0.0, -1 * speed, 0.0, 0.0);
	}

	/**
	 * Drive forward at the given speed. To drive backward use a negative speed.
	 * 
	 * @param speed
	 *            The speed to drive backward at, this can be negative to go
	 *            backwards
	 */
	public void reverse(double speed) {
		this.robotDrive.mecanumDrive_Cartesian(0.0, -1.0 * speed, 0.0, 0.0);
	}

	/**
	 * set the robot speed to 0
	 */
	public void stop() {
		this.robotDrive.mecanumDrive_Polar(0.0, 0.0, 0.0);
	}

	/**
	 * turn the robot at the given speed
	 * 
	 * @param speed
	 *            a value from -1.0 to 1.0 for speed of the robot turn
	 */
	public void turn(double speed) {
		this.robotDrive.mecanumDrive_Cartesian(0, 0, speed, 0);
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

	@Override
	protected void initDefaultCommand() {

	}
}
