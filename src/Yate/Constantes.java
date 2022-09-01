package Yate;
import  java.util.Arrays;
import java.util.List;
public class Constantes {
	
	//Bateria
	public final static float capacidad_max_bat = 1000;
	public final static int velocidad_consumo = 10000; 
	public final static int velocidad_carga_bat = 130; //20
	//--------------------------------------------------------------------------------
	
	//Motor
	public final static int velocidad_maxima_yate = 201;
	public final static float consumo_maximo_motor = 6.0f;
	public final static float consumo_minimo_motor = 1.0f;
	public final static int aumento_vel_x_aceleracion = 10;
	public final static int velocidad_en_sim = 1000;
	//--------------------------------------------------------------------------------

	//Temporizador
	public final static int duracion = 70;
	//--------------------------------------------------------------------------------
	
	//Velocidad del Yate
	public static float velocidad_constante = 0;
	public static void setVelocidadConstante(float pVel) {
		if (pVel < velocidad_maxima_yate && pVel>=0) {
			velocidad_constante = pVel;
		}
		if (pVel>velocidad_maxima_yate) {
			velocidad_constante = velocidad_maxima_yate;
		}
		if (pVel<0) {
			velocidad_constante = 0;
		}
	}
	
	public static float getVelocidadConstante() {return velocidad_constante;}
	//--------------------------------------------------------------------------------
		
	
	
}


