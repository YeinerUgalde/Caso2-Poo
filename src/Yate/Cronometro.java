package Yate;
import Yate.Constantes;
import YateGui.YateMainFrame;
public class Cronometro extends Thread{
	private static int timer = 1;
	
	private YateMainFrame controlledFrame;
	  
	public Cronometro(YateMainFrame pControlledFrame) {
		this.controlledFrame = pControlledFrame;
	}
	       
	public void run() {
		
		
		while(timer < Constantes.duracion+1){ 
			
			try {
				
				controlledFrame.setCronometro(timer);
				Thread.sleep(1000);
				timer++;
				
				if (timer< Constantes.duracion/3) {
					Constantes.setVelocidadConstante(Constantes.velocidad_maxima_yate/9);
				}
				if (timer< Constantes.duracion/2) {
					Constantes.setVelocidadConstante(Constantes.velocidad_maxima_yate/7);
				}
				if (timer< Constantes.duracion/1.1) {
					Constantes.setVelocidadConstante(Constantes.velocidad_maxima_yate/3);
				}
				
				
				
			 } 
			 catch (InterruptedException e) {}
			  									
		}
		System.out.println("La simulacion finalizo");
		controlledFrame.setVisible(false);
		
		  
	}
	
	public static int getTime() {
		return timer;
	}
	
}