
package principal;

import modelo.Atributo;
import modelo.Carta;
import modelo.Jugador;
import modelo.Mazo;

public class Juego {

	public static void main(String[] args) {
		Juego juego = new Juego(500);
		Mazo mazo = new Mazo();
		mazo = Mazo.cargarMazo("./superheroes.json");

		Jugador j1 = new Jugador("Facundo");

		Jugador j2 = new Jugador("Gabriel");

		juego.repartir(j1, j2, mazo);

		juego.jugar(j1, j2);
	}

	private int maxJugadas;

	public Juego(int numeroMaxJugadas) {
		maxJugadas = numeroMaxJugadas;
	}

	public void jugar(Jugador j1, Jugador j2) {
		int i = 1;
		boolean hayGanador = false;

		Jugador iniciaRonda = j1;

		while (!(hayGanador) && (i <= maxJugadas)) {

			// El jugador ganador de la ultima ronda elije el atributo.
			Atributo attr = iniciaRonda.seleccionarAtributoRandom();

			// LOS DOS JUGADORES SUELTAN SU CARTA.
			Carta cartaJ1 = j1.soltarCarta();
			Carta cartaJ2 = j2.soltarCarta();

			// Informa las acciones ocurridas hasta el momento en la ronda.
			this.informar(i, iniciaRonda, cartaJ1, cartaJ2, attr, j1, j2);

			// resultado de la comparacion del atributo seleccionado en las cartas jugadas.
			int resultado = cartaJ1.comparar(attr, cartaJ2);

			iniciaRonda = this.determinarGanadorRonda(j1, j2, cartaJ1, cartaJ2, iniciaRonda, resultado);

			// informar cantidad cartas de los jugadores.
			System.out.println(j1 + " tiene " + j1.totalCartas() + " cartas. " + j2 + " tiene " + j2.totalCartas() + " cartas.");

			System.out.println();
			hayGanador = this.hayGanador(j1, j2);

			i++;
		}

		if (!hayGanador)
			System.out.println("Los jugadores empataron");

	}

	/**
	 * Determina si hubo un ganador o empate.
	 */
	public Jugador determinarGanadorRonda(Jugador j1, Jugador j2, Carta c1, Carta c2, Jugador ganadorPrevio, int res) {

		if (res > 0) {
			this.darCartasAlGanador(j1, c1, c2);
			return j1;
		}

		if (res < 0) {
			this.darCartasAlGanador(j2, c1, c2);
			return j2;
		}

		this.devolverCartas(j1, j2, c1, c2);
		return ganadorPrevio;

	}

	/**
	 * Jugador que gano la ronda recibe las dos cartas jugadas.
	 */
	private void darCartasAlGanador(Jugador j, Carta carta1, Carta carta2) {
		System.out.println(j + " gano la ronda");
		j.tomarCarta(carta1);
		j.tomarCarta(carta2);
	}

	/**
	 * Devuelva las cartas a los jugadores (en caso de empate).
	 */
	private void devolverCartas(Jugador j1, Jugador j2, Carta c1, Carta c2) {
		System.out.println();
		System.out.println("empate!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println();
		j1.tomarCarta(c1);
		j2.tomarCarta(c2);
	}

	/**
	 * Controla que los jugadores tengan cartas para jugar.
	 */
	public boolean hayGanador(Jugador j1, Jugador j2) {
		if (!j1.tieneCartas()) {
			System.out.println(j2 + " gano la partida");
			return true;
		}
		if (!j2.tieneCartas()) {
			System.out.println(j1 + " gano la partida");
			return true;
		}
		return false;
	}

	/**
	 * Mezcla y reparte cartas a los jugadores.
	 */
	public void repartir(Jugador j1, Jugador j2, Mazo mazo) {
		mazo.mezclarCartas();
		for (int i = mazo.size(); i > 0; i--) {
			if ((i % 2) == 0)
				j1.tomarCarta(mazo.pop());
			else
				j2.tomarCarta(mazo.pop());
		}
	}

	/**
	 * Informa el numero de ronda Informa el atributo por el que los jugadores van a
	 * competir y que jugador lo eligio. Informa la cartas jugadas.
	 */
	private void informar(int i, Jugador ini, Carta c1, Carta c2, Atributo attr, Jugador j1, Jugador j2) {
		System.out.println("------- Ronda " + i + " -------");
		System.out.println("El jugador " + ini + " selecciona competir por atributo " + attr.getNombre());
		System.out.println(j1 + " jugo la carta " + c1 + " con " + c1.getAtributo(attr));
		System.out.println(j2 + " jugo la carta " + c2 + " con " + c2.getAtributo(attr));
	}
}
