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
	private ScissorSystem scissor;
	private CameraVisionRedux camera;
	private GripSystem grip;

	private Command autonomousCommand;
	private DriveWithJoystick runnow;
	
	private SendableChooser autoChooser;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		this.oi = OI.getInstance();
		this.drive = DriveSystem.getInstance();
		this.lift = LiftSystem.getInstance();
		this.scissor = ScissorSystem.getInstance();
		this.camera = CameraVisionRedux.getInstance();
		this.grip = GripSystem.getInstance();
		this.autoChooser = new SendableChooser();
		
		// Create a selection for choosing autonomous modes
		autoChooser.addDefault("Just drive to the center of the field",
				new DriveToCenter());
		autoChooser.addObject("Pick up container and drive to center",
				new PickUpTote());
		autoChooser.addObject("Pick up tote and drive to center",
				new PickUpContainer());
		autoChooser.addObject("Pick up both a tote and a container and drive to center",
				new PickUpToteAndContainer());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		
		SmartDashboard.putString("Test", "Test Value");
	}

	/**
	 * only allow one button to be pressed in dash board while disabled. This is
	 * used to get the autonomous mode when autonomous is initialized.
	 */
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * sets the autonomous mode to the one selected in the button
	 */
	public void autonomousInit() {
		// Fixed the case statement
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * initialize the joy stick
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
		Scheduler.getInstance().run();
		runnow.start();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
	}
}
