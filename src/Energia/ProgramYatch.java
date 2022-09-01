package Energia;
import java.util.Collection;
import java.util.ArrayList;
import Refrigeracion.AireAcondicionado;
import Yate.Elemento;
import Energia.Motor;
import Yate.Cronometro;
import Yate.Clima;
import Yate.Constantes;
import Yate.Consumo;

public class ProgramYatch {

	public static void main(String[] args) {
		
		
		
		
		Bateria bateria = new Bateria();
		Bateria otrabateria = new Bateria();
		
		bateria.setBrand("Nokia");
		otrabateria.setBrand("Samsung");
		
		Bateria another = otrabateria;
		
/*		another.setBrand("Motorola");
		
		System.out.println("bateria -> "+bateria.getBrand());
		System.out.println("otrabateria -> "+otrabateria.getBrand());
		System.out.println("another -> "+another.getBrand());
		
		System.out.println("=======================================");
*/		
		PanelSolar panel = new PanelSolar();
		panel.setEnabled(true);
		System.out.println(panel.getCapacity() + " " +panel.getModelo()+" "+ panel.isEnabled());
/*		
		PanelSolar panel2 = new PanelSolar("SuperEnergia", "SE 2030");
		System.out.println(panel2.getCapacity() + " " +panel2.getModelo());
	*/	
		
		bateria.conectarPanel(panel);
		bateria.cargarBateria(10);
		//bateria.cargarBateria(100.0f);
		
		Elemento PlayStation = new Elemento("PlayStation", 100);
		System.out.println(PlayStation.getConsumo());
		PlayStation.setActivo(true);
		/*
		int con = 0;
		while(PlayStation.isActivo()== true) {
			new Consumo(bateria,PlayStation.getConsumo()).start();
			//bateria.consumirEnergia(PlayStation.getConsumo(),10);
			con++;
			//System.out.println(bateria.getEnergyLevel()+"nivel");
			if (con==2) {PlayStation.setActivo(false);};
			//bateria.apagar();
		}
		*/
		Motor motor1 = new Motor();
		
		motor1.setEnable(true);
		new Consumo(bateria, 100, motor1).start();
		
		System.out.println(Constantes.getVelocidadConstante() + " vel ");
		System.out.println(motor1.getConsumo_x_motor(Constantes.getVelocidadConstante())+ " con");
		//new Consumo(bateria,PlayStation.getConsumo(),250).start();
		
		
		
		new Consumo(bateria).start();
	    
		
		
		
		
		
		


		
		
		
		
		
		
		
		System.out.println("========================");
		
		System.out.println(bateria.getEnergyLevel());
		System.out.println(panel.getCapacity() + " " +panel.getModelo()+" "+ panel.isEnabled());
	}
}
