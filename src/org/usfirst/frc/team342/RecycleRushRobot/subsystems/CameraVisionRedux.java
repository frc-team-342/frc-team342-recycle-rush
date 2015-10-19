package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.commands.camera.SeeWithCamera;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CameraVisionRedux extends Subsystem {
	private static final CameraVisionRedux INSTANCE = new CameraVisionRedux();
	Image frame;
	// True if the camera failed
	boolean failure;
	int frontCam;
	int backCam;
	int currCam;

	// TODO Dynammically configure camera
	public CameraVisionRedux() {
		failure = false;
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

		try {
			frontCam = NIVision.IMAQdxOpenCamera("cam0",
					NIVision.IMAQdxCameraControlMode.CameraControlModeListener);
		} catch (Exception e) {
			// Print error and disable both cameras
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("First camera failed");
			failure = true;
		}
		try {
			backCam = NIVision.IMAQdxOpenCamera("cam1",
					NIVision.IMAQdxCameraControlMode.CameraControlModeListener);
		} catch (Exception e) {
			// Print error and disable both cameras
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Second camera failed");
			failure = true;
		}

		currCam = frontCam;
		if (!failure) {
			NIVision.IMAQdxConfigureGrab(frontCam);
			NIVision.IMAQdxStartAcquisition(frontCam);
		}

		// Default camera is Front Camera
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new SeeWithCamera());
	}

	public static CameraVisionRedux getInstance() {
		return INSTANCE;
	}

	public void SeeingIsBelieving() {
		if (!failure) {
			NIVision.IMAQdxGrab(currCam, frame, 0);
			CameraServer.getInstance().setImage(frame);
		}
	}

	public void ChangeCamera() {
		if (!failure) {
			NIVision.IMAQdxStopAcquisition(currCam);
			NIVision.IMAQdxUnconfigureAcquisition(currCam);
			System.out.println("Switching Camera ID From" + currCam);
			currCam = (currCam == frontCam) ? backCam : frontCam;
			System.out.println("New Camera ID" + currCam);
			try {
				NIVision.IMAQdxConfigureGrab(currCam);
				NIVision.IMAQdxStartAcquisition(currCam);
			} catch (Exception e) {
				System.out.println("Failed changing cameras");
			}
		}
		// This Switches the camera by stopping the capture then switching then
		// restarting on a new camera.
	}

}
