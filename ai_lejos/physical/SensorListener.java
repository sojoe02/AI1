package ai_lejos.physical;

import ai_lejos.interfaces.Constants;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class SensorListener implements Runnable, Constants{
	LightSensor s1;
	LightSensor s2;
	LightSensor s3;
	SensorValues values;

	public SensorListener(SensorValues values){
		s1 = new LightSensor(SensorPort.S1);
		s2 = new LightSensor(SensorPort.S2);
		s3 = new LightSensor(SensorPort.S3);
		this.values = values;
	}

	@Override
	public void run() {
		while(true){
			values.setSensorValue(LightSensor1, s1.readValue());
			values.setSensorValue(LightSensor2, s2.readValue());
			values.setSensorValue(LightSensor3, s3.readValue());

			LCD.drawString("S1 " + Integer.toString(values.getSensorValue(LightSensor1)), 0, 0);
			LCD.drawString("S2 " + Integer.toString(values.getSensorValue(LightSensor2)), 0, 1);
			LCD.drawString("S3 " + Integer.toString(values.getSensorValue(LightSensor3)), 0, 2);
		}
	}

}
