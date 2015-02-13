package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ScissorSystem extends Subsystem {
	private static final ScissorSystem INSTANCE = new ScissorSystem();
	private final Talon talon;
	private final DigitalInput scissorTiltOut;
	private final DigitalInput scissorTiltIn;
	private final DigitalInput scissorExtended;
	private final DigitalInput scissorRetracted;
	
	private final double DEFAULT_SCISSOR_EXTEND_SPEED = 0.7;

	public ScissorSystem() {
		// TODO Auto-generated constructor stub
		talon = new Talon(RobotMap.CAN_CHANNELL_SCISSOR_EXTENSION);
		this.scissorExtended = new DigitalInput(RobotMap.DIGITAL_IO_SCISSOR_LIMIT_SWITCH_OUT);
		this.scissorRetracted = new DigitalInput(RobotMap.DIGITAL_IO_SCISSOR_LIMIT_SWITCH_IN);
		this.scissorTiltOut = new DigitalInput(RobotMap.DIGITAL_IO_SCISSOR_LIMIT_SWITCH_FORWARD_TILT);
		this.scissorTiltIn = new DigitalInput(RobotMap.DIGITAL_IO_SCISSOR_LIMIT_SWITCH_BACK_TILT);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public static ScissorSystem getInstance() {
		return INSTANCE;
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
		return scissorTiltOut.get();
	}

	public boolean isDown() {
		return scissorTiltIn.get();
	}

	public boolean isExtended() {
		return scissorExtended.get();
	}

	public boolean isRetracted() {
		return scissorRetracted.get();
	}

}
