package Yate;

public class Elemento {
	private String nombre;
	private float consumo;
	private boolean activo;
	
	public Elemento(String pNombre, float pConsumo){
		this.setNombre(pNombre);
		this.setConsumo(pConsumo);
		this.setActivo(false);
	}
	public Elemento(String pNombre, float pConsumo, boolean pActivo){
		this.setNombre(pNombre);
		this.setConsumo(pConsumo);
		this.setActivo(pActivo);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getConsumo() {
		return consumo;
	}
	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

	
	

}
