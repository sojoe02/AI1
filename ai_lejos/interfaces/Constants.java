package ai_lejos.interfaces;

public interface Constants {
	public static final int FORWARD = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	public static final int LightSensor1 = 0;
	public static final int LightSensor2 = 1;
	public static final int LightSensor3 = 2;
	public static final int TachoA = 0;
	public static final int TachoB = 1;
	public static final int TachoC = 2;
        
 /*
 
S1,S2 = sensor 1 and 2.
MA,MB = motor A and B.
TMA, TMB = tacometer
--
S*(0)=LowLight=?
S*(1)=HighLight=?
--
M*(0)=Stop(0%)
M*(1)=SlowSpeed(30%)
M*(2)=MediumSpeed(90%)
M*(3)=MaxSpeed(100%)
--
TM*(1)=TachoThresshold(200)*/        
        public static final int LowLightThress = 30;
        public static final int HighLightThress = 50;
        
        public static final int Stop = 0;
        public static final int SlowSpeed=30;
        public static final int MediumSpeed=90;
        public static final int MaxSpeed=100;
        
        public static final int TachoThressStop=20;
	
}
