package org.usfirst.frc.team342.RecycleRushRobot.commands.camera;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.CameraVisionRedux;

import edu.wpi.first.wpilibj.command.Command;

public class SeeWithCamera extends Command {

	private CameraVisionRedux camera;

	public SeeWithCamera() {
		camera = CameraVisionRedux.getInstance();
		requires(camera);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		camera.SeeingIsBelieving();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		// camera.StopSeeingIsBelieving();
	}

	@Override
	protected void interrupted() {

	}

}
