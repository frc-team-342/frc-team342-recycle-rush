
package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveWithJoystick;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.can.CANMessageNotFoundException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class DriveSystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private static final DriveSystem INSTANCE = new DriveSystem();
	private final CANJaguar frontLeftjaguar;
	private final CANJaguar rearLeftjaguar;
	private final CANJaguar frontRightjaguar;
	private final CANJaguar rearRightjaguar;
	private final RobotDrive robotDrive;
	private final Gyro gyro;
	private final AnalogInput ultrasonic;
	
	private boolean mode;
	private double direction;

	private DriveSystem() {
		super();
		System.out.println("Drive System Initialized!");
		// try{

		this.frontLeftjaguar = new CANJaguar(
				RobotMap.CAN_CHANNEL_LEFT_FRONT_DRIVE_MOTOR);
		this.rearLeftjaguar = new CANJaguar(
				RobotMap.CAN_CHANNEL_LEFT_BACK_DRIVE_MOTOR);
		this.frontRightjaguar = new CANJaguar(
				RobotMap.CAN_CHANNEL_RIGHT_FRONT_DRIVE_MOTOR);
		this.rearRightjaguar = new CANJaguar(
				RobotMap.CAN_CHANNEL_RIGHT_BACK_DRIVE_MOTOR);
		// }
		// catch(CANMessageNotFoundException ex){
		// System.out.println("ERROR"+ex.getMessage());
		// }
		robotDrive = new RobotDrive(frontLeftjaguar, rearLeftjaguar,
				frontRightjaguar, rearRightjaguar);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		// invert's the left motors /\ & \/
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		
		this.gyro = new Gyro(RobotMap.ANALOG_IO_DRIVE_GYRO);
		this.ultrasonic = new AnalogInput(RobotMap.ANALOG_IO_DRIVE_ULTRASONIC);
		
		mode = true;
		
	}

	public void initDefaultCommand() {
		// this.setDefaultCommand(new DriveWithJoystick());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void driveWithJoystick(Joystick joystick) {
		// makes joystick drive run with exponential acceleration, rather than
		// this should smooth out the drive
		double multiplier = (-joystick.getThrottle() + 1) / 2;
		double x = (10 * joystick.getX() ) *(10 * joystick.getX() ) * (10 * joystick.getX() ) * multiplier / 1000;
		double y = (10 * joystick.getY() ) *(10 * joystick.getY() ) * (10 * joystick.getY() ) * multiplier / 1000;
		double rotation = joystick.getZ() * multiplier;
		double angle = gyro.getAngle();
		
		this.robotDrive.mecanumDrive_Cartesian(x, y, rotation, angle);
		// CANJaguar.updateSyncGroup((byte) 0x80);
	}

	public void fieldOrientedJoystick(Joystick joystick) {
		double x = joystick.getX();
		double y = joystick.getY();
		double rotation = joystick.getZ();
		double angle = 0.0;
		
		// TODO Get Gyro Angle From Sensors
		if (mode) {
			this.robotDrive.mecanumDrive_Cartesian(x, y, rotation, angle);
		} else {
			this.robotDrive.mecanumDrive_Cartesian(0, 0, rotation, angle);
		}
		// CANJaguar.updateSyncGroup((byte) 0x80);
		System.out.println("Field Oriented Joystick Enabled!");
	}

	public void changeMode() {
		//inverts the drive mode
		mode = !mode;
	}

	public static DriveSystem getInstance() {
		return INSTANCE;
	}

	public void forward(double speed) {
		this.robotDrive.mecanumDrive_Polar(speed, 1.0, 0.0);
	}

	public void reverse(double speed) {
		this.robotDrive.mecanumDrive_Polar(speed, -1.0, 0.0);
	}

	public void stop() {
		this.robotDrive.mecanumDrive_Polar(0.0, 0.0, 0.0);
	}

	public void turn(double speed) {
		//this.robotDrive.mecanumDrive_Polar(0.0, 0.0, speed);
		System.out.println("Turning Right");
		this.robotDrive.mecanumDrive_Cartesian(0, 0, speed, 0);
		
	}
	
	public double getAngle() {
		return gyro.getAngle();
	}
	
	public double getDistance() {
		return ultrasonic.getValue();
	}
}
