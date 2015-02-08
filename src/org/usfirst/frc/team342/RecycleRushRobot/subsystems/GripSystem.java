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
 *         around bins and totes. The GripperSystem and getInstance methods are
 *         used to initialize the system. The gripClose method moves the gripper
 *         closer to two values, although it will open the gripper if the second
 *         value is set low enough. The gripOpen method opens the gripper to the
 *         specified value, and defaults to opening the gripper all the way. The
 *         stopGrip method can be called by any method to set the gripper motor
 *         to 0, although I can not see a use for it unless there is a
 *         programming error because every time the grip motor is start it
 *         should stop after reaching the value.
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

	// used to return if the close or open commands have completed
	private boolean closed;

	// gripper system instance
	private GripSystem() {
		this.talon = new Talon(RobotMap.CAN_CHANNEL_GRIP_OPEN_CLOSE);
		this.ultrasonic = new AnalogInput(RobotMap.ANALOG_GRIP_ULTRASONIC);
		this.potentiometer = new AnalogPotentiometer(
				RobotMap.ANALOG_GRIP_POTENTIOMETER_POSITION);
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
	public boolean gripClose(double closeTo) {
		closed = true; // set default state to closed

		if (potentiometer.get() >= closeTo) {
			closed = false;
			talon.set(-.3); // set the strength to open at, this could be made
							// non-constant for better control
		} else if (potentiometer.get() < closeTo
				- RobotMap.GRIP_MINIMUM_STOP_OPEN) {
			closed = false;
			talon.set(3); // sets the strength for the potentiometer to open at
		}

		if (closed)
			talon.set(0); // stop the motor
		return closed;
	}

	/**
	 * opens the gripper until stop is reached by the potentiometer voltage this
	 * should be called in a loop
	 * 
	 * @param stop
	 *            is a double value for when to stop opening the gripper
	 * @return true if potentiometer detects the gripper as more open than the
	 *         double
	 */
	public boolean gripOpen(double stop) {
		closed = false; // set default state to open

		if (potentiometer.get() < stop) {
			talon.set(.3); // sets the strength for the gripper to open at
			closed = true;
		}

		if (!closed)
			talon.set(0); // stop the motor
		return !closed;
	}

	/**
	 * stop the gripper
	 */
	public void gripStop() {
		talon.set(0); // stop the motor
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}