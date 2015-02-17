package org.usfirst.frc.team342.RecycleRushRobot.commands.lift;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftGetEncoder extends Command {
    LiftSystem lift;

    public LiftGetEncoder() {
	lift = LiftSystem.getInstance();
	requires(lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	System.out.println(lift.getEncoderValue());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}