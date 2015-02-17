package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.commands.camera.SeeWithCamera;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class CameraVisionRedux extends Subsystem {
    private static final CameraVisionRedux INSTANCE = new CameraVisionRedux();
    Image frame;
    int frontCam;
    int backCam;
    int currCam;

    public CameraVisionRedux() {
	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	frontCam = NIVision.IMAQdxOpenCamera("cam0",
		NIVision.IMAQdxCameraControlMode.CameraControlModeListener);
	backCam = NIVision.IMAQdxOpenCamera("cam1",
		NIVision.IMAQdxCameraControlMode.CameraControlModeListener);
	currCam = frontCam;
	NIVision.IMAQdxConfigureGrab(frontCam);
	NIVision.IMAQdxStartAcquisition(frontCam);

	// Default camera is Front Camera
    }

    @Override
    protected void initDefaultCommand() {
	this.setDefaultCommand(new SeeWithCamera());
    }

    public static CameraVisionRedux getInstance() {
	return INSTANCE;
    }

    public void SeeingIsBelieving() {
	NIVision.IMAQdxGrab(currCam, frame, 0);
	CameraServer.getInstance().setImage(frame);
    }

    public void ChangeCamera() {
	NIVision.IMAQdxStopAcquisition(currCam);
	NIVision.IMAQdxUnconfigureAcquisition(currCam);
	System.out.println("Switching Camera ID From" + currCam);
	currCam = (currCam == frontCam) ? backCam : frontCam;
	System.out.println("New Camera ID" + currCam);
	NIVision.IMAQdxConfigureGrab(currCam);
	NIVision.IMAQdxStartAcquisition(currCam);
	// This Switches the camera by stopping the capture then switching then
	// restarting on a new camera.
    }

}
