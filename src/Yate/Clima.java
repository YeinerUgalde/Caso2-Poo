package Yate;
import Yate.Cronometro;
import java.util.ArrayList;
import Yate.Constantes;
import YateGui.YateMainFrame;
public class Clima extends Thread{

	  private ArrayList climas = new ArrayList<>();
	  private ArrayList climasint = new ArrayList<>();
	  private static float valorClima;
	  private int valor;
	  private YateMainFrame controlledFrame;
	
	  
	  public Clima(YateMainFrame pControlledFrame) {
		  this.controlledFrame = pControlledFrame;
	  }
	       
	  public void run() {
		  climas.add("Soleado");
		  climas.add("Nublado");
		  climas.add("Tormentoso");
		  
		  while (Cronometro.getTime()<Constantes.duracion) {
			  try {
				  
				  valor = (int) (Math.floor(Math.random() * 3));
				  if (valor==0) {
					  this.valorClima = 100.0f;
				  }
				  if (valor==1) {
					  this.valorClima = 70.0f;
				  }
				  if (valor==2) {
					  this.valorClima = 30.0f;
				  }
				  //System.out.println(climas.get(valor));
				  controlledFrame.setClima((String) climas.get(valor));
				  controlledFrame.setCapacidadPaneles(valorClima);
				  Thread.sleep(Math.round(Constantes.duracion*100));
		        
		      } 
		      catch (InterruptedException e) {}
			  
		  }
		 
	    
	  }
	  public static float getClima() {
		  return valorClima;
	  }

	  
}
