package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Gripper System class
 * 
 * This is the grip system used to grab totes and bins. The grip() method moves
 * the gripper closer to a value and it will open the gripper if the second
 * value is set less than how open it currently is.
 */
public class GripSystem extends Subsystem {
	private static final GripSystem INSTANCE = new GripSystem();

	// Declare motors and sensors
	private final Talon talon;
	private final AnalogInput potentiometer;
	private final AnalogInput button;
	private final DigitalInput limitSwitchOut;

	// Dead zone used to detect if the grip is close enough to being closed,
	// this is necessary because higher motor speeds can make grip stopping
	// function inaccurate
	private final double GRIP_DEAD_ZONE = 7;
	// Value for the grip to start to slow down if it is this close to reaching
	// its target distance
	private final int POTENTIOMETER_SLOW_DOWN_DISTANCE = 100;
	// Grip button midpoint value to decide whether the robot is touching
	// something or not
	public final int GRIP_BUTTON_MIDPOINT = 2176;

	private GripSystem() {
		// Initializes a talon motor for the grip, the potentiometer to get the
		// position of the grip, and the limit switch is a fail safe to stop the
		// lift if it goes to far.
		talon = new Talon(RobotMap.CAN_CHANNEL_GRIP_OPEN_CLOSE);
		potentiometer = new AnalogInput(RobotMap.ANALOG_IO_GRIP_POTENTIOMETER);
		limitSwitchOut = new DigitalInput(
				RobotMap.DIGITAL_IO_GRIP_LIMIT_SWITCH_OUTER_LIMIT);
		button = new AnalogInput(RobotMap.ANALOG_IO_GRIP_FRONT_COLLISION);
	}

	public static GripSystem getInstance() {
		return INSTANCE;
	}

	/**
	 * Move the gripper to a specific position.
	 * 
	 * @param gripStop
	 *            The potentiometer value to move the grip to
	 * 
	 * @param speed
	 *            The speed to move the gripper, if the gripper is moving to
	 *            fast it will not stop in the correct position
	 * 
	 * @return True if the gripper is within a small value of where it should
	 *         stop at
	 */
	public boolean moveTo(int gripStop) {
		// Set the default state to done
		boolean isFinished = true;
		// Holds the value from the potentiometer. This prevents taking multiple
		// inputs from the potentiometer
		int potVal = potentiometer.getValue();
		// Sets the speed to move the grip at
		double speed = getGripSpeed(gripStop, potVal);

		// Close the gripper if the potentiometer returns a value GREATER
		// than the sum of the value to stop at and the acceptable "dead zone".
		if (potVal > gripStop + GRIP_DEAD_ZONE) {
			isFinished = false;
			talon.set(-1.0 * speed);
		}

		// Or open the gripper if the potentiometer returns a value LESS than
		// the difference of the value to stop at and the acceptable
		// "dead zone". This will also not run if the outer limit switch is
		// pressed.
		else if (potVal <= gripStop - GRIP_DEAD_ZONE && limitSwitchOut.get()) {
			isFinished = false;
			talon.set(speed);
		}

		// Stop the motor if the grip is where it should be
		if (isFinished)
			talon.set(0);

		// Return true if the grip is finished moving
		return isFinished;
	}

	/**
	 * Get the speed to close the grip at for better precision
	 * 
	 * @param target
	 *            The target distance
	 * @return The speed to move the grip at
	 */
	private double getGripSpeed(int targetDistance, int potentiometerValue) {
		// Holds the speed of the motor, default if not changed in the following
		// conditionals is full speed
		double speed = 1.0;
		// Set the target distance to the distance from the target potentiometer
		// value using the absolute value of their difference.
		int distanceFromTarget = Math.abs(targetDistance - potentiometerValue);

		// If the POTENTIOMETER_SLOW_DOWN_DISTANCE is d, set the speed using a
		// linear function of the speed if the distance is less than d
		// potentiometer units from its target. The equation is f(x)=x/d where x
		// is the distance from the target and f(x) returns the speed.
		if (distanceFromTarget <= POTENTIOMETER_SLOW_DOWN_DISTANCE)
			speed = distanceFromTarget / POTENTIOMETER_SLOW_DOWN_DISTANCE;

		// Set the speed to 0.3 if it would otherwise be lower than that
		if (speed < 0.4)
			speed = 0.4;

		return speed;
	}

	/**
	 * Set the grip speed to 0
	 */
	public void stop() {
		talon.set(0.0);
	}

	/**
	 * @return The value of the potentiometer
	 */
	public int getPotentiometer() {
		return potentiometer.getValue();
	}

	/**
	 * @return The value of the button
	 */
	public int getButton() {
		return button.getValue();
	}

	/**
	 * Detect if the robot is touching something in front of it such as a tote
	 * 
	 * @return True if the robot is touching something in front of it
	 */
	public boolean isForwardContact() {
		// if the button is being pressed (returning a value higher than its
		// default output) return trueF
		return button.getValue() > GRIP_BUTTON_MIDPOINT;
	}

	@Override
	protected void initDefaultCommand() {

	}
}
