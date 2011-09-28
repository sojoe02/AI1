package ai_lejos.physical;

import ai_lejos.interfaces.Constants;
//import lejos.nxt.*;
import ai_lejos.logical.Instructor;
import ai_lejos.behaviours.*;
//import lejos.robotics.subsumption.Behavior;

public class Locomotion implements Runnable, Constants{
	SensorValues values;
	Instructor instructor;

	public Locomotion(SensorValues values, Instructor instructor){
		this.values = values;
		this.instructor = instructor;
	}

	@Override
	public void run() {
            boolean fetchInstructions = true;
            while(fetchInstructions){
		try {
			int behavior = instructor.getNextInstruction();

			switch (behavior) {
			case FORWARD:
				new Forward();
				break;
			case LEFT:
				new Turn(true);
				break;
			case RIGHT:				
                                new Turn(false);
				break;
                        case RELEASE:
                                new ReleaseCan();
                                break;
                        case BREAK:
                            fetchInstructions = false;
                            break;
                                
			default:
				break;
			}
                

		} catch (Exception e) {
			// TODO: handle exception
		}
            }
            

	} 







}
