package ai_lejos.physical;

import ai_lejos.interfaces.Constants;


public class SensorValues implements Constants{
    
    //public static List<Integer> LightValues = Collections.synchronizedList(new ArrayList<Integer>());
    //public static List<Integer> TachoValues = Collections.synchronizedList(new ArrayList<Integer>());
    
    private static int[] LightValues = new int[3];
    private static int[] TachoValues = new int[3];
    public static int lightR=0;
    public static int lightL=0;
    public static int light3=0;
    
    public static boolean[] HighDark = new boolean[3];
    
     //private static ArrayList<Integer> LightValues = new ArrayList<Integer>(10);
     
     //private static ArrayList<Integer> TachoValues = new ArrayList<Integer>(10);
     
     public static synchronized void setLightValue(int index, int value){
         //LightValues.add(index, value);         
         /*LightValues[index] = value;
         if(value < HighLightThress){
             HighDark[index] = true;
         } else HighDark[index] = false;
          * 
          */
         /*if(index == 1){
             light1 =value;
             
         }
         if(index==2){
             light2 =value;
             
         }
         if(index==3){
             lightlight3;
         }*/
     }
     
     public static synchronized int getLightValue(int index){
         return LightValues[index];
         //return LightValues.get(index);
     }
          
     public static synchronized void setTachoValue(int index, int value){
         //if (value < 0){
         //    TachoValues[index]= 1;
         //} else{
         TachoValues[index]=value;
         //}
         //TachoValues.add(index, value);
     }
     
     public static synchronized int getTachoValue(int index){
         return TachoValues[index];
         //return TachoValues.get(index);
     }
     
     
}
