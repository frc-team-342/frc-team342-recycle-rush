package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase;
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

	// lift speed needs to be modified to be
	private final double LIFT_SPEED = 0.3;
	private final double DEFAULT_GAMEPAD_DEADZONE = 0.01;

	public LiftSystem() {
		// TODO Auto-generated constructor stub
		this.victorSP = new VictorSP(RobotMap.VICTOR_SP_LIFT);

		this.topSwitch = new DigitalInput(
				RobotMap.DIGITAL_IO_LIFT_LIMIT_SWITCH_UP);
		this.bottomSwitch = new DigitalInput(
				RobotMap.DIGITAL_IO_LIFT_LIMIT_SWITCH_DOWN);
		this.encoderA = new DigitalInput(
				RobotMap.DIGITAL_IO_LIFT_QUADRATURE_ENCODER_A);
		this.encoderB = new DigitalInput(
				RobotMap.DIGITAL_IO_LIFT_QUADRATURE_ENCODER_B);
		this.encoder = new Encoder(encoderA, encoderB, false, EncodingType.k4X);

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public static LiftSystem getInstance() {
		return INSTANCE;
	}

	/**
	 * 
	 * @param joystick
	 *            specify the joy stick to use, we use assist joy stick in OI
	 */
	public void liftWithJoystick(Joystick joystick) {
		double up = joystick.getRawAxis(3);
		double down = -1 * joystick.getRawAxis(2);
		double speed = up + down;
		if (Math.abs(speed) > DEFAULT_GAMEPAD_DEADZONE)
			victorSP.set(up + down);
		else 
			victorSP.set(0);
	}

	public void liftUp() {
		if (!topLimit()) {
			this.victorSP.set(LIFT_SPEED);
		} else {
			this.victorSP.set(0.0);
		}
	}

	public void liftDown() {
		if (!bottomLimit()) {
			this.victorSP.set(-1 * LIFT_SPEED);
		} else {
			this.victorSP.set(0.0);
		}
	}

	/**
	 * sets the lift speed to 0.0
	 */
	public void liftStop() {
		this.victorSP.set(0.0);
	}

	/**
	 * 
	 * @return the value of the top limit switch
	 */
	public boolean topLimit() {
		return topSwitch.get();
	}

	/**
	 * 
	 * @return the value of the bottom limit switch (maybe inverted?)
	 */
	public boolean bottomLimit() {
		return bottomSwitch.get();
	}

	/**
	 * 
	 * @return the value of the encoder
	 */
	public double getEncoderValue() {
		return encoder.get();
	}
}
