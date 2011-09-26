package ai_lejos.physical;

import ai_lejos.interfaces.Constants;
import lejos.nxt.*;
import ai_lejos.logical.Instructor;

public class Locomotion implements Runnable, Constants{
	SensorValues values;
	Instructor instructor;

	public Locomotion(SensorValues values, Instructor instructor){
		this.values = values;
		this.instructor = instructor;
	}

	@Override
	public void run() {
		try {
			int behavior = instructor.getNextInstruction();

			switch (behavior) {
			case FORWARD:
				forward();
				break;
			case LEFT:
				left();
				break;
			case RIGHT:
				right();
				break;
			default:
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	} 

	public void forward() throws InterruptedException{
		//Motor.A.forward();
		//Motor.B.forward();
		Button.waitForPress();
	}

	private void left(){

	}

	private void right(){

	}





}
