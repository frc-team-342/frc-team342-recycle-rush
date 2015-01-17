
package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveWithJoystick;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.can.CANMessageNotFoundException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;


public class DriveSystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static final DriveSystem INSTANCE = new DriveSystem();
     CANJaguar frontLeftjaguar;
     CANJaguar rearLeftjaguar;
     CANJaguar frontRightjaguar;
     CANJaguar rearRightjaguar;
    private final RobotDrive robotDrive;

    private DriveSystem() {
    	try{
       	 frontLeftjaguar = new CANJaguar(4);
       	 rearLeftjaguar = new CANJaguar(3);
       	 frontRightjaguar = new CANJaguar(6);
       	 rearRightjaguar = new CANJaguar(5);
       	}
       	catch(CANMessageNotFoundException ex){
       		//System.out.println("ERROR"+ex.getMessage());
       	}
    	robotDrive = new RobotDrive(frontLeftjaguar,rearLeftjaguar,frontRightjaguar,rearRightjaguar);
    }


    public void initDefaultCommand() {
    	this.setDefaultCommand (new DriveWithJoystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void driveWithJoystick(Joystick joystick) {
        double x = joystick.getX() * -1;
        double y = joystick.getY() * -1;
        double rotation = joystick.getZ() * -1;
        double angle = 0.0;
        robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);	// invert the left side motors
    	robotDrive.setInvertedMotor(MotorType.kRearLeft, true);		// you may need to change or remove this to match your robot
        this.robotDrive.mecanumDrive_Cartesian(x, y, rotation, angle);
        CANJaguar.updateSyncGroup((byte)0x80);
    }

    public static DriveSystem getInstance() {
        return INSTANCE;
    }
    
    public void forward(double speed) {
        this.robotDrive.mecanumDrive_Polar(speed, 1.0, 0.0);
    }

    public void reverse(double speed) {
        this.robotDrive.mecanumDrive_Polar(speed, 1.0, 0.0);
    }

    public void stop(double speed) {
        this.robotDrive.mecanumDrive_Polar(0.0, 0.0, 0.0);
    }

    
}
