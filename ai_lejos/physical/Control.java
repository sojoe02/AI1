package ai_lejos.physical;

import ai_lejos.logical.Instructor;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.*;
import lejos.nxt.SensorPort;

public class Control {

    public Control(Instructor instructor) {

        LightSensor s1;
        LightSensor s2;
        LightSensor s3;
        
        
        

        s1 = new LightSensor(SensorPort.S1);
        s2 = new LightSensor(SensorPort.S2);
        s3 = new LightSensor(SensorPort.S3);      
        
        /*LCD.drawString("cal. RCL LOW", 0, 6);
        Button.waitForPress();
        s1.calibrateLow();
        s2.calibrateLow();
        s3.calibrateLow();
        
        LCD.drawString("cal. RCL HIGH", 0, 6);
        Button.waitForPress();
        s1.calibrateHigh();
        s2.calibrateHigh();
        s3.calibrateHigh();*/
        
        
        LCD.drawString("calibrations complete", 0, 6);

        SensorValues sensorValues = new SensorValues();
        SensorListener sensorListener = new SensorListener(sensorValues,s1,s2,s3);
        Locomotion locomotion = new Locomotion(sensorValues, instructor);

        new Thread(sensorListener).start();
        Button.waitForPress();
        new Thread(locomotion).start();
    }
}
