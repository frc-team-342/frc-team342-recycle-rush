package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSystem extends Subsystem {
	private static final LiftSystem INSTANCE = new LiftSystem();
	private final Talon talon;
	private final DigitalInput topSwitch;
	private final DigitalInput bottomSwitch;

	public LiftSystem() {
		// TODO Auto-generated constructor stub
		this.talon = new Talon(0);
		this.topSwitch = new DigitalInput(4);
		this.bottomSwitch = new DigitalInput(5);
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
			this.talon.set(1.0);
		} else {
			this.talon.set(0.0);
		}
	}

	public void liftDown() {
		if (!bottomLimit()) {
			this.talon.set(-1.0);
		} else {
			this.talon.set(0.0);
		}
	}

	public void liftStop() {
		this.talon.set(0.0);
	}

	public boolean topLimit() {
		return !topSwitch.get();
	}

	public boolean bottomLimit() {
		return !bottomSwitch.get();
	}

}
