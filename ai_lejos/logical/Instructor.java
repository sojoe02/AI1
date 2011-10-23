package ai_lejos.logical;

import ai_lejos.interfaces.Constants;
import ai_lejos.interfaces.PhysicalToLogical;

//import java.awt.Button;
import java.util.ArrayList;



public class Instructor implements PhysicalToLogical, Constants{
	int count = 0;
	ArrayList<Integer> instructions;

	public Instructor(){
		instructions = new ArrayList<Integer>();
                    
                for(int i = 0; i < 100; i++ ){     
                    
                    
                    
                instructions.add(FORWARD);
                //Button.waitForPress();
                
                
		//instructions.add(RELEASE);
                instructions.add(LEFT);
                
                //instructions.add(BREAK);
                }
               //instructions.add(FORWARD);
		//instructions.add(LEFT);
                /*instructions.add(FORWARD);
		instructions.add(RIGHT);
                instructions.add(FORWARD);
		instructions.add(RIGHT);  */       
                
                

                
                
                instructions.add(BREAK);
                
                
                //instructions.add(RELEASE);
	}

	@Override
	public int getNextInstruction() {
		int instruction = instructions.get(count);
		count++;
		return instruction;
	}

}
