package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ScissorSystem extends Subsystem {
	private static final ScissorSystem INSTANCE = new ScissorSystem();
	private final Compressor compressor;
	private final Solenoid solenoid;
	private final Talon talon;
	private final DigitalInput scissorOn;
	private final DigitalInput scissorOff;
	private final DigitalInput scissorExtended;
	private final DigitalInput scissorRetracted;
	
	private final double DEFAULT_SCISSOR_EXTEND_SPEED = 0.7;

	public ScissorSystem() {
		// TODO Auto-generated constructor stub
		compressor = new Compressor(0);
		solenoid = new Solenoid(0);
		talon = new Talon(2);
		compressor.setClosedLoopControl(true);
		this.scissorOff = new DigitalInput(3);
		this.scissorOn = new DigitalInput(2);
		this.scissorExtended = new DigitalInput(0);
		this.scissorRetracted = new DigitalInput(1);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public static ScissorSystem getInstance() {
		return INSTANCE;
	}

	public void on() {
		solenoid.set(true);
	}

	public void off() {
		solenoid.set(false);
	}

	public void extend() {
		talon.set(DEFAULT_SCISSOR_EXTEND_SPEED);
	}

	public void retract() {
		talon.set(-1 * DEFAULT_SCISSOR_EXTEND_SPEED);
	}

	public void stop() {
		talon.set(0.0);
	}

	public boolean isUp() {
		return !scissorOn.get();
	}

	public boolean isDown() {
		return !scissorOff.get();
	}

	public boolean isExtended() {
		return !scissorExtended.get();
	}

	public boolean isRetracted() {
		return !scissorExtended.get();
	}

}
