package ort.tp3.ortland;

public class JugadorSolitario {
	
	private String nombre;
	private int numeroMesa;
	
	public JugadorSolitario(String nombre, int numeroMesa) {
		this.setNombre(nombre);;
		this.setNumeroMesa(numeroMesa);;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getNumeroMesa() {
		return numeroMesa;
	}
	
	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	@Override
	public String toString() {
		return "JugadorSolitario [nombre=" + nombre + ", numeroMesa=" + numeroMesa + "]";
	}
	

}
