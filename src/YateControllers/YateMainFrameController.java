package YateControllers;

import YateGui.YateFrameThread;
import YateGui.YateMainFrame;
import Yate.Constantes;
import Energia.Bateria;
import Yate.Main;

public class YateMainFrameController {
	private YateMainFrame controlledFrame;
	private Bateria bateria1;
	
	public YateMainFrameController(Bateria pBateria1) {
		this.bateria1 = pBateria1;
	
	}
	
	public void setWindow(YateMainFrame pFrame) {
		controlledFrame = pFrame;
		
		
		
	}
	public float getBatteryLevel() {
		return bateria1.getEnergyLevel();
	}
	
	public void acelerar() {
		Constantes.setVelocidadConstante(Constantes.velocidad_constante+Constantes.aumento_vel_x_aceleracion);
	}
	public void desacelerar() {
		Constantes.setVelocidadConstante(Constantes.velocidad_constante-Constantes.aumento_vel_x_aceleracion);
	}
	
	public YateMainFrame getFrameControlled() {
		return controlledFrame;
	}
}
