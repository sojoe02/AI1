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
            SensorValues.LightValues.set(LightSensor1, s1.readValue());
            SensorValues.LightValues.set(LightSensor2, s2.readValue());
            SensorValues.LightValues.set(LightSensor3, s3.readValue());
            
            SensorValues.TachoValues.set(TachoA, Motor.A.getTachoCount());
            SensorValues.TachoValues.set(TachoB, Motor.B.getTachoCount());
            SensorValues.TachoValues.set(TachoC, Motor.C.getTachoCount());
            


            LCD.drawString("LightSensor1: " + Integer.toString(SensorValues.LightValues.get(LightSensor1)), 0, 0);
            LCD.drawString("LightSensor2: " + Integer.toString(SensorValues.LightValues.get(LightSensor2)), 0, 1);
            LCD.drawString("LightSensor3: " + Integer.toString(SensorValues.LightValues.get(LightSensor3)), 0, 2);
            
            LCD.drawString("TachoA " + Integer.toString(SensorValues.TachoValues.get(TachoA)), 0, 3);
            LCD.drawString("TachoB " + Integer.toString(SensorValues.TachoValues.get(TachoB)), 0, 4);
            LCD.drawString("TachoC " + Integer.toString(SensorValues.TachoValues.get(TachoC)), 0, 5);
            
        }
    }
}
