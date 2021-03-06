package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
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

	public ScissorSystem() {
		extendTalon = new Talon(RobotMap.CAN_CHANNELL_SCISSOR_EXTENSION);
		liftTalon = new Talon(RobotMap.CAN_CHANNELL_SCISSOR_LIFT);
		scissorExtended = new DigitalInput(
				RobotMap.DIGITAL_IO_SCISSOR_LIMIT_SWITCH_OUT);
		scissorRetracted = new DigitalInput(
				RobotMap.DIGITAL_IO_SCISSOR_LIMIT_SWITCH_IN);
		scissorTiltOut = new DigitalInput(
				RobotMap.DIGITAL_IO_SCISSOR_LIMIT_SWITCH_FORWARD_TILT);
		scissorTiltIn = new DigitalInput(
				RobotMap.DIGITAL_IO_SCISSOR_LIMIT_SWITCH_BACK_TILT);
	}

	@Override
	protected void initDefaultCommand() {

	}

	public static ScissorSystem getInstance() {
		return INSTANCE;
	}

	public void scissorWithJoystick(Joystick joystick) {

		double right = joystick.getRawAxis(0);
		// The joy stick is inverted on the y axis
		double up = -1.0 * joystick.getRawAxis(1);

		// The limit switch is inverted
		//
		// The giant test condition tests many things. The first half is for
		// moving the scissor up if the joy stick is positive, the second half
		// is a symmetrical condition for moving the scissor down. For each, it
		// first tests if the joy stick is greater than the dead zone, then it
		// tests if the scissor is already at its limit switches.
		if (((right > RobotMap.GAMEPAD_DEADZONE) && scissorExtended.get())
				|| ((right < -1.0 * RobotMap.GAMEPAD_DEADZONE) && scissorRetracted
						.get()))
			extendTalon.set(right);
		else
			extendTalon.set(0.0);

		// The limit switch is inverted
		//
		// The giant test condition tests many things. The first half is for
		// extending the scissor if the joy stick is positive, the second half
		// is a symmetrical condition for retracting the scissor. For each it
		// first tests if the joy stick is greater than the dead zone, then it
		// tests if the scissor is already at its limit switches.
		if (((up > RobotMap.GAMEPAD_DEADZONE) && scissorTiltOut.get())
				|| ((up < -1.0 * RobotMap.GAMEPAD_DEADZONE) && scissorTiltIn
						.get()))
			liftTalon.set(up);
		else
			liftTalon.set(0.0);
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
