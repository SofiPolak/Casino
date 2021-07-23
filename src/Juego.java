package ort.tp3.ortland;

import java.util.ArrayList;

public class Juego {
	
	private String nombre;
	private ArrayList<Mesa> mesasAsignadas;
	
	public Juego (String nombre) {
		this.mesasAsignadas = new ArrayList<>();
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Mesa> getMesasAsignadas() {
		return mesasAsignadas;
	}

	public void setMesasAsignadas(ArrayList<Mesa> mesasAsignadas) {
		this.mesasAsignadas = mesasAsignadas;
	}
	
	public ArrayList<JugadorSolitario> obtenerInformeJugadoresSolitarios(){
		ArrayList<JugadorSolitario> jugadores = new ArrayList<>();
		for(Mesa mesa: mesasAsignadas) {
			if(mesa.cantParticipantes()==1) {
				Participante participante = mesa.participanteSolitario();
				jugadores.add(new JugadorSolitario (participante.getNombre(), mesa.getNumero()));
			}
		}
		return jugadores;
	}
	
	public void agregarMesa(Mesa mesa) {
		mesasAsignadas.add(mesa);
	}
	
	public boolean acomodarJugador (String nombre, int edad) {
		boolean pudo= false;
		Mesa mesaMayor = null;
		int jugadoresMayor = -1;
		for (Mesa mesa: mesasAsignadas) {
			if(mesa.lugarDisponible()==true && mesa.cantParticipantes()>jugadoresMayor) {
				jugadoresMayor = mesa.cantParticipantes();
				mesaMayor = mesa;
			}
		}
		if(mesaMayor != null) {
			mesaMayor.agregarParticipante(new Participante(nombre,edad));
			pudo=true;
		}
		return pudo;
	}

	public Participante sacarJugadorDeMesa(String nombre) {
		Participante participante = null;
		int i=0;
		while (i<mesasAsignadas.size() && mesasAsignadas.get(i).buscarJugador(nombre) ==null) {
			i++;
		}
		if(i<mesasAsignadas.size()) {
			participante = mesasAsignadas.get(i).buscarJugador(nombre);
			mesasAsignadas.get(i).sacarJugadorDeMesa(participante);
		}
		return participante;
	}
	
	public Mesa buscarMesa (int numero) {
		Mesa mesa = null;
		int i=0;
		while (i<mesasAsignadas.size() && mesasAsignadas.get(i).getNumero() != numero) {
			i++;
		}
		if(i<mesasAsignadas.size()) {
			mesa = mesasAsignadas.get(i);
		}
		return mesa;
	}
	
	public Respuesta3 cambiarJugadorDeMesa(String nombre, int numeroMesa) {
		Respuesta3 respuesta = null;
		Mesa mesaPoner = buscarMesa(numeroMesa);
		if(mesaPoner==null) {
			respuesta = Respuesta3.MESA_NO_ENCONTRADA;
		}else {
			if(mesaPoner.lugarDisponible()==false) {
				respuesta = Respuesta3.MESA_SIN_LUGAR;
			}else {
				int i=0;
				while (i<mesasAsignadas.size() && mesasAsignadas.get(i).buscarJugador(nombre) == null) {
					i++;
				}
				if(i<mesasAsignadas.size()) {
					Mesa mesaSacar = mesasAsignadas.get(i);
					Participante participante = mesaSacar.buscarJugador(nombre);
					mesaSacar.sacarJugadorDeMesa(participante);
					mesaPoner.agregarParticipante(participante);
					respuesta = Respuesta3.CAMBIO_OK;
				}else {
					respuesta = Respuesta3.JUGADOR_NO_ENCONTRADO;
				}	
			}
		}
		return respuesta;
	}
	
	public Mesa mesaDisponible() {
		Mesa mesaMenor = null;
		int partMenor = Integer.MAX_VALUE;
		int i=0;
		while (i<mesasAsignadas.size() && mesasAsignadas.get(i).lugarDisponible() == true) {
			if(mesasAsignadas.get(i).cantParticipantes()<partMenor) {
				partMenor = mesasAsignadas.get(i).cantParticipantes();
				mesaMenor = mesasAsignadas.get(i);
			}
			i++;
		}
		return mesaMenor;
	}
	
	public Participante buscarJugador (String nombre) {
		Participante participante = null;
		int i=0;
		while (i<mesasAsignadas.size() && mesasAsignadas.get(i).buscarJugador(nombre)==null) {
			i++;
		}
		if (i<mesasAsignadas.size()) {
			participante = mesasAsignadas.get(i).buscarJugador(nombre);
		}
		return participante;
	}
	
	public boolean hayMesa() {
		boolean hay = false;
		int i=0;
		while (i<mesasAsignadas.size() && mesasAsignadas.get(i).lugarDisponible()==false) {
			i++;
		}
		if(i<mesasAsignadas.size()) {
			hay = true;
		}
		return hay;
	}
	
	public void agregarJugador(String nombre) {
		int menorPart = Integer.MAX_VALUE;
		Mesa mesaMenor = null;
		for (Mesa mesa: mesasAsignadas) {
			if(mesa.lugarDisponible()==true && mesa.cantParticipantes()<menorPart) {
				menorPart = mesa.cantParticipantes();
				mesaMenor = mesa;
			}
		}
		mesaMenor.agregarParticipante(new Participante(nombre));
	}

	@Override
	public String toString() {
		return "Juego [nombre=" + nombre + ", mesasAsignadas=" + mesasAsignadas + "]";
	}
	
	public int lugaresDisponibles() {
		int acumDisponibles = 0;
		for (Mesa mesa: mesasAsignadas) {
			acumDisponibles = acumDisponibles + mesa.lugaresDisponibles();
		}
		return acumDisponibles;
	}
	
	public ArrayList<Participante> jugadoresEnMesa (int numeroMesa){
		ArrayList<Participante> participantes = new ArrayList<>();
		int i =0;
		while (i<mesasAsignadas.size() && mesasAsignadas.get(i).getNumero() != numeroMesa) {
			i++;
		}
		if(i<mesasAsignadas.size()) {
			participantes = mesasAsignadas.get(i).listadoParticipantes();
		}
		return participantes;
	}
	
	public int cantMesas() {
		return this.getMesasAsignadas().size();
	}
	

}
