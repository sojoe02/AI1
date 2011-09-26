package ai_lejos.physical;

import ai_lejos.logical.Instructor;

public class Control {

	public Control(Instructor instructor){
		SensorValues sensorValues = new SensorValues();
		SensorListener sensorListener = new SensorListener(sensorValues);
		Locomotion locomotion = new Locomotion(sensorValues, instructor);
		
		new Thread(sensorListener).start();
		new Thread(locomotion).start();
	}
	

}
