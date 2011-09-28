/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_lejos.behaviours;

import ai_lejos.interfaces.Constants;
import ai_lejos.physical.SensorValues;
import lejos.nxt.Motor;

/**
 *
 * @author sojoe
 */
public class ReleaseCan implements Constants {

    public ReleaseCan() {
        int oldtacho = SensorValues.getTachoValue(TachoA);

        Motor.A.setSpeed(MaxSpeed);
        Motor.B.setSpeed(MaxSpeed);
        

        Motor.A.backward();
        Motor.B.backward();

        boolean releasing = true;


        while (releasing) {

            if (SensorValues.getTachoValue(TachoA) - oldtacho >= TachoThressRelease) {
                Motor.A.stop();
                Motor.B.stop();
                //Motor.C.rotate(ReleaseAngle, true);
                Motor.C.rotateTo(ReleaseAngle);
                Motor.C.rotateTo(0);                
                releasing = false;               
                
                
            }
        }
        Motor.C.flt(true);

        //new Turn(true);
        //new Forward();
    }
}
