package ai_lejos.physical;

import ai_lejos.interfaces.Constants;

import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;

public class SensorListener implements Runnable, Constants {

    LightSensor s1;
    LightSensor s2;
    LightSensor s3;
    //SensorValues values;

    public SensorListener(SensorValues values, LightSensor s1, LightSensor s2, LightSensor s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
  
        //this.values = values;
    }

    @Override
    public void run() {
        while (true) {
            SensorValues.setLightValue(LightSensorR, s1.getLightValue());
            SensorValues.setLightValue(LightSensorL, s2.getLightValue());
            SensorValues.setLightValue(LightSensor3, s3.getLightValue());
            
            
            
            
            SensorValues.setTachoValue(TachoA, Motor.A.getTachoCount());
            SensorValues.setTachoValue(TachoB, Motor.B.getTachoCount());
            SensorValues.setTachoValue(TachoC, Motor.C.getTachoCount());
            


            LCD.drawString("LightSensorR: " + Integer.toString(SensorValues.getLightValue(LightSensorR)), 0, 0);
            LCD.drawString("LightSensorL: " + Integer.toString(SensorValues.getLightValue(LightSensorL)), 0, 1);
            LCD.drawString("LightSensor3: " + Integer.toString(SensorValues.getLightValue(LightSensor3)), 0, 2);
            
            LCD.drawString("TachoA " + Integer.toString(SensorValues.getTachoValue(TachoA)), 0, 3);
            LCD.drawString("TachoB " + Integer.toString(SensorValues.getTachoValue(TachoB)), 0, 4);
            LCD.drawString("TachoC " + Integer.toString(SensorValues.getTachoValue(TachoC)), 0, 5);
            
        }
    }
}
