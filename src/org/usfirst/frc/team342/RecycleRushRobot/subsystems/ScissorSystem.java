package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ScissorSystem extends Subsystem {
	private static final ScissorSystem INSTANCE = new ScissorSystem();
	private final Talon extendTalon;
	private final Talon liftTalon;
	private final DigitalInput scissorTiltOut;
	private final DigitalInput scissorTiltIn;
	private final DigitalInput scissorExtended;
	private final DigitalInput scissorRetracted;

	private final double DEFAULT_SCISSOR_EXTEND_SPEED = 1.0;
	private final double DEFAULT_SCISSOR_LIFT_SPEED = 1.0;
	private final double DEFAULT_GAMEPAD_DEADZONE = 0.01;

	public ScissorSystem() {
		// TODO Auto-generated constructor stub
		this.extendTalon = new Talon(RobotMap.CAN_CHANNELL_SCISSOR_EXTENSION);
		this.liftTalon = new Talon(RobotMap.CAN_CHANNELL_SCISSOR_LIFT);
		this.scissorExtended = new DigitalInput(
				RobotMap.DIGITAL_IO_SCISSOR_LIMIT_SWITCH_OUT);
		this.scissorRetracted = new DigitalInput(
				RobotMap.DIGITAL_IO_SCISSOR_LIMIT_SWITCH_IN);
		this.scissorTiltOut = new DigitalInput(
				RobotMap.DIGITAL_IO_SCISSOR_LIMIT_SWITCH_FORWARD_TILT);
		this.scissorTiltIn = new DigitalInput(
				RobotMap.DIGITAL_IO_SCISSOR_LIMIT_SWITCH_BACK_TILT);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public static ScissorSystem getInstance() {
		return INSTANCE;
	}

	public void scissorWithJoystick(Joystick joystick) {
		double right = joystick.getRawAxis(0);
		double up = -1 * joystick.getRawAxis(1);
		
		if (Math.abs(right) > DEFAULT_GAMEPAD_DEADZONE)
			extendTalon.set(right);
		else {
			extendTalon.set(0.0);
		}
		if (Math.abs(up) > DEFAULT_GAMEPAD_DEADZONE)
			liftTalon.set(up);
		else {
			liftTalon.set(0.0);
		}
	}

	public void extend() {
		extendTalon.set(DEFAULT_SCISSOR_EXTEND_SPEED);
	}

	public void retract() {
		extendTalon.set(-1 * DEFAULT_SCISSOR_EXTEND_SPEED);
	}

	public void up() {
		liftTalon.set(DEFAULT_SCISSOR_LIFT_SPEED);
	}

	public void down() {

		liftTalon.set(-1 * DEFAULT_SCISSOR_LIFT_SPEED);
	}

	public void stop() {
		extendTalon.set(0.0);
		liftTalon.set(0.0);
	}

	public boolean isUp() {
		return !scissorTiltOut.get();
	}

	public boolean isDown() {
		return !scissorTiltIn.get();
	}

	public boolean isExtended() {
		return !scissorExtended.get();
	}

	public boolean isRetracted() {
		return !scissorRetracted.get();
	}

}
