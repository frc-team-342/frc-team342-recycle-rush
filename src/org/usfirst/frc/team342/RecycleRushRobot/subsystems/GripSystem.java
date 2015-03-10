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
	// instantiate the robot
	private static final GripSystem INSTANCE = new GripSystem();

	// declare motors and sensors
	private final Talon talon;
	private final AnalogInput potentiometer;
	private final AnalogInput button;
	private final DigitalInput limitSwitchOut;
	// This is the distance from the
	private final double GRIP_DEAD_ZONE = 3;
	// Value for the grip to move at full speed if it is more than that far from
	// being closed on an object
	private final int POTENTIOMETER_FULL_SPEED_VALUE = 100;

	private GripSystem() {
		// Initializes a talon motor for the grip, the potentiometer to get the
		// position of the grip, and the limit switch is a fail safe to stop the
		// lift if it goes to far.
		talon = new Talon(RobotMap.CAN_CHANNEL_GRIP_OPEN_CLOSE);
		potentiometer = new AnalogInput(RobotMap.ANALOG_IO_GRIP_POTENTIOMETER);
		limitSwitchOut = new DigitalInput(
				RobotMap.DIGITAL_IO_GRIP_LIMIT_SWITCH_OUTER_LIMIT);
		button = new AnalogInput(
				RobotMap.ANALOG_IO_GRIP_FRONT_COLLISION);
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
	 * @return True if the gripper is close enough to where it should stop
	 */
	public boolean moveTo(int gripStop) {
		// Set the default state to done
		boolean isFinished = true;
		// Holds the value from the potentiometer. This prevents taking multiple
		// inputs from the potentiometer
		int potVal = potentiometer.getValue();
		// Sets the speed to move the grip at
		double speed = getGripSpeed(gripStop, potVal);

		// This will make the function do nothing if potentiometer is reading
		// noise
		if (potVal == 5)
			isFinished = false;

		// Else close the gripper if the potentiometer returns a value GREATER
		// than the sum of the value to stop at and the acceptable "dead zone".
		else if (potVal > gripStop + GRIP_DEAD_ZONE) {
			isFinished = false;
			talon.set(-1.0 * speed);
		}

		// Or open the gripper if the potentiometer returns a value LESS than
		// the difference of the value to stop at and the acceptable
		// "dead zone". This will also not run if the outer limit switch is
		// pressed.
		else if ((potVal <= gripStop - GRIP_DEAD_ZONE) && limitSwitchOut.get()) {
			isFinished = false;
			talon.set(1.0 * speed);
		}

		// Stop the motor if the grip is where it should be
		if (isFinished)
			talon.set(0);

		// return true if the grip is finished
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
		// Speed holds the speed of the motor
		double speed = 1.0;
		// Set the target distance to the distance from the target potentiometer
		// value using the absolute value of their difference.
		int distanceFromTarget = Math.abs(targetDistance - potentiometerValue);

		// Set the speed using a linear function of the speed if the distance is
		// bless than 16 potentiometer units from its target. The equation is
		// f(x)=x/16 where x is the distance from the target and f(x) returns
		// the speed.
		if (distanceFromTarget <= POTENTIOMETER_FULL_SPEED_VALUE)
			speed = distanceFromTarget / POTENTIOMETER_FULL_SPEED_VALUE;

		// Set the speed to 0.3 if it would otherwise be lower than that
		if (speed < 0.3)
			speed = 0.3;

		return speed;
	}

	/**
	 * set the grip speed to 0
	 */
	public void stop() {
		talon.set(0.0);
	}

	/**
	 * @return the value of the potentiometer
	 */
	public int getPotentiometer() {
		return potentiometer.getValue();
	}
	
	/**
	 * @return the value of the potentiometer
	 */
	public int getButton() {
		return button.getValue();
	}

	@Override
	protected void initDefaultCommand() {

	}
}
