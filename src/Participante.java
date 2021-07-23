package ort.tp3.ortland;

import java.util.ArrayList;

public class Participante {
	
	private String nombre;
	private int edad;
	private ArrayList<Carta> cartas;
	
	public Participante (String nombre, int edad) {
		this.setEdad(edad);
		this.setNombre(nombre);
		this.cartas = new ArrayList<>();
	}
	
	public Participante (String nombre) {
		this.setNombre(nombre);
		this.cartas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	@Override
	public String toString() {
		return "Participante [nombre=" + nombre + ", edad=" + edad + ", cartas=" + cartas + "]";
	}
	
	public ArrayList<Carta> mostrarCartas(){
		return cartas;
	}
	
	public void devolverCartas () {
//		int i=0;
//		while (i<cartas.size()) {
//			cartas.remove(0);
//		}
		cartas.clear();
	}
	
	public void agregarCarta(Carta carta) {
		cartas.add(carta);
	}
	
	public int cartaMenorDePalo(Palo palo) {
		int numCartaMenor = Integer.MAX_VALUE;
		for (Carta carta: cartas) {
			if(carta.getPalo() == palo && carta.getNumero() < numCartaMenor) {
				numCartaMenor = carta.getNumero();
			}
		}
		return numCartaMenor;
	}

}
