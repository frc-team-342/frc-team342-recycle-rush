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
	private final AnalogPotentiometer potentiometer;
	private final AnalogInput ultrasonic;
	private final DigitalInput limitSwitchOut;

	// the gripper calls these as a guide for where to stop the gripper
	private final double GRIP_STRENGTH = 0.3;
	private final double GRIP_MINIMUM_STOP_OPEN = 0.2;

	// gripper system constructor
	private GripSystem() {
		this.talon = new Talon(RobotMap.CAN_CHANNEL_GRIP_OPEN_CLOSE);
		this.ultrasonic = new AnalogInput(RobotMap.ANALOG_IO_GRIP_ULTRASONIC);
		this.potentiometer = new AnalogPotentiometer(
				RobotMap.ANALOG_IO_GRIP_POTENTIOMETER_POSITION);
		this.limitSwitchOut = new DigitalInput(
				RobotMap.DIGITAL_IO_GRIP_LIMIT_SWITCH_OUTER_LIMIT);
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
		
		// set the motor to the default strength and
		if (potentiometer.get() < stop) {
			talon.set(GRIP_STRENGTH);
			open = false;
		}
		
		// stops the motor if the open function is complete
		if (open)
			talon.set(0); 
		
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
	 * @return the value of the ultrasonic sensor in the front o the robot
	 */
	public int getUltrasonic() {
		return ultrasonic.getValue();
	}
	
	/**
	 * 
	 * @return the potentiometer value for detecting the gr
	 */
	public double getPotentiometer() {
		return potentiometer.get();
	}
}
