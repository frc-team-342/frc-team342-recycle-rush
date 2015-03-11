package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSystem extends Subsystem {
	private static final LiftSystem INSTANCE = new LiftSystem();

	private final Talon talon;

	private final DigitalInput topSwitch;
	private final DigitalInput bottomSwitch;

	// The encoderA and encoderB variables make it easier to set up the encoder
	private final DigitalInput encoderA;
	private final DigitalInput encoderB;
	private final Encoder encoder;

	public LiftSystem() {
		// TODO motor temporaliy changed...
		talon = new Talon(RobotMap.VICTOR_SP_LIFT);
		topSwitch = new DigitalInput(RobotMap.DIGITAL_IO_LIFT_LIMIT_SWITCH_UP);
		bottomSwitch = new DigitalInput(
				RobotMap.DIGITAL_IO_LIFT_LIMIT_SWITCH_DOWN);

		encoderA = new DigitalInput(
				RobotMap.DIGITAL_IO_LIFT_QUADRATURE_ENCODER_A);
		encoderB = new DigitalInput(
				RobotMap.DIGITAL_IO_LIFT_QUADRATURE_ENCODER_B);
		// encoder order is reversed to make the encoder go up when the lift
		// goes up
		encoder = new Encoder(encoderB, encoderA, false, EncodingType.k4X);
	}

	@Override
	protected void initDefaultCommand() {

	}

	public static LiftSystem getInstance() {
		return INSTANCE;
	}

	/**
	 * @param joystick
	 *            specify the joy stick to use, we use the controller from OI.
	 */
	public void liftWithJoystick(Joystick joystick) {
		double up = joystick.getRawAxis(3);
		double down = (-1 * joystick.getRawAxis(2)) * 0.5;

		// combine the two value for greater control, this will not allow the
		// motor to move at values less than 20 percent of the motors capacity.
		double speed = (up + down) * 1.0;

		if (((speed >= RobotMap.GAMEPAD_DEADZONE) && topSwitch.get())
				|| ((speed <= -1.0 * RobotMap.GAMEPAD_DEADZONE) && bottomSwitch
						.get()))
			talon.set(speed);
		else
			talon.set(0);

		if (!bottomSwitch.get())
			encoder.reset();
	}

	/**
	 * Lift the lift!
	 */
	public void up() {
		if (!topLimit())
			talon.set(RobotMap.AUTONOMOUS_LIFT_UP_SPEED);
		else
			talon.set(0.0);
	}

	/**
	 * Lower the lift
	 */
	public void down() {
		if (!bottomLimit())
			talon.set(-1 * RobotMap.AUTONOMOUS_LIFT_DOWN_SPEED);
		else
			talon.set(0.0);
	}

	/**
	 * sets the lift speed to 0.0
	 */
	public void stop() {
		talon.set(0.0);
	}

	/**
	 * @return the value of the top limit switch
	 */
	public boolean topLimit() {
		return !topSwitch.get();
	}

	/**
	 * @return the value of the bottom limit switch
	 */
	public boolean bottomLimit() {
		return !bottomSwitch.get();
	}

	/**
	 * @return the value of the encoder
	 */
	public int getEncoderValue() {
		return encoder.get();
	}

	/**
	 * reset the encoder
	 */
	public void resetEncoder() {
		encoder.reset();
	}
}
