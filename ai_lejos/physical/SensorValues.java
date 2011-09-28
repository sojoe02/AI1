package ai_lejos.physical;

import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;

public class SensorValues {
    
    //public static List<Integer> LightValues = Collections.synchronizedList(new ArrayList<Integer>());
    //public static List<Integer> TachoValues = Collections.synchronizedList(new ArrayList<Integer>());
    
    private static int[] LightValues = new int[3];
    private static int[] TachoValues = new int[3];
    
     //private static ArrayList<Integer> LightValues = new ArrayList<Integer>(10);
     
     //private static ArrayList<Integer> TachoValues = new ArrayList<Integer>(10);
     
     public static synchronized void setLightValue(int index, int value){
         //LightValues.add(index, value);
         LightValues[index] = value;
     }
     
     public static synchronized int getLightValue(int index){
         return LightValues[index];
         //return LightValues.get(index);
     }
     
          
     public static synchronized void setTachoValue(int index, int value){
         if (-value < 0){
             TachoValues[index]= 1;
         } else{
         TachoValues[index]=-value;
         }
         //TachoValues.add(index, value);
     }
     
     public static synchronized int getTachoValue(int index){
         return TachoValues[index];
         //return TachoValues.get(index);
     }
     
     
}
