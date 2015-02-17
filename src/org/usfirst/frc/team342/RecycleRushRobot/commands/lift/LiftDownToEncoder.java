package org.usfirst.frc.team342.RecycleRushRobot.commands.lift;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

public class LiftDownToEncoder extends Command {
    LiftSystem lift;
    int height;
    int targetHeight;

    public LiftDownToEncoder(int target) {
	lift = LiftSystem.getInstance();
	requires(lift);
	targetHeight = target;
    }

    public LiftDownToEncoder(String name) {
	super(name);
	// TODO Auto-generated constructor stub
    }

    public LiftDownToEncoder(String name, double timeout) {
	super(name, timeout);
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void initialize() {
	height = lift.getEncoderValue();
    }

    @Override
    protected void execute() {
	lift.down();
    }

    @Override
    protected boolean isFinished() {
	// TODO Auto-generated method stub
	return targetHeight >= lift.getEncoderValue();
    }

    @Override
    protected void end() {
	lift.stop();
    }

    @Override
    protected void interrupted() {
	end();
    }

}
