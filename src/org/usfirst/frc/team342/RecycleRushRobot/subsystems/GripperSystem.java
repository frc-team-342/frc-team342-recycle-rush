package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

/**
 * @author team_342
 *	!!! Many of the values are not exact and MUST be modified for this to not PERMENTLY DAMAGE the equipment !!!
 * 
 * Gripper System class
 * 
 * This subsystem is the grip system used to grab totes and bins. The class will automatically set the gripper to full open
 * so it can close around bins and totes. The GripperSystem and getInstance methods are used to initialize the system. 
 * The gripClose method moves the gripper closer to two values, although it will open the gripper if the second value
 * is set low enough. The gripOpen method opens the gripper to the specified value, and defaults to opening the gripper 
 * all the way. The stopGrip method can be called by any method to set the gripper motor to 0, although I can not see a
 * use for it unless there is a programming error because every time the grip motor is start it should stop after
 * reaching the value.
 * 
 * The gripClose and gripOpen should be called in loops. They return true when they are completed.
 */
public class GripperSystem extends Subsystem {
	//instantiate the robot
	private static final GripperSystem INSTANCE = new GripperSystem();
	
	//declare motors and sensors
	private final Talon talon;
	//we use .getVoltage to determine the strength of the potentiometer, but this is not necessarily the best solution
	private final AnalogInput potentiometer;
	//ultrasonic is not yet implemented
	private final AnalogInput ultrasonic;
	
	//changed to true if closed is true
	private boolean closed;
	
	//gripper system instance
	private GripperSystem() {
		//the actual values depend on the locations in the robo-rio
		this.talon = new Talon(3);
		this.ultrasonic = new AnalogInput(3);
		this.potentiometer = new AnalogInput(2);
		
		//set default state to all the way open
		while(this.gripOpen());
	}
	
	//returns the gripper system instance for robot.java
	public static GripperSystem getInstance() {
		return INSTANCE;
	}
	
	/**
	 * closes the grip towards the specified potentiometer values, uses RobotMap gripper default values
	 * this should be called in a loop
	 * @param closeTo 
	 * 		close the gripper towards the specified value
	 * @param openTo
	 * 		if too far closed, open the gripper towards this value before trying to close
	 * @return
	 * 		true if gripper is between the given values
	 */
	public boolean gripClose(double closeTo, double openTo){	
		closed = true;	//set default state to closed
		
		if(potentiometer.getVoltage() >= closeTo){
			closed = false;
			talon.set(-.3); //set the strength to open at, this could be made non constant for better control
		}
		else if(potentiometer.getVoltage() <  openTo){
			closed = false;
			talon.set(3);	//sets the strength for the potentiometer to open at
		}
		
		if(closed) talon.set(0);	//stop the motor
		return closed;
	}
	
	/**
	 * opens the gripper until stop is reached by the potentiometer voltage
	 * this should be called in a loop
	 * @param stop 
	 * 			is a double value for when to stop opening the gripper
	 * @return true if potentiometer detects the gripper as more open than the double
	 */
	public boolean gripOpen(double stop){
		closed = false;	//set default state to open
		
		if(potentiometer.getVoltage() < stop){
			talon.set(.3);	//sets the strength for the potentiometer to open at
			closed = true;
		}
		

		if(!closed) talon.set(0);	//stop the motor
		return !closed;
	}
	
	/**
	 * overloads gripOpen to do the default of opening all the way
	 * @return true if gripper is not closed (getVoltage returns less than FULLOPEN in RobotMap)
	 */
	public boolean gripOpen(){
		closed = false;	//set default state to open
		
		if(potentiometer.getVoltage() < RobotMap.FULLOPEN){
			talon.set(.3);	//sets the strength for the potentiometer to open at
			closed = true;
		}
		
		if(!closed) talon.set(0);	//stop the motor
		return !closed;
	}
	
	/**
	 * stop the gripper
	 */
	public void stopGrip(){
		talon.set(0);	//stop the motor
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}