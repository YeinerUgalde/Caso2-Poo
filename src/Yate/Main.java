package Yate;
import Energia.Bateria;
import Energia.Motor;
import Energia.PanelSolar;
import Yate.Consumo;
import Yate.Constantes;
import Yate.Clima;
import Yate.Cronometro;
import YateControllers.YateMainFrameController;
import YateGui.YateFrameThread;
import YateGui.YateMainFrame;

public class Main {
	public static void main(String[] args) {
		
		
		
		//----------------------------------------
		//BATERIAS
		Bateria bateria1 = new Bateria();
		Bateria bateria2 = new Bateria();
		//----------------------------------------
		
		//PANELES
		PanelSolar panel1 = new PanelSolar();
		PanelSolar panel2 = new PanelSolar();
		PanelSolar panel3 = new PanelSolar();
		//----------------------------------------
		panel1.setEnabled(true);
		panel2.setEnabled(true);
		panel3.setEnabled(true);
		//----------------------------------------
		
		
		
		//MOTOR
		Motor motor1 = new Motor();
		//----------------------------------------
		
		//----------------------------------------
		bateria1.conectarPanel(panel1);
		System.out.println("Se conecto la bateria 1 con el panel 1");
		bateria2.conectarPanel(panel2);
		System.out.println("Se conecto la bateria 2 y 3 con el panel 2");
		//----------------------------------------
		
		//----------------------------------------
		bateria1.setEnable(true);
		bateria2.setEnable(true);
		
		//----------------------------------------
		
		YateMainFrameController controller = new YateMainFrameController(bateria1);
		YateMainFrame yateWindow = new YateMainFrame("Yate simulation",controller);
		
		new Cronometro(controller.getFrameControlled()).start();
		new Clima(controller.getFrameControlled()).start();
		
		
		//----------------------------------------
		new YateFrameThread (bateria1, controller.getFrameControlled(),1).start();
		new YateFrameThread (bateria2, controller.getFrameControlled(),2).start();
		
		bateria1.cargarBateria(Constantes.velocidad_carga_bat);
		bateria2.cargarBateria(Constantes.velocidad_carga_bat);
		System.out.println("Se cargaron las baterias");
		//----------------------------------------
		
		
		//----------------------------------------
		motor1.setEnable(true);
		System.out.println("Se encendio el motor");
		
		
		System.out.println("El motor comenzo a consumir energia segun la velocidad del yate\n");
		
		
		new YateFrameThread (controller.getFrameControlled()).start();
		
		
		new Consumo(bateria1,Constantes.velocidad_en_sim, motor1).start();
		//new Consumo(bateria1,1000,motor1).start();
		
		
		
			
		
		
	}
}
