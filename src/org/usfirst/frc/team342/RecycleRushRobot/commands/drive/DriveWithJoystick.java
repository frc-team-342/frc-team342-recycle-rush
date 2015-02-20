package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.OI;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.ScissorSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command {

	private Joystick joystick;
	private Joystick controller;

	private DriveSystem drive = DriveSystem.getInstance();
	private LiftSystem lift = LiftSystem.getInstance();
	private ScissorSystem scissor = ScissorSystem.getInstance();

	public DriveWithJoystick() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		OI oi = OI.getInstance();
		this.joystick = oi.getJoystick();
		this.controller = oi.getController();
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		drive.driveWithJoystick(joystick);
		lift.liftWithJoystick(controller);
		scissor.scissorWithJoystick(controller);
		// TODO Auto-generated method stub
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
	/**
	 * This stops all of the systems attached to the joy stick. This will only be
	 * called if the drive with joy stick is interrupted
	 */
	@Override
	protected void end() {
		drive.stop();
		lift.stop();
		scissor.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
 