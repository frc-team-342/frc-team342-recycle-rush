package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.OI;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.ScissorSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveFasterWithJoystick extends Command {

	private Joystick joystick;
	private Joystick controller;

	private DriveSystem drive = DriveSystem.getInstance();
	private LiftSystem lift = LiftSystem.getInstance();
	private ScissorSystem scissor = ScissorSystem.getInstance();

	public DriveFasterWithJoystick() {
		// TODO Auto-generated constructor stub
	}

	public DriveFasterWithJoystick(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public DriveFasterWithJoystick(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}

	public DriveFasterWithJoystick(String name, double timeout) {
		super(name, timeout);
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
		// TODO Auto-generated method stub
		return false;
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
