package org.usfirst.frc.team342.RecycleRushRobot.commands.lift;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftDownTime extends Command {
    LiftSystem lift;
    private long startTime;
    private long duration;

    public LiftDownTime(long time) {
	duration = time;
	lift = LiftSystem.getInstance();
	requires(lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	lift.liftDown();
	duration = System.currentTimeMillis() - startTime;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return (lift.bottomLimit() || duration <= System.currentTimeMillis());
    }

    // Called once after isFinished returns true
    protected void end() {
	lift.liftStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
	this.end();
    }
}
