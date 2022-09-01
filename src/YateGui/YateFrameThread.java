package YateGui;

import Energia.Bateria;
import Energia.Motor;
import Yate.Constantes;
import YateGui.YateMainFrame;
import Yate.Constantes;

public class YateFrameThread extends Thread{ 
	private Bateria bateria;
	private YateMainFrame controledFrame;
	private boolean val = false;
	private int num;
	
	
	public YateFrameThread(Bateria pBateria, YateMainFrame pControlled, int pNum) {
		this.bateria = pBateria;
		this.controledFrame = pControlled;
		this.num = pNum;
	}
	public YateFrameThread(YateMainFrame pControlled){
		this.controledFrame = pControlled;
		this.val=true;
	}
	    

	       
	public void run() {
		while (true) {
			if (!val) {
				try {
					Thread.sleep(100);
					controledFrame.setBatterylevel(bateria.getEnergyLevel(),num);
					//System.out.println(bateria.getEnergyLevel());
					}
				catch (InterruptedException e) {}
			}
			
			else {
				try {
					Thread.sleep(100);
					controledFrame.setVelocidad(Constantes.getVelocidadConstante());
					//System.out.println(Constantes.getVelocidadConstante());
					}
				catch (InterruptedException e) {}
			}
			
			
		}
		
		
	}
	
}


