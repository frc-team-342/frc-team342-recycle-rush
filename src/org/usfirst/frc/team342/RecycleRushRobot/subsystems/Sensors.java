package org.usfirst.frc.team342.RecycleRushRobot.subsystems;

import org.usfirst.frc.team342.RecycleRushRobot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import static org.usfirst.frc.team342.RecycleRushRobot.RobotMap.*;

public class Sensors extends Subsystem {
	private static final Sensors INSTANCE = new Sensors();
	private static final I2C.Port PORT = I2C.Port.kOnboard;
	
	private I2C accelerometer;
	private I2C gyro;
	private I2C compass;
	private byte[] readBytes = new byte[2];
	private int readAddress;
	private double[] offset = new double[3];
	
	public static Sensors getInstance() {
		return INSTANCE;
	}

	private Sensors() {
		super();
		
	}

	@Override
	protected void initDefaultCommand() {

	}
	
	public void initializeAccelerometer() {
		accelerometer = new I2C(PORT, ACCELEROMETER_ADDRESS);
		accelerometer.write(ACCELEROMETER_REG_POWERCTL + 0x80, 8);
	}
	
	public double accelerometerGetAxes(int axis){
		readAddress = 2 * axis;
		accelerometer.read(ACCELEROMETER_REG_AXES, 2, readBytes);
		return combineBytes(readBytes[0], readBytes[1]) * GsPerLSB;
	}

	public void initializeGyro() {
		gyro = new I2C(PORT, GYRO_ADDRESS);
		gyro.write(GYRO_REG_DLPFFS + 0x80, 0x18);
		
		//loop to initialize the offset of the gyro
		for(int i = 0; i < 3; i++){
			offset[i] = 0;
			offset[i] = this.gyroGetAxes(i);
		}
	}
	
	public double gyroGetAxes(int axis){
		readAddress = 2 * axis;
		gyro.read(GYRO_REG_AXES, 2, readBytes);
		// High order bits are different for the gyro than the accelerometer
		return (combineBytes(readBytes[1], readBytes[0]) * degreesPerLSB) - offset[axis];	//not sure about units
	}
	
	public void initializeCompass() {
		// I am not ready to do this yet
	}
	
	public double compassGetAxes(int axis){
		// I am not ready to do this yet
		return -999999999.0;
	}
	
	//math to combine two bytes, used to calculate total G's with two bytes of input data
	//taken from ADXL345_I2C.java
	private double combineBytes(byte first, byte second) {
		short tempLow = (short) (first & 0xff);	// templow is the low order byte
		short tempHigh = (short) ((second << 8) & 0xff00);	//temphigh is the high order byte
		return (tempLow | tempHigh);
	}
	
	
}
