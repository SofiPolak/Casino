package ort.tp3.ortland;

public class Carta {
	
	private int numero;
	private Palo palo;
	
	public Carta(int numero, Palo palo) {
		this.setNumero(numero);;
		this.setPalo(palo);;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Palo getPalo() {
		return palo;
	}
	
	public void setPalo(Palo palo) {
		this.palo = palo;
	}

	@Override
	public String toString() {
		return "Carta [numero=" + numero + ", palo=" + palo + "]";
	}
	

}
