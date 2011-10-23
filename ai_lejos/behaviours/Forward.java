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

        //Motor.A.setAcceleration(280);
        //Motor.B.setAcceleration(280);



        Motor.A.forward();
        Motor.B.forward();
        boolean right = true;
        boolean left = true;


        while (drive == true) {
            //control of drivestate.

            if ((SensorValues.lightR < HighLightThress
                    && SensorValues.lightL < HighLightThress)
                    || SensorValues.light3 < HighLightThress) {
                driveControl('e');
                LCD.drawString("Stopping            ", 0, 7);
                drive = false;
            } 

                if (SensorValues.lightR < HighLightThress) {
                    //&& SensorValues.getLightValue(LightSensorL) < HighLightThress) {
                    driveControl('r');
                    LCD.drawString("RIGHT   ", 0, 7);

                }
                if (SensorValues.lightR > HighLightThress
                        && SensorValues.lightL > HighLightThress) {
                    driveControl('s');
                    LCD.drawString("STRAIGHT   <", 0, 7);
                }
                if (SensorValues.lightL < HighLightThress) {
                    //&& SensorVaues.getLightValue(LightSensorL) > HighLightThress) {
                    driveControl('l');
                    LCD.drawString("LEFT       ", 0, 7);
                

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
            if (SensorValues.getTachoValue(TachoA) - oldTacho > TachoThressStop) {
                Motor.A.flt(true);
                Motor.B.flt(true);
                drift = false;
            }
        }

    }
}
