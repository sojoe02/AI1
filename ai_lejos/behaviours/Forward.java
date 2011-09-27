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
        
        Motor.A.backward();
        Motor.B.backward();


        while (drive == true) {
            //control of drivestate.
            if (SensorValues.LightValues.get(LightSensorR) < HighLightThress
                    && SensorValues.LightValues.get(LightSensorL) < HighLightThress) {
                driveControl('s');
            } else if (SensorValues.LightValues.get(LightSensorR) > HighLightThress
                    && SensorValues.LightValues.get(LightSensorL) < HighLightThress) {
                driveControl('r');
            } else if (SensorValues.LightValues.get(LightSensorR) < HighLightThress
                    && SensorValues.LightValues.get(LightSensorL) > HighLightThress) {
                driveControl('l');
                //else when you have reached a crosssection:
            } else if (SensorValues.LightValues.get(LightSensorR) > HighLightThress
                    && SensorValues.LightValues.get(LightSensorL) > HighLightThress) {
                driveControl('s');
                drive = false;
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
                Motor.A.setSpeed(MediumSpeed);
                Motor.B.setSpeed(MaxSpeed);
                break;
            case 'l':
                Motor.A.setSpeed(MaxSpeed);
                Motor.B.setSpeed(MediumSpeed);
                break;
            case 'e':
                boolean drift = true;
                Motor.A.resetTachoCount();
                while (drift) {
                    if (-SensorValues.TachoValues.get(TachoA) > TachoThressStop) {
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
