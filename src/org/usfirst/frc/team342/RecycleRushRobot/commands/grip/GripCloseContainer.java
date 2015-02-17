package org.usfirst.frc.team342.RecycleRushRobot.commands.grip;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;

/**
 * calls the grip system command to close the gripper on a bin. If interrupted
 * it should exit cleanly.
 */
public class GripCloseContainer extends Command {
    GripSystem grip;
    private final double GRIP_CONTAINER = .50;

    public GripCloseContainer() {
	grip = GripSystem.getInstance();
	requires(grip);
    }

    public GripCloseContainer(String name) {
	super(name);
	// TODO Auto-generated constructor stub
    }

    public GripCloseContainer(double timeout) {
	super(timeout);
	// TODO Auto-generated constructor stub
    }

    public GripCloseContainer(String name, double timeout) {
	super(name, timeout);
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void initialize() {
	// TODO Auto-generated method stub

    }

    @Override
    protected void execute() {
	// TODO Auto-generated method stub

    }

    @Override
    protected boolean isFinished() {
	return grip.close(GRIP_CONTAINER);
    }

    @Override
    protected void end() {
	grip.stop();

    }

    @Override
    protected void interrupted() {
	this.end();
    }

}
