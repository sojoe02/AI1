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

    }

    private void left() {
        Motor.A.setSpeed(SlowSpeed);
        Motor.B.setSpeed(SlowSpeed);
        //start the engines:
        Motor.A.backward();
        Motor.B.forward();
        boolean turn = true;

        while (turn == true) {
            if (SensorValues.LightValues.get(LightSensor1) > HighLightThress) {
                SavedS1 = 1;
                if (SensorValues.LightValues.get(LightSensor2) > HighLightThress) {
                    SavedS2 = 1;
                    if (SensorValues.LightValues.get(LightSensor2) < HighLightThress) {
                        turn = false;
                    }
                }
            }
        }



    }

    private void right() {
        Motor.B.setSpeed(SlowSpeed);
        Motor.A.setSpeed(SlowSpeed);
        //start the engines:
        Motor.B.backward();
        Motor.A.forward();
        boolean turn = true;

        while (turn == true) {
            if (SensorValues.LightValues.get(LightSensor2) > HighLightThress) {
                SavedS1 = 1;
                if (SensorValues.LightValues.get(LightSensor1) > HighLightThress) {
                    SavedS2 = 1;
                    if (SensorValues.LightValues.get(LightSensor1) < HighLightThress) {
                        turn = false;
                    }
                }
            }
        }

    }
}
