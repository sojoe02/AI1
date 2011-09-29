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

        //Motor.A.setAcceleration(180);
        //Motor.B.setAcceleration(180);



        Motor.A.forward();
        Motor.B.forward();
        boolean right = true;
        boolean left = true;


        while (drive == true) {
            //control of drivestate.

            if (SensorValues.getLightValue(LightSensorR) > LowLightThress && left == true) {
                //&& SensorValues.getLightValue(LightSensorL) < HighLightThress) {
                driveControl('l');
                LCD.drawString("LEFT   ", 0, 7);
                right = false;
                if (SensorValues.getLightValue(LightSensorR) < HighLightThress
                        && SensorValues.getLightValue(LightSensorL) < HighLightThress) {
                    driveControl('s');
                    LCD.drawString("STRAIGHT   <", 0, 7);
                    right = true;

                }
            }
            if (SensorValues.getLightValue(LightSensorL) > LowLightThress && right == true) {
                //&& SensorVaues.getLightValue(LightSensorL) > HighLightThress) {
                driveControl('r');
                LCD.drawString("RIGHT       ", 0, 7);
                left= false;
                if (SensorValues.getLightValue(LightSensorR) < HighLightThress
                        && SensorValues.getLightValue(LightSensorL) < HighLightThress) {
                    driveControl('s');
                    LCD.drawString("STRAIGHT   <", 0, 7);
                    left = true;
                }
                //else when you have reached a crosssection:
            }
            if (SensorValues.getLightValue(LightSensor3) < HighLightThress) {
                driveControl('e');
                LCD.drawString("Stopping            ", 0, 7);
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
            case 'l':
                Motor.A.setSpeed(CompensationSpeed);
                //Motor.B.setSpeed(MaxSpeed);
                break;
            case 'r':
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
                //Motor.A.setAcceleration(Integer.MAX_VALUE);
                //Motor.B.setAcceleration(Integer.MAX_VALUE);
                Motor.A.flt(true);
                Motor.B.flt(true);
                drift = false;
                //     }
            }
        }

    }
}
