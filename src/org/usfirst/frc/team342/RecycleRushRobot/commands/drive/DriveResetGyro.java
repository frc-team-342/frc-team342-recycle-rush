package org.usfirst.frc.team342.RecycleRushRobot.commands.drive;

import org.usfirst.frc.team342.RecycleRushRobot.OI;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveResetGyro extends Command {

    private DriveSystem drive;

    public DriveResetGyro() {
	drive = DriveSystem.getInstance();
	// TODO Auto-generated constructor stub
    }

    public DriveResetGyro(String name) {
	super(name);
	// TODO Auto-generated constructor stub
    }

    public DriveResetGyro(double timeout) {
	super(timeout);
	// TODO Auto-generated constructor stub
    }

    public DriveResetGyro(String name, double timeout) {
	super(name, timeout);
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void initialize() {
	// TODO Auto-generated method stub

    }

    @Override
    protected void execute() {
	drive.resetGyro();
	System.out.println("Reseting the gyro...");
	// TODO Auto-generated method stub
    }

    @Override
    protected boolean isFinished() {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    protected void end() {
	System.out.println("Gyro succesfully reset");

    }

    @Override
    protected void interrupted() {
	// TODO Auto-generated method stub

    }

}
