package org.usfirst.frc.team342.RecycleRushRobot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;

import org.usfirst.frc.team342.RecycleRushRobot.commands.Autonomous.*;
import org.usfirst.frc.team342.RecycleRushRobot.commands.drive.DriveWithJoystick;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.CameraVisionRedux;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.ScissorSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.DriveSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.LiftSystem;
import org.usfirst.frc.team342.RecycleRushRobot.subsystems.GripSystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RecycleRushRobot extends IterativeRobot {
	private DriveSystem drive;
	private LiftSystem lift;
	private OI oi;
	private Command autonomousCommand;
	private ScissorSystem scissor;
	private CameraVisionRedux camera;
	private GripSystem grip;
	private DriveWithJoystick runnow;

	private int AutonomousMode;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		this.oi = OI.getInstance();
		// instantiate the command used for the autonomous period
		// autonomousCommand = new ExampleCommand();
		this.drive = DriveSystem.getInstance();
		this.lift = LiftSystem.getInstance();
		this.scissor = ScissorSystem.getInstance();
		this.camera = CameraVisionRedux.getInstance();
		this.grip = GripSystem.getInstance();

		SmartDashboard.putBoolean("DB/Button 0", true);
		AutonomousMode = 0;
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		for (int i = 0; i < 4; i++) {
			
			if (SmartDashboard.getBoolean("DB/Button " + i)) {

				SmartDashboard.putBoolean("DB/Button " + AutonomousMode, false);
				AutonomousMode = i;
			}

			System.out.println("AutonomousMode " + AutonomousMode + "\n");
			
		}
		
		for(int i = 0; i < 4; i++){
			SmartDashboard.putBoolean("DB/Button " + i, i == AutonomousMode);
		}
		

	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		// if (autonomousCommand != null) autonomousCommand.start();
		autonomousCommand = new DriveToCenter();
		autonomousCommand.start();

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		System.out.println(drive.getDistance());
	}

	/**
	 * initializes the joystick
	 */
	public void teleopInit() {
		runnow = new DriveWithJoystick();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		runnow.start();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		// LiveWindow.run();
		// System.out.println((int)lift.getEncoderValue());
	}
}
