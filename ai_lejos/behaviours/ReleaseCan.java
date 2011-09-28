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
        Motor.A.resetTachoCount();

        Motor.A.setSpeed(MaxSpeed);
        Motor.B.setSpeed(MaxSpeed);

        Motor.A.backward();
        Motor.B.backward();
        
        

        if (-SensorValues.getTachoValue(TachoA) >= TachoThressRelease) {
            Motor.A.stop();
            Motor.B.stop();
            Motor.C.rotate(ReleaseAngle, true);
        }

        new Turn(true);
        new Forward();
    }
}
