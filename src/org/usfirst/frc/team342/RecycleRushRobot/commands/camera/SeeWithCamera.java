package org.usfirst.frc.team342.RecycleRushRobot.commands.camera;

import org.usfirst.frc.team342.RecycleRushRobot.subsystems.CameraVisionRedux;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.command.Command;

public class SeeWithCamera extends Command {

	private CameraVisionRedux camera;

	public SeeWithCamera() {
		camera = CameraVisionRedux.getInstance();
		requires(camera);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		camera.SeeingIsBelieving();
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// camera.StopSeeingIsBelieving();
		// TODO Auto-generated method stub
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
