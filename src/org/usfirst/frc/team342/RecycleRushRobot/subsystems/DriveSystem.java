package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveWithJoystick;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.can.CANMessageNotFoundException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANJaguar;
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
	private boolean mode;

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
		mode = true;
	}

	public void initDefaultCommand() {
		// this.setDefaultCommand(new DriveWithJoystick());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void driveWithJoystick(Joystick joystick) {
		// makes joystick drive run with exponential acceleration, rather than
		// linear
		// this should smooth out the drive
		double power = joystick.getThrottle();
		double multiplier = (((10 * power) * (10 * power)) / 100);

		double x = joystick.getX() * multiplier;
		double y = joystick.getY() * multiplier;
		double rotation = joystick.getZ() * multiplier;
		double angle = 0.0;

		this.robotDrive.mecanumDrive_Cartesian(x, y, rotation, angle);
		// CANJaguar.updateSyncGroup((byte) 0x80);
	}

	public void fieldOrientedJoystick(Joystick joystick) {
		double x = joystick.getX();
		double y = joystick.getY();
		double rotation = joystick.getZ();
		double angle = 0.0;
		// To DO Get Gyro Angle From Sensors
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
		this.robotDrive.mecanumDrive_Polar(0.0, 0.0, speed);
	}
}
