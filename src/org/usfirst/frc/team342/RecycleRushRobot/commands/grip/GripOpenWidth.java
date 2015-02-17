//package org.usfirst.frc.team342.RecycleRushRobot.commands.grip;
//
//import edu.wpi.first.wpilibj.command.Command;
//
//import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
//import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;
//
///**
// * this function is not yet implemented. If called it should open the gripper
// * all the way.
// */
//public class GripOpenWidth extends Command {
//	GripSystem grip;
//	private final double GRIP_FULL_OPEN = .94;
//	private double potentiometerValue;
//	public GripOpenWidth(double potentiometerValue) {
//		this.potentiometerValue = potentiometerValue;
//		grip = GripSystem.getInstance();
//		requires(grip);
//	}
//
//	public GripOpenWidth(String name) {
//		super(name);
//		// TODO Auto-generated constructor stub
//	}
//
//	public GripOpenWidth(String name, double timeout) {
//		super(name, timeout);
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	protected void initialize() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	protected void execute() {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	protected boolean isFinished() {
//		return grip.open(GRIP_FULL_OPEN) || grip.getPotentiometer() >= potentiometerValue;
//	}
//
//	@Override
//	protected void end() {
//		// TODO Auto-generated method stub
//		grip.stop();
//	}
//
//	@Override
//	protected void interrupted() {
//		// TODO Auto-generated method stub
//		this.end();
//	}
//
// }
