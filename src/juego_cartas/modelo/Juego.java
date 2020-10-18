package juego_cartas.modelo;

public class Juego {
	
	public int maxJugadas;

	public Juego(int numeroMaxJugadas) {
		maxJugadas = numeroMaxJugadas;
	}

	/**
	 * 
	 * Determina si hubo un ganador o empate.
	 */
	public Jugador determinarGanadorRonda(Jugador j1, Jugador j2, Carta c1, Carta c2, Jugador ganadorPrevio, String attr) {
		int res = c1.comparar(attr, c2);

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
	 * 
	 * Jugador que gano la ronda recibe las dos cartas jugadas.
	 */
	private void darCartasAlGanador(Jugador j, Carta carta1, Carta carta2) {
		System.out.println(j + " gano la ronda \n");
		j.tomarCarta(carta1);
		j.tomarCarta(carta2);
	}

	/**
	 * 
	 * Devuelva las cartas a los jugadores (en caso de empate).
	 */
	private void devolverCartas(Jugador j1, Jugador j2, Carta c1, Carta c2) {
		System.out.println("\n empate!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n");
		j1.tomarCarta(c1);
		j2.tomarCarta(c2);
	}

	/**
	 * 
	 * Controla que los jugadores tengan cartas para jugar.
	 */
	public boolean hayGanador(Jugador j1, Jugador j2) {
		if (!j1.tieneCartas()) {
			System.out.println(j2 + "gano la partida");
			return true;
		}
		if (!j2.tieneCartas()) {
			System.out.println(j1 + "gano la partida");
			return true;
		}
		return false;
	}

	/**
	 * 
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
	 * 
	 * Informa el numero de ronda Informa el atributo por el que los jugadores van a
	 * competir y que jugador lo eligio. Informa la cartas jugadas.
	 */
	public void informar(int i, Jugador ini, Carta c1, Carta c2, String attr, Jugador j1, Jugador j2) {
		System.out.println("------- Ronda " + i + " -------");
		System.out.println("El jugador " + ini + " selecciona competir por atributo " + attr);
		System.out.println(j1 + " jugo la carta " + c1 + " con " + c1.getValorAtributo(attr));
		System.out.println(j2 + " jugo la carta " + c2 + " con " + c2.getValorAtributo(attr));
	}
}
