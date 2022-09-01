package Energia;

import Yate.Clima;

public class Bateria {

	public boolean enabled = false;

	private float energyLevel;
	private String brand; 
	private PanelSolar panel;
	private boolean charging = false;
	
	
	public void setEnable(boolean pEnabled) {
		this.enabled = pEnabled;
	}
	
	public boolean getEnable() {
		return enabled;
	}
	
	public void consumirEnergia(float pRequest, int pVel) {
		/*if (energyLevel>pRequest) {
			result = pRequest;
			energyLevel = energyLevel - pRequest;  // energyLevel-=pRequest;
		}
		*/
		if (this.enabled) {
			try {
				while (energyLevel>0 && pRequest != 0) {
					energyLevel = energyLevel - 1;
					pRequest = pRequest - 1;
					Thread.sleep(pVel);
					//System.out.println(energyLevel);
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		else {
			System.out.println("No se puede usar la bateria debido a que no esta encendida");
		}
		
		
	}

	public void setBrand(String pBrand) {
		this.brand = pBrand;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	private void alertBreakCircuit() {
		this.enabled = false;
	}
	
	public void conectarPanel(PanelSolar pPanel) {
		this.panel = pPanel;
	}
	
	public void detenerCarga() {
		charging = false;
	}
	
	public void cargarBateria(int pVelocidadCarga) {
		if (this.panel!=null && this.panel.isEnabled()) {
			charging = true;
			//int cuenta = 0;
			for(;charging;) {
				try {		
					panel.setCapacity(Clima.getClima());
					
					energyLevel+=panel.getCapacity()/100;
					Thread.sleep(pVelocidadCarga); 
					//System.out.println("Nivel actual de bateria "+energyLevel);
					
					//cuenta++; 
					
					if (energyLevel>=100) {
						System.out.println("Carga finalizada" + "\n");
						this.detenerCarga();
					}
				} 
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} else {
			System.out.println("No puedo cargar la batería porque no hay un panel conectado");
		}
	}
	
	public float getEnergyLevel() {
		return energyLevel;
	}
	
	
}
