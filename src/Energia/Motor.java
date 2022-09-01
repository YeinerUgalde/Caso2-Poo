package Energia;

import Yate.Constantes;
import java.util.List;

public class Motor {
	private String modelo;
	private String serie;
	private String marca;
	private float consumo_min = Constantes.consumo_minimo_motor;
	private float consumo_max = Constantes.consumo_maximo_motor;
	private float vel_max = Constantes.velocidad_maxima_yate;
	private float vel_constante;

	private boolean enable;
	
	
	public Motor() {
		this.setModelo(null);
		this.setSerie(null);
		this.setMarca(null);
		this.setEnable(false);
	}
	
	public Motor(String pModelo, String pSerie, String pMarca) {
		this.setModelo(pModelo);
		this.setSerie(pSerie);
		this.setMarca(pMarca);
		this.setEnable(false);
	}
	
	public float getConsumo_x_motor(float pVel) {
		if (this.enable) {
			this.vel_constante = pVel;
			if (vel_constante >= vel_max) {
				return consumo_max;
			}
			if (vel_constante < vel_max/3) {
				return consumo_min;
			}
			if (vel_constante < vel_max/3.5) {
				return consumo_max/3.5f;
			}
			if (vel_constante < vel_max/2) {
				return consumo_max/2;
			}
			else {
				return consumo_max/1.6f;
			}
		}
		else {
			System.out.println("El motor no esta encendido");
			return 0;
		}
		
	}


	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public void setVel_constante(float vel_constante) {
		this.vel_constante = vel_constante;
	}
	
	
	

}
