package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.OI;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.ScissorSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ReadDebug extends Command {

	private DriveSystem drive;
	private LiftSystem lift;
	private GripSystem grip;
	private ScissorSystem scissor;

	public ReadDebug() {
		drive = DriveSystem.getInstance();
		lift = LiftSystem.getInstance();
		grip = GripSystem.getInstance();
		scissor = ScissorSystem.getInstance();
		// TODO Auto-generated constructor stub
	}

	public ReadDebug(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public ReadDebug(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public ReadDebug(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// drive.testGyro();
		// TODO Auto-generated method stub
		System.out.println("Drive System " + "\t" + "Ultrasonic: "
				+ drive.getDistance() + "\t" + "Gyro: " + drive.getAngle());

		System.out.println("GripSystem " + "\t" + "Ultrasonic: "
				+ grip.getUltrasonic() + "\t" + "Potentiometer "
				+ grip.getPotentiometer());
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
