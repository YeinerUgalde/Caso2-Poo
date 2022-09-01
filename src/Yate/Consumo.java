package Yate;
import Yate.Constantes;
import Energia.Bateria;
import Energia.Motor;


public class Consumo extends Thread{
	
	private float consumo;
	private Bateria bateria;
	private Motor motor;
	private int vel = 0;
	private boolean mot =false;
	
	public Consumo(Bateria bateria) {
		try {
			Thread.sleep(2000);
			}
		catch (InterruptedException e) {}
		
		if (bateria!=null) {
			bateria.cargarBateria(Constantes.velocidad_carga_bat);
		}
		
	}
	    
	public Consumo(Bateria pBateria, float pConsumo) {
		this.consumo = pConsumo;
		this.bateria = pBateria;
		this.vel= Constantes.velocidad_consumo;
	}
	
	public Consumo(Bateria pBateria, float pConsumo, int pVel) {
		this.consumo = pConsumo;
		this.bateria = pBateria;
		this.vel = pVel;
	}
	
	public Consumo(Bateria pBateria, int pVel, Motor pMotor) {
		this.mot = true;
		this.bateria = pBateria;
		this.vel = pVel;
		this.motor = pMotor;

	}
	
	       
	public void run() {
		if (bateria !=null && !mot) {
			bateria.consumirEnergia(consumo, vel);
			//System.out.println(bateria.getEnergyLevel());
		}
		else {
			if (bateria.getEnable()) {
				while(bateria.getEnergyLevel()>0 && bateria.getEnable()) {
					bateria.consumirEnergia(motor.getConsumo_x_motor(Constantes.velocidad_constante), Math.round(vel/motor.getConsumo_x_motor(Constantes.velocidad_constante)));
					if (motor.isEnable()==false) {
						System.out.println("El motor se apago");
						break;
					}
				}
			
			}
			
		}
		
	}
	
	    
}
	  
	  


