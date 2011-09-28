package ai_lejos.physical;

import ai_lejos.interfaces.Constants;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class SensorListener implements Runnable, Constants {

    LightSensor s1;
    LightSensor s2;
    LightSensor s3;
    //SensorValues values;

    public SensorListener(SensorValues values) {
        s1 = new LightSensor(SensorPort.S1);
        s2 = new LightSensor(SensorPort.S2);
        s3 = new LightSensor(SensorPort.S3);
        //this.values = values;
    }

    @Override
    public void run() {
        while (true) {
            SensorValues.setLightValue(LightSensorR, s1.readValue());
            SensorValues.setLightValue(LightSensorL, s2.readValue());
            SensorValues.setLightValue(LightSensor3, s3.readValue());
            
            SensorValues.setTachoValue(TachoA, Motor.A.getTachoCount());
            SensorValues.setTachoValue(TachoB, Motor.B.getTachoCount());
            SensorValues.setTachoValue(TachoC, Motor.C.getTachoCount());
            


            LCD.drawString("LightSensor1: " + Integer.toString(SensorValues.getLightValue(LightSensorR)), 0, 0);
            LCD.drawString("LightSensor2: " + Integer.toString(SensorValues.getLightValue(LightSensorL)), 0, 1);
            LCD.drawString("LightSensor3: " + Integer.toString(SensorValues.getLightValue(LightSensor3)), 0, 2);
            
            LCD.drawString("TachoA " + Integer.toString(SensorValues.getTachoValue(TachoA)), 0, 3);
            LCD.drawString("TachoB " + Integer.toString(SensorValues.getTachoValue(TachoB)), 0, 4);
            LCD.drawString("TachoC " + Integer.toString(SensorValues.getTachoValue(TachoC)), 0, 5);
            
        }
    }
}
