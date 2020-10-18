package juego_cartas.principal;

import juego_cartas.modelo.Carta;
import juego_cartas.modelo.Juego;
import juego_cartas.modelo.Jugador;
import juego_cartas.modelo.Mazo;

public class Main {

public static void main(String[] args) {
		
		Juego juego = new Juego(100);
		Mazo mazo = new Mazo();
		mazo = Mazo.cargarMazo("./superheroes.json");
		Jugador j1 = new Jugador("Facundo");
		Jugador j2 = new Jugador("Gabriel");
		//mazo.mostrarCartas();
		juego.repartir(j1, j2, mazo);
		
		int i = 1;
		boolean hayGanador = false;
		
		Jugador iniciaRonda = j1;

		while (!(hayGanador) && (i <= juego.maxJugadas)) {

			// El jugador ganador de la ultima ronda elije el atributo.
			String attr = iniciaRonda.seleccionarAtributoRandom();

			// LOS DOS JUGADORES SUELTAN SU CARTA.
			Carta cartaJ1 = j1.soltarCarta();
			Carta cartaJ2 = j2.soltarCarta();

			// Informa las acciones ocurridas hasta el momento en la ronda.
			juego.informar(i, iniciaRonda, cartaJ1, cartaJ2, attr, j1, j2);

			//determina quien inicia la proxima ronda eh informa quien gana.
			iniciaRonda = juego.determinarGanadorRonda(j1, j2, cartaJ1, cartaJ2, iniciaRonda, attr);
			
			//imprimir el total de cartas deca jugador luego de jugada la ronda
			System.out.println(j1 + " tiene: "+j1.totalCartas()+" cartas y "+ j2 + " tiene: "+j2.totalCartas());
			System.out.println();
			hayGanador = juego.hayGanador(j1, j2);

			i++;
		}

		if (!hayGanador)
			System.out.println("Los jugadores empataron");
	}

}
