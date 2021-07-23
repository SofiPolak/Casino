package ort.tp3.ortland;

public class JuegoYLugares {
	
	private String nombre;
	private int disponibles;
	
	public JuegoYLugares(String nombre, int disp) {
		this.setNombre(nombre);
		this.setDisponibles(disp);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}

	@Override
	public String toString() {
		return "JuegoYLugares [nombre=" + nombre + ", disponibles=" + disponibles + "]";
	}

	

}
