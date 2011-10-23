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

        Motor.A.stop(true);
        Motor.B.stop(true);

    }

    private void right() {
        Motor.A.setSpeed(TurnSpeed);
        Motor.B.setSpeed(TurnSpeed);
        //start the engines:
        Motor.B.forward();
        Motor.A.backward();
        boolean turn = true;


        int next = 0;

        while (turn == true) {
            if (SensorValues.lightL < LowLightThress && next == 2) {
                turn = false;
            }
            
            if (SensorValues.light3 < HighLightThress && next == 0) {
                LCD.drawString("LightsensorR black", 0, 7);
                next = 1;
            }

            if (SensorValues.lightR < LowLightThress && next == 1) {
                LCD.drawString("LightsensorR black", 0, 7);
                //turn = false;
                next = 2;
            }

            
        }



    }

    private void left() {
        Motor.B.setSpeed(TurnSpeed);
        Motor.A.setSpeed(TurnSpeed);
        //start the engines:
        Motor.A.forward();
        Motor.B.backward();
        boolean turn = true;

        int next = 0;

        while (turn == true) {
            if (SensorValues.lightL < LowLightThress && next == 1) {
                LCD.drawString("LightsensorL black", 0, 7);
                next = 2;
                //turn=false;
            }
            if (SensorValues.lightL > LowLightThress && next == 2) {
                LCD.drawString("LightsensorL black", 0, 7);
                turn = false;                
            }
            if (SensorValues.light3 < HighLightThress && next == 0) {
               next = 1;
            }

        }
    }
}
