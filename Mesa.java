package ort.tp3.ortland;

import java.util.ArrayList;

public class Mesa {
	
	private int numero;
	private int cantMaxParticipantes;
	private ArrayList<Carta> cartas;
	private ArrayList<Participante> participantes;
	
	public Mesa(int numero, int cant) {
		this.setCantMaxParticipantes(cant);
		this.setNumero(numero);
		this.cartas = new ArrayList<>();
		this.participantes = new ArrayList<>();
	}
	
	public Mesa(int numero) {
		this.setNumero(numero);
		this.cartas = new ArrayList<>();
		this.participantes = new ArrayList<>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCantMaxParticipantes() {
		return cantMaxParticipantes;
	}

	public void setCantMaxParticipantes(int cantMaxParticipantes) {
		this.cantMaxParticipantes = cantMaxParticipantes;
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	@Override
	public String toString() {
		return "Mesa [numero=" + numero + ", cantMaxParticipantes=" + cantMaxParticipantes + ", cartas=" + cartas
				+ ", participantes=" + participantes + "]";
	}
	
	public Participante buscarJugador (String nombre) {
		Participante participante = null;
		int i=0;
		while(i<participantes.size() && !participantes.get(i).getNombre().equals(nombre)) {
			i++;
		}
		if(i<participantes.size()) {
			participante = participantes.get(i);
		}
		return participante;
	}
	
	public Respuesta devolverCartasAlMazo(String nombre) {
		Respuesta respuesta = null;
		Participante participante = buscarJugador(nombre);
		if(participante==null) {
			respuesta = Respuesta.JUGADOR_NO_ENCONTRADO;
		}else {
			ArrayList<Carta> cartasJugador = new ArrayList<>();
			cartasJugador = participante.mostrarCartas();
			for(Carta carta: cartasJugador) {
				cartas.add(carta);
			}
			participante.devolverCartas();
			respuesta = Respuesta.DEVOLUCION_OK;
		}
		return respuesta;
	}
	
	public int cantParticipantes () {
		return this.getParticipantes().size();
	}
	
	public Participante participanteSolitario () {
		return participantes.get(0);
	}
	
	public void agregarCarta(Carta carta) {
		cartas.add(carta);
	}
	
	public void agregarParticipante(Participante participante) {
		participantes.add(participante);
	}
	
	public boolean lugarDisponible () {
		boolean respuesta = false;
		if ((this.getCantMaxParticipantes()-this.getParticipantes().size())>0) {
			respuesta = true;
		}
		return respuesta;
	}
	
	public boolean repartirCartas() {
		boolean pudo = false;
		if (this.getParticipantes().size()>=2 && ((double)this.getCartas().size()/this.getParticipantes().size())>=4) {
			for (int i=0; i<4; i++) {
				for (Participante participante: participantes) {
					participante.agregarCarta(cartas.get(0));
					cartas.remove(0);
				}
			}
			pudo=true;
		}
		return pudo;
	}
	
	public void sacarJugadorDeMesa (Participante participante) {
		participantes.remove(participante);
	}
	
	public String obtenerJugadorMenorCartaEnMesa(Palo palo) {
		String participantePaloMenor = "";
		int numCartaMenor = Integer.MAX_VALUE;
		for (Participante participante: participantes) {
			if(participante.cartaMenorDePalo(palo) < numCartaMenor) {
				numCartaMenor = participante.cartaMenorDePalo(palo);
				participantePaloMenor = participante.getNombre();
			}
		}
		return participantePaloMenor;
	}
	
	public int lugaresDisponibles() {
		return this.getCantMaxParticipantes()-this.getParticipantes().size();
	}
	
	public ArrayList<Participante> listadoParticipantes(){
		return this.getParticipantes();
	}

}
