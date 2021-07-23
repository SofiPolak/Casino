package ort.tp3.ortland;

public class Test {

	public static void main(String[] args) {
		
		OrtLand ortland = new OrtLand ();
		
		Juego juego = new Juego("Truco");
		ortland.agregarJuego(juego);
		
		Mesa mesa1 = new Mesa (1,6);
		Mesa mesa2 = new Mesa (2,3);
		Mesa mesa3 = new Mesa (3,1);
		
		Participante part1 = new Participante ("A",18);
		Participante part2 = new Participante ("B",18);
		Participante part3 = new Participante ("C",18);
		Participante part4 = new Participante ("D",18);
		Participante part5 = new Participante ("E",18);
		Participante part6 = new Participante ("F",18);
		Participante part7 = new Participante ("G",18);
		Participante part8 = new Participante ("H",18);
		
		Carta carta1 = new Carta (1, Palo.ESPADA);
		Carta carta2 = new Carta (1, Palo.BASTO);
		Carta carta3 = new Carta (1, Palo.COPA);
		Carta carta4 = new Carta (1, Palo.ORO);
		Carta carta5 = new Carta (2, Palo.ESPADA);
		Carta carta6 = new Carta (2, Palo.BASTO);
		Carta carta7 = new Carta (2, Palo.ORO);
		
		mesa1.agregarParticipante(part8);
		mesa1.agregarParticipante(part7);
		mesa1.agregarParticipante(part6);
		mesa1.agregarParticipante(part5);
        mesa2.agregarParticipante(part4);
        mesa2.agregarParticipante(part3);
        mesa2.agregarParticipante(part2);
        mesa3.agregarParticipante(part1);
        
        part1.agregarCarta(carta7);
        part2.agregarCarta(carta7);
        part3.agregarCarta(carta6);
        part4.agregarCarta(carta5);
        part5.agregarCarta(carta7);
        part5.agregarCarta(carta6);
        part6.agregarCarta(carta5);
        part7.agregarCarta(carta3);
        part7.agregarCarta(carta4);
        part8.agregarCarta(carta2);
        part8.agregarCarta(carta1);
        
        mesa2.agregarCarta(carta1);
        mesa2.agregarCarta(carta3);
        
        mesa3.agregarCarta(carta6);
        mesa3.agregarCarta(carta4);
        mesa3.agregarCarta(carta2);
        
        juego.agregarMesa(mesa3);
        juego.agregarMesa(mesa2);
        juego.agregarMesa(mesa1);
        
        System.out.println(juego.obtenerInformeJugadoresSolitarios());
        System.out.println(mesa1.getCartas().size());
        System.out.println(part7.getCartas().size());
        System.out.println(mesa1.devolverCartasAlMazo("G"));
        System.out.println(mesa1.getCartas().size());
        System.out.println(part7.getCartas().size());
        System.out.println(mesa1.devolverCartasAlMazo("K"));
        
        System.out.println(mesa1.repartirCartas());
        System.out.println(ortland.acomodarJugador("Q", 18, "Truco"));
        
        System.out.println(ortland.sacarJugadorDeMesa("F"));
        System.out.println(ortland.sacarJugadorDeMesa("N"));
        
        System.out.println(juego.cambiarJugadorDeMesa("Z", 1));
        System.out.println(juego.cambiarJugadorDeMesa("Z", 2));
        System.out.println(juego.cambiarJugadorDeMesa("Z", 9));
        System.out.println(juego.cambiarJugadorDeMesa("C", 1));
        
        Juego juego2 = new Juego("Casita robada");
		ortland.agregarJuego(juego2);
		
		Mesa mesa4 = new Mesa (1,6);
		Mesa mesa5 = new Mesa (2,3);
		Mesa mesa6 = new Mesa (3,1);
		
		Participante part9 = new Participante ("AB",18);
		Participante part10 = new Participante ("AC",18);
		Participante part11 = new Participante ("AD",18);
		Participante part12 = new Participante ("AA",18);
		
		mesa4.agregarParticipante(part9);
		mesa5.agregarParticipante(part10);
		mesa5.agregarParticipante(part11);
		mesa6.agregarParticipante(part12);
		
		juego2.agregarMesa(mesa4);
        juego2.agregarMesa(mesa5);
        juego2.agregarMesa(mesa6);
        
        System.out.println(juego2.mesaDisponible());
		System.out.println(ortland.cambiarJugadorDeJuego("AB", "Truco"));
		System.out.println(ortland.cambiarJugadorDeJuego("A", "Tute"));
		System.out.println(ortland.cambiarJugadorDeJuego("Z", "Truco"));
		
		System.out.println(mesa1.obtenerJugadorMenorCartaEnMesa(Palo.BASTO));
		System.out.println(ortland.obtenerDisponibilidadJuegos());
		
		System.out.println(ortland.jugadoresEnMesa(1));
		System.out.println(ortland.abrirMesas("Tute", 3));
		System.out.println(ortland.abrirMesas("Truco", 2));

	}

}
