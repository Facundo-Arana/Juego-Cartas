
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
		// mazo.mostrarCartas();
		Jugador j1 = new Jugador("Facundo");
		// j1.crearNombre();
		Jugador j2 = new Jugador("Gabriel");
		// j2.crearNombre();
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

		int resultado = 0;

		while (!(hayGanador) && (i < maxJugadas)) {
			System.out.println("------- RONDA " + i + " -------");

			// El jugador ganador de la ultima ronda elije el atributo.
			Atributo attr = iniciaRonda.seleccionarAtributoRandom();
			System.out.println("El jugador " + iniciaRonda + " selecciona competir por atributo " + attr.getNombre());

			// LOS DOS JUGADORES SUELTAN SU CARTA.
			Carta cartaJ1 = j1.soltarCarta();
			System.out.println(j1 + " jugo la carta " + cartaJ1 + " con " + cartaJ1.getAtributo(attr));

			Carta cartaJ2 = j2.soltarCarta();
			System.out.println(j2 + " jugo la carta " + cartaJ2 + " con " + cartaJ2.getAtributo(attr));

			// Se determina quien gano la jugada.
			resultado = this.determinarGanadorRonda(cartaJ1, cartaJ2, attr);

			//
			if (resultado == 0) {
				System.out.println("Hubo un empate");
				this.darCartasAlGanador(j1, j2, cartaJ1, cartaJ2, resultado);
			}else {
				iniciaRonda = this.darCartasAlGanador(j1, j2, cartaJ1, cartaJ2, resultado);
				System.out.println(iniciaRonda + " gano la ronda ");
				System.out.println(j1 + " tiene: "+j1.totalCartas()+" cartas y "+ j2 + " tiene: "+j2.totalCartas());
			}

			System.out.println();

			if (this.hayGanador(j1, j2)) {
				this.victoria(j1, j2);
				hayGanador = true;
			}
			i++;
		}
		if (!hayGanador)
			System.out.println("HUBO UN EMPATE");
		
		else {
			System.out.println("las cartas de " + j1 + " son:");
			j1.mostrarCartas();

			System.out.println();

			System.out.println("las cartas de " + j2 + " son:");
			j2.mostrarCartas();
		}
	}

	public void victoria(Jugador j1, Jugador j2) {
		if (j1.tieneCartas())
			System.out.println(j1 + " gano la partida");
		else
			System.out.println(j2 + " gano la partida");
	}

	public boolean hayGanador(Jugador j1, Jugador j2) {
		if (j1.tieneCartas() && j2.tieneCartas())
			return false;
		else
			return true;
	}

	private Jugador darCartasAlGanador(Jugador j1, Jugador j2, Carta carta1, Carta carta2, int resultado) {

		if(resultado==0){
			j1.tomarCarta(carta1);
			j2.tomarCarta(carta2);
			return null;
		}else if (resultado > 0) {
			j1.tomarCarta(carta1);
			j1.tomarCarta(carta2);
			return j1;
		} else {
			j2.tomarCarta(carta1);
			j2.tomarCarta(carta2);
			return j2;
		}
	}

	/**
	 * Determina si hubo un ganador o empate.
	 */
	public int determinarGanadorRonda(Carta c1, Carta c2, Atributo attr) {
		return c1.getAtributo(attr).compareTo(c2.getAtributo(attr));
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

}
