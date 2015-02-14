package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

/**
 * @author team_342
 * 
 *         !!! Many of the values are not exact and MUST be modified as to not
 *         PERMENTLY DAMAGE the equipment !!!
 * 
 *         Gripper System class
 * 
 *         This subsystem is the grip system used to grab totes and bins. The
 *         class will automatically set the gripper to full open so it can close
 *         around conatiner and totes. The GripperSystem and getInstance methods
 *         are used to initialize the system. The gripClose method moves the
 *         gripper closer to two values, although it will open the gripper if
 *         the second value is set low enough. The gripOpen method opens the
 *         gripper to the specified value, and defaults to opening the gripper
 *         all the way. The stopGrip method can be called by any method to set
 *         the gripper motor to 0, although I can not see a use for it unless
 *         there is a programming error because every time the grip motor is
 *         start it should stop after reaching the value.
 * 
 *         The gripClose and gripOpen should be called in loops. They return
 *         true when they are completed.
 */
public class GripSystem extends Subsystem {
	// instantiate the robot
	private static final GripSystem INSTANCE = new GripSystem();

	// declare motors and sensors
	private final Talon talon;
	private final AnalogPotentiometer potentiometer;
	// ultrasonic and outer limit switch are not yet implemented
	private final AnalogInput ultrasonic;
	private final DigitalInput limitSwitchOut;

	// the gripper calls these as a guide for where to stop the gripper
	private final double GRIP_STRENGTH = 0.3;
	private final double GRIP_MINIMUM_STOP_OPEN = 0.2;

	// gripper system instance
	private GripSystem() {
		this.talon = new Talon(RobotMap.CAN_CHANNEL_GRIP_OPEN_CLOSE);
		this.ultrasonic = new AnalogInput(RobotMap.ANALOG_IO_GRIP_ULTRASONIC);
		this.potentiometer = new AnalogPotentiometer(
				RobotMap.ANALOG_IO_GRIP_POTENTIOMETER_POSITION);
		this.limitSwitchOut = new DigitalInput(
				RobotMap.DIGITAL_IO_GRIP_LIMIT_SWITCH_OUTER_LIMIT);
	}

	// returns the gripper system instance for robot.java
	public static GripSystem getInstance() {
		return INSTANCE;
	}

	/**
	 * closes the grip towards the specified potentiometer values, uses RobotMap
	 * gripper default values this should be called in a loop
	 * 
	 * @param closeTo
	 *            close the gripper towards the specified value
	 * @return true if gripper is between the given values
	 */
	public boolean close(double closeTo) {
		boolean closed = true; // set default state to closed

		if (potentiometer.get() >= closeTo) {
			closed = false;
			talon.set(-1 * GRIP_STRENGTH); // set the strength to open at, this
											// could be made
			// non-constant for better control
		} else if (potentiometer.get() < closeTo - GRIP_MINIMUM_STOP_OPEN) {
			closed = false;
			talon.set(GRIP_STRENGTH); // sets the strength for the talon to open
										// at
		}

		if (closed)
			talon.set(0); // stop the motor if the close function is complete
		return closed;
	}

	/**
	 * opens the gripper until stop is reached by the potentiometer voltage this
	 * should be called in a loop
	 * 
	 * @param stop
	 *            potentiometer value for where to open or close the griper
	 *            towards
	 * @return true if potentiometer detects the gripper as more open or equal
	 *         to the stop value
	 */
	public boolean open(double stop) {
		boolean open = true; // set default state to open

		if (potentiometer.get() < stop) {
			talon.set(GRIP_STRENGTH); // sets the strength for the gripper to
										// open at
			open = false;
		}

		if (open)
			talon.set(0); // stop the motor if the open function is complete
		return open;
	}

	/**
	 * stop the gripper
	 */
	public void stop() {
		talon.set(0); // stop the motor
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void testUltrasonic() {
		System.out.println(ultrasonic.getValue());
	}

	public void testPotentiometer() {
		System.out.println(potentiometer.get());
	}
}
