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

    public Turn(boolean left) {


        if (left) {
            left();
        } else {
            right();
        }

        Motor.A.flt(true);
        Motor.B.flt(true);

    }

    private void right() {
        Motor.A.setSpeed(TurnSpeed);
        Motor.B.setSpeed(TurnSpeed);
        //start the engines:
        Motor.B.backward();
        Motor.A.forward();
        boolean turn = true;


        int next = 0;

        while (turn == true) {
            if (SensorValues.getLightValue(LightSensorR) > HighLightThress && next == 0) {
                LCD.drawString("LightsensorR black", 0, 7);
                next = 1;
            }

            if (SensorValues.getLightValue(LightSensorR) < HighLightThress && next == 1) {
                LCD.drawString("LightsensorR black", 0, 7);
                next = 2;
            }

            if (SensorValues.getLightValue(LightSensor3) < LowLightThress && next == 2) {
                turn = false;
            }

        }



    }

    private void left() {
        Motor.B.setSpeed(TurnSpeed);
        Motor.A.setSpeed(TurnSpeed);
        //start the engines:
        Motor.A.backward();
        Motor.B.forward();
        boolean turn = true;

        int next = 0;

        while (turn == true) {
            if (SensorValues.getLightValue(LightSensorL) > HighLightThress && next == 0) {
                LCD.drawString("LightsensorL black", 0, 7);
                next = 1;
            }

            if (SensorValues.getLightValue(LightSensorL) < HighLightThress && next == 1) {
                LCD.drawString("LightsensorL black", 0, 7);
                next = 2;
            }

            if (SensorValues.getLightValue(LightSensor3) < LowLightThress && next == 2) {
                turn = false;
            }

        }
    }
}
