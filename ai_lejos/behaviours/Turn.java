/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_lejos.behaviours;

import lejos.nxt.*;
import ai_lejos.interfaces.Constants;
import ai_lejos.physical.SensorValues;

/**
 *
 * @author sojoe
 */
public class Turn implements Constants {

    int SavedS1;
    int SavedS2;

    public Turn(boolean left) {

        SavedS1 = 0;
        SavedS2 = 0;

        if (left) {
            left();
        }
        right();
        
        Motor.A.stop();
        Motor.B.stop();

    }

    private void right() {
        Motor.A.setSpeed(SlowSpeed);
        Motor.B.setSpeed(SlowSpeed);
        //start the engines:
        Motor.B.backward();
        Motor.A.forward();
        boolean turn = true;

        while (turn == true) {
            if (SensorValues.getLightValue(LightSensorL) < HighLightThress) {
                
                if (SensorValues.getLightValue(LightSensorR) < HighLightThress) {
                    
                    if (SensorValues.getLightValue(LightSensorR) > HighLightThress) {
                        turn = false;
                    }
                }
            }
        }



    }

    private void left() {
        Motor.B.setSpeed(SlowSpeed);
        Motor.A.setSpeed(SlowSpeed);
        //start the engines:
        Motor.A.backward();
        Motor.B.forward();
        boolean turn = true;

        while (turn == true) {
            if (SensorValues.getLightValue(LightSensorR) < HighLightThress) {
                
                if (SensorValues.getLightValue(LightSensorL) < HighLightThress) {
                    
                    if (SensorValues.getLightValue(LightSensorL) > HighLightThress) {
                        turn = false;
                    }
                }
            }
        }

    }
}
