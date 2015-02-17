package org.usfirst.frc.team342.RecycleRushRobot.commands.grip;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;

public class GripStop extends Command {
    GripSystem grip;

    /**
     * Grip stop stops the grip system motor
     */
    public GripStop() {
	grip = GripSystem.getInstance();
	requires(grip);
    }

    public GripStop(String name) {
	super(name);
	// TODO Auto-generated constructor stub
    }

    public GripStop(double timeout) {
	super(timeout);
	// TODO Auto-generated constructor stub
    }

    public GripStop(String name, double timeout) {
	super(name, timeout);
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void initialize() {
	// TODO Auto-generated method stub

    }

    @Override
    protected void execute() {
	grip.stop();

    }

    @Override
    protected boolean isFinished() {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    protected void end() {
	// TODO Auto-generated method stub

    }

    @Override
    protected void interrupted() {
	// TODO Auto-generated method stub

    }

}
