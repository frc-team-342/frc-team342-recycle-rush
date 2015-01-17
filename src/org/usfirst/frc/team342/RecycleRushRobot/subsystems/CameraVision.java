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

public class CameraVision extends Subsystem {
    private static final CameraVision INSTANCE = new CameraVision();
    int session;
    Image frame;
    NIVision.Rect rect;

    
    public CameraVision() {
		  frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	        session = NIVision.IMAQdxOpenCamera("cam0",
	        NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	        NIVision.IMAQdxConfigureGrab(session);
	        NIVision.IMAQdxStartAcquisition(session);
	        rect = new NIVision.Rect(10, 10, 100, 100);
    }

    
    
	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new SeeWithCamera());
		// TODO Auto-generated method stub
		
	}
	
    public static CameraVision getInstance() {
        return INSTANCE;
    }

	
	public void SeeingIsBelieving(){
        NIVision.IMAQdxGrab(session, frame, 1);
        NIVision.imaqDrawShapeOnImage(frame, frame, rect,
        DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
       CameraServer.getInstance().setImage(frame);
	}
	
	public void StopSeeingIsBelieving(){
        NIVision.IMAQdxStopAcquisition(session);
	}


	

}
