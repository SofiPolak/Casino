package ort.tp3.ortland;

import java.util.ArrayList;

public class OrtLand {
	
	private ArrayList<Juego> juegos;
	
	public OrtLand () {
		this.juegos = new ArrayList<>();
	}

	public ArrayList<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(ArrayList<Juego> juegos) {
		this.juegos = juegos;
	}
	
	public void agregarJuego(Juego juego) {
		juegos.add(juego);
	}
	
	public Juego buscarJuego(String nombre) {
		Juego juego = null;
		int i =0;
		while(i<juegos.size() && !juegos.get(i).getNombre().equals(nombre)) {
			i++;
		}
		if(i<juegos.size()) {
			juego = juegos.get(i);
		}
		return juego;
	}
	
	public Respuesta2 acomodarJugador (String nombre, int edad, String nombreJuego) {
		Respuesta2 respuesta = null;
		Juego juego =buscarJuego(nombreJuego);
		if( juego == null) {
			respuesta = Respuesta2.JUEGO_NO_ENCONTRADO;
		}else {
			if(juego.acomodarJugador(nombreJuego, edad) == true) {
				respuesta = Respuesta2.ASIGNACION_OK;
			}else {
				respuesta = Respuesta2.SIN_DISPONIBILIDAD;
			}
		}
		return respuesta;
	}
	
	public Participante sacarJugadorDeMesa(String nombre) {
		Participante participante = null;
		int i=0;
		while (i<juegos.size() && participante==null) {
			participante = juegos.get(i).sacarJugadorDeMesa(nombre);
			i++;
		}
		return participante;
	}
	
	public Respuesta4 cambiarJugadorDeJuego (String nombrePar, String nombreJue) {
		Respuesta4 respuesta = null;
		Juego juego = buscarJuego(nombreJue);
		if(juego == null) {
			respuesta = Respuesta4.JUEGO_NO_ENCONTRADO;
		}else {
			if(juego.hayMesa()==false) {
				respuesta = Respuesta4.SIN_DISPONIBILIDAD;
			}else {
				int i = 0;
				while (i<juegos.size() && juegos.get(i).buscarJugador(nombrePar) ==null) {
					i++;
				}
				if(i==juegos.size()) {
					respuesta = Respuesta4.JUGADOR_NO_ENCONTRADO;
				}else {
					juegos.get(i).sacarJugadorDeMesa(nombrePar);
					juegos.get(i).agregarJugador(nombrePar);
					respuesta = Respuesta4.CAMBIO_OK;
				}
			}
		}
		return respuesta;
	}
	
	public ArrayList<JuegoYLugares> obtenerDisponibilidadJuegos(){
		ArrayList<JuegoYLugares> juegosYLugares = new ArrayList<>();
		for(Juego juego: juegos) {
			juegosYLugares.add(new JuegoYLugares(juego.getNombre(), juego.lugaresDisponibles()));
		}
		return juegosYLugares;
	}
	
	public ArrayList<Participante> jugadoresEnMesa (int numeroMesa){
		ArrayList<Participante> participantes = new ArrayList<>();
		int i =0;
		while (i<juegos.size() && juegos.get(i).jugadoresEnMesa(numeroMesa) == null) {
			i++;
		}
		if(i<juegos.size()) {
			participantes = juegos.get(i).jugadoresEnMesa(numeroMesa);
		}
		return participantes;
	}
	
	public boolean abrirMesas(String juego, int mesas) {
		boolean pudo = false;
		Juego juegoEncontrado = buscarJuego(juego);
		if(juegoEncontrado != null) {
			int numMesa = juegoEncontrado.cantMesas();
			for (int i=0; i<mesas; i++) {
				numMesa = numMesa+1;
				juegoEncontrado.agregarMesa(new Mesa (numMesa));
			}
			pudo = true;
		}
		return pudo;
	}

}
