/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_lejos.behaviours;

import ai_lejos.interfaces.*;
import ai_lejos.physical.SensorValues;
import lejos.nxt.Motor;

/**
 *
 * @author sojoe
 */
public class Forward implements Constants {

    public Forward() {

        boolean drive = true;
        char control = 's';
        int previous = 1;


        while (drive == true) {
            //control of drivestate.
            if (SensorValues.LightValues.get(LightSensorR) < HighLightThress
                    && SensorValues.LightValues.get(LightSensorL) < HighLightThress) {
                control = 's';
            } else if (SensorValues.LightValues.get(LightSensorR) > HighLightThress
                    && SensorValues.LightValues.get(LightSensorL) < HighLightThress) {
                control = 'l';
            } else if (SensorValues.LightValues.get(LightSensorR) < HighLightThress
                    && SensorValues.LightValues.get(LightSensorL) > HighLightThress) {
                control = 'r';
                //else when you have reached a crosssection:
            } else if (SensorValues.LightValues.get(LightSensorR) > HighLightThress
                    && SensorValues.LightValues.get(LightSensorL) > HighLightThress) {
                control = 'e';
                drive = false;
            }


        }

        switch (control) {
            case 's':
                driveControl('s');
                break;
            case 'l':
                driveControl('l');
                break;
            case 'r':
                driveControl('r');
                break;
            case 'e':
                driveControl('e');
                break;
            default:
                break;
        }

        //drivestate switch.

    }

    private void driveControl(char drivestate) {

        switch (drivestate) {
            case 's':
                Motor.A.setSpeed(MaxSpeed);
                Motor.B.setSpeed(MaxSpeed);
                break;
            case 'l':
                Motor.A.setSpeed(MediumSpeed);
                Motor.B.setSpeed(MaxSpeed);
                break;
            case 'r':
                Motor.A.setSpeed(MaxSpeed);
                Motor.B.setSpeed(MediumSpeed);
                break;
            case 'e':
                boolean drift = true;
                Motor.A.resetTachoCount();
                while(drift){
                    if(SensorValues.TachoValues.get(TachoA) > TachoThressStop){
                        Motor.A.stop();
                        Motor.B.stop();
                        drift = false;
                    }
                    
                }
            default:
                break;
        }
    }
}
