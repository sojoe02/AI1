/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_lejos.behaviours;

import ai_lejos.interfaces.Constants;
import ai_lejos.physical.SensorValues;
import lejos.nxt.LCD;
import lejos.nxt.Motor;

/**
 *
 * @author sojoe
 */
public class ReleaseCan implements Constants {

    public ReleaseCan() {

        Motor.A.setSpeed(MaxSpeed);
        Motor.B.setSpeed(MaxSpeed);


        Motor.A.forward();
        Motor.B.forward();

        boolean releasing = true;
        boolean right = true;
        boolean left = true;


        

            while (releasing == true) {
                 //control of drivestate.
            if (SensorValues.getLightValue(LightSensorR) < HighLightThress) {
                //&& SensorValues.getLightValue(LightSensorL) < HighLightThress) {
                driveControl('r');
                LCD.drawString("RIGHT   ", 0, 7);
                
            }
            if (SensorValues.getLightValue(LightSensorR) > HighLightThress
                    && SensorValues.getLightValue(LightSensorL) > HighLightThress) {
                driveControl('s');
                LCD.drawString("STRAIGHT   <", 0, 7);                
            }
            if (SensorValues.getLightValue(LightSensorL) < HighLightThress) {
                //&& SensorVaues.getLightValue(LightSensorL) > HighLightThress) {
                driveControl('l');
                LCD.drawString("LEFT       ", 0, 7);                
            }
            if ((SensorValues.getLightValue(LightSensorL) < HighLightThress && 
                    SensorValues.getLightValue(LightSensorR) < HighLightThress) || 
                    SensorValues.getLightValue(LightSensor3) <HighLightThress) {
                driveControl('e');
                LCD.drawString("Stopping            ", 0, 7);
                releasing = false;
            }
            
        }
    }

    private void driveControl(char drivestate) {

        switch (drivestate) {
            case 's':
                Motor.A.setSpeed(MaxSpeed);
                Motor.B.setSpeed(MaxSpeed);
                break;
            case 'l':
                Motor.A.setSpeed(CompensationSpeed);
               
                break;
            case 'r':
                
                Motor.B.setSpeed(CompensationSpeed);
                break;
            case 'e':
                backUp();
                break;
            default:
                break;
        }
    }

    private void backUp() {
        
        Motor.A.stop(true);
        Motor.B.stop();
        
         Motor.A.setSpeed(MaxSpeed);
                Motor.B.setSpeed(MaxSpeed);
        
        boolean backup = true;
        int oldTacho = SensorValues.getTachoValue(TachoA);
        while (backup == true) {
            LCD.drawString("Goingoinggoing           ", 0, 7);

            Motor.A.backward();
            Motor.B.backward();
            if (oldTacho - SensorValues.getTachoValue(TachoA)  > TachoThressRelease) {
                LCD.drawString("STOPPING            ", 0, 7);
                backup = false;  
                
            }

        }
        Motor.A.stop(true);
        Motor.B.stop();

        new Turn(true);
        new Forward();
    }
}
