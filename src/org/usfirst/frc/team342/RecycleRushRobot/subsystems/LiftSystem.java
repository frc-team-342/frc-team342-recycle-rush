package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSystem extends Subsystem {
	private static final LiftSystem INSTANCE = new LiftSystem();
	private final VictorSP victorSP;

	private final DigitalInput topSwitch;
	private final DigitalInput bottomSwitch;

	private final DigitalInput encoderA;
	private final DigitalInput encoderB;
	private final Encoder encoder;

	public LiftSystem() {
		victorSP = new VictorSP(RobotMap.VICTOR_SP_LIFT);

		topSwitch = new DigitalInput(RobotMap.DIGITAL_IO_LIFT_LIMIT_SWITCH_UP);
		bottomSwitch = new DigitalInput(
				RobotMap.DIGITAL_IO_LIFT_LIMIT_SWITCH_DOWN);

		encoderA = new DigitalInput(
				RobotMap.DIGITAL_IO_LIFT_QUADRATURE_ENCODER_A);
		encoderB = new DigitalInput(
				RobotMap.DIGITAL_IO_LIFT_QUADRATURE_ENCODER_B);
		encoder = new Encoder(encoderA, encoderB, false, EncodingType.k4X);
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
		double down = -1 * joystick.getRawAxis(2);
		
		// combine the two value for greater control, this will not allow the
		// motor to move at values less than 20 percent of the motors capacity.
		double speed = up + down;

		if (((speed >= RobotMap.GAMEPAD_DEADZONE) && topSwitch.get())
				|| ((speed <= (-1.0 * RobotMap.GAMEPAD_DEADZONE)) && bottomSwitch.get()))
			victorSP.set(speed);
		else
			victorSP.set(0);
	}

	public void up() {
		if (!topLimit())
			victorSP.set(RobotMap.AUTONOMOUS_LIFT_UP_SPEED);
		else
			victorSP.set(0.0);

	}

	public void down() {
		if (!bottomLimit())
			victorSP.set(-1 * RobotMap.AUTONOMOUS_LIFT_DOWN_SPEED);
		else
			victorSP.set(0.0);
	}

	/**
	 * sets the lift speed to 0.0
	 */
	public void stop() {
		victorSP.set(0.0);
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
}
