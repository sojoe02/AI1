package ai_lejos;

import ai_lejos.logical.*;
import ai_lejos.physical.*;

public class AI_lejos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Instructor instructor = new Instructor();
		Control control = new Control(instructor);
	}

}