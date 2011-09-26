package ai_lejos.physical;

public class SensorValues {
	
	int sensorValue[] = new int[7];
	
	public synchronized void setSensorValue(int sensor, int value){
		sensorValue[sensor] = value;
	}
	
	public synchronized int getSensorValue(int sensor){
		return (sensorValue[sensor]);
	}

}
