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
	private final Encoder encoder;
	
	private final DigitalInput encoderA;
	private final DigitalInput encoderB;
	

	public LiftSystem() {
		// TODO Auto-generated constructor stub
		this.victorSP = new VictorSP(RobotMap.VICTOR_SP_LIFT);
		this.topSwitch = new DigitalInput(
				RobotMap.DIGITAL_IO_LIFT_LIMIT_SWITCH_UP);
		this.bottomSwitch = new DigitalInput(
				RobotMap.DIGITAL_IO_LIFT_LIMIT_SWITCH_DOWN);
		
		this.encoderA = new DigitalInput(RobotMap.DIGITAL_IO_LIFT_QUADRATURE_ENCODER_A);
		this.encoderB = new DigitalInput(RobotMap.DIGITAL_IO_LIFT_QUADRATURE_ENCODER_B);
		
		this.encoder = new Encoder(encoderA, encoderB, false, EncodingType.k4X);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public static LiftSystem getInstance() {
		return INSTANCE;
	}

	public void liftWithJoystick(Joystick joystick) {

	}

	public void liftUp() {
		if (!topLimit()) {
			this.victorSP.set(1.0);
		} else {
			this.victorSP.set(0.0);
		}
	}

	public void liftDown() {
		if (!bottomLimit()) {
			this.victorSP.set(-1.0);
		} else {
			this.victorSP.set(0.0);
		}
	}

	public void liftStop() {
		this.victorSP.set(0.0);
	}

	public boolean topLimit() {
		return !topSwitch.get();
	}

	public boolean bottomLimit() {
		return !bottomSwitch.get();
	}
	
	/**
	 * 
	 * @return the value of the encoder
	 */
	public double getEncoderValue() {
		return encoder.get();
	}

}
