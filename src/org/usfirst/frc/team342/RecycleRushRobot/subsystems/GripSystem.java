package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

/**
 * Gripper System class
 * 
 * This subsystem is the grip system used to grab totes and bins. The
 * GripperSystem and getInstance methods are used to initialize the system. The
 * gripClose method moves the gripper closer to a value and it will open the
 * gripper if the second value is set less than how open it currently is. The
 * Open method opens the gripper to the specified value. The Close and Open
 * methods should be called in loops. They return true when they are completed.
 */
public class GripSystem extends Subsystem {
	// instantiate the robot
	private static final GripSystem INSTANCE = new GripSystem();

	// declare motors and sensors
	private final Talon talon;
	private final AnalogInput ultrasonic;
	private final DigitalInput limitSwitchOut;
	private final DigitalInput limitSwitchIn;
	// the gripper calls these as a guide for where to stop the gripper
	private final double GRIP_STRENGTH = 0.5;
	private final double GRIP_MINIMUM_STOP_OPEN = 0.2;

	// gripper system constructor
	private GripSystem() {
		this.talon = new Talon(RobotMap.CAN_CHANNEL_GRIP_OPEN_CLOSE);
		this.ultrasonic = new AnalogInput(RobotMap.ANALOG_IO_GRIP_ULTRASONIC);
		this.limitSwitchOut = new DigitalInput(
				RobotMap.DIGITAL_IO_GRIP_LIMIT_SWITCH_OUTER_LIMIT);
		this.limitSwitchIn = new DigitalInput(
				RobotMap.DIGITAL_IO_GRIP_LIMIT_SWITCH_INNER_LIMIT);
	}

	/**
	 * 
	 * @return GripSystem instance
	 */
	public static GripSystem getInstance() {
		return INSTANCE;
	}

	/**
	 * closes the grip towards the specified potentiometer values
	 * 
	 * @param closeTo
	 *            close the gripper towards the specified value
	 * @return true if gripper is between the given values
	 */
	public boolean close(double closeTo) {
		// set the default state to closed
		boolean closed = true;

		// close if not closed
		if (limitSwitchIn.get()) {
			closed = false;
			talon.set(-1 * GRIP_STRENGTH);
		}

		// redundantly close if limit switch is true
		if (!limitSwitchIn.get()) {
			closed = true;
			talon.set(0);
		}

		// retrun whether or not the gripper is already closed for loop
		// statements
		return closed;
	}

	/**
	 * opens the gripper until stop is reached by the potentiometer value this
	 * should be called in a loop
	 * 
	 * @param stop
	 *            potentiometer value for where to open or close the griper
	 *            towards
	 * @return true if potentiometer detects the gripper as more open or equal
	 *         to the stop value
	 */
	public boolean open(double stop) {
		// set default state to open
		boolean open = true;

		// set the motor to the default strength and open if not already fully
		// open
		if (limitSwitchOut.get()) {
			talon.set(GRIP_STRENGTH);
			open = false;
		}

		// stops the motor if the open function is complete, redundantly set
		// open to true
		if (!limitSwitchOut.get()) {
			talon.set(0);
			open = true;
		}

		return open;
	}

	/**
	 * stop the gripper
	 */
	public void stop() {
		talon.set(0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 * @return the value of the ultra sonic sensor in the front o the robot
	 */
	public int getUltrasonic() {
		return ultrasonic.getValue();
	}

	/**
	 * 
	 * @return the potentiometer value for detecting the gr
	 */
	// public double getPotentiometer() {
	// return potentiometer.get();
	// }
}
