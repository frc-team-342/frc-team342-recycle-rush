package org.usfirst.frc.team342.RecycleRushRobot.commands.camera;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.CameraVisionRedux;

import edu.wpi.first.wpilibj.command.Command;

public class ChangeCamera extends Command {

	private CameraVisionRedux Cam;

	public ChangeCamera() {
		Cam = CameraVisionRedux.getInstance();
		requires(Cam);

	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Cam.ChangeCamera();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		//camera.StopSeeingIsBelieving();
	}

	@Override
	protected void interrupted() {

	}

}
