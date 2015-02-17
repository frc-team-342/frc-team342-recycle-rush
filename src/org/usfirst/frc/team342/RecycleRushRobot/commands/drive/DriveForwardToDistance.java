package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardToDistance extends Command {
    DriveSystem drive;
    private int distance;
    private int targetDistance;

    public DriveForwardToDistance(int target) {
	drive = DriveSystem.getInstance();
	requires(this.drive);
	targetDistance = target;
    }

    public DriveForwardToDistance(String name) {
	super(name);
	// TODO Auto-generated constructor stub
    }

    public DriveForwardToDistance(double timeout) {
	super(timeout);
	// TODO Auto-generated constructor stub
    }

    public DriveForwardToDistance(String name, double timeout) {
	super(name, timeout);
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void initialize() {
	// TODO Auto-generated method stub
    }

    @Override
    protected void execute() {
	drive.forward(RobotMap.AUTONOMOUS_SPEED);
	distance = drive.getDistance();
    }

    @Override
    protected boolean isFinished() {
	return distance >= targetDistance;
    }

    @Override
    protected void end() {
	drive.stop();
    }

    @Override
    protected void interrupted() {
	end();
    }

}
