/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_lejos.behaviours;

import ai_lejos.interfaces.*;
import ai_lejos.physical.SensorValues;
import lejos.nxt.LCD;
import lejos.nxt.Motor;

/**
 *
 * @author sojoe
 */
public class Forward implements Constants {

    public Forward() {

        boolean drive = true;

        Motor.A.setSpeed(MaxSpeed);
        Motor.B.setSpeed(MaxSpeed);

        Motor.A.backward();
        Motor.B.backward();


        while (drive == true) {
            //control of drivestate.
            if (SensorValues.getLightValue(LightSensorR) > HighLightThress
                    && SensorValues.getLightValue(LightSensorL) > HighLightThress) {
                driveControl('s');
                LCD.drawString("Driving straight", 0, 7);

            } 
            if (SensorValues.getLightValue(LightSensorR) < HighLightThress
                    && SensorValues.getLightValue(LightSensorL) > HighLightThress) {
                driveControl('r');
                LCD.drawString("Driving right", 0, 7);
            } 
            if (SensorValues.getLightValue(LightSensorR) > HighLightThress
                    && SensorValues.getLightValue(LightSensorL) < HighLightThress) {
                driveControl('l');
                LCD.drawString("Driving left", 0, 7);
                //else when you have reached a crosssection:
            }
            if (SensorValues.getLightValue(LightSensorR) < HighLightThress && SensorValues.getLightValue(LightSensorL) <HighLightThress) {
                driveControl('e');
                LCD.drawString("Stopping            ", 0, 7);
                break;
                //drive = false;
            }
        }

    }

    private void driveControl(char drivestate) {

        switch (drivestate) {
            case 's':
                Motor.A.setSpeed(MaxSpeed);
                Motor.B.setSpeed(MaxSpeed);
                break;
            case 'r':
                Motor.A.setSpeed(CompensationSpeed);
                //Motor.B.setSpeed(MaxSpeed);
                break;
            case 'l':
                //Motor.A.setSpeed(MaxSpeed);
                Motor.B.setSpeed(CompensationSpeed);
                break;
            case 'e':
                drift();
                break;
            default:
                break;
        }
    }

    private void drift() {
        boolean drift = true;


        int oldTacho = SensorValues.getTachoValue(TachoA);

        while (drift) {
            // if (SensorValues.getTachoValue(TachoA) > 0) {
            if (SensorValues.getTachoValue(TachoA) - oldTacho > TachoThressStop) {
                Motor.A.flt(true);
                Motor.B.flt(true);
                drift = false;
                //     }
            }
        }

    }
}
