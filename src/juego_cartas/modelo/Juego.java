package juego_cartas.modelo;

import java.util.ArrayList;

import juego_cartas.pocima.Pocima;

public class Juego {

	private int maxJugadas;
	private ArrayList<Pocima> pocimas;
	private Jugador j1;
	private Jugador j2;
	private Mazo mazo;
	private Jugador iniciaRonda;

	public Juego(int numeroMaxJugadas, Jugador j1, Jugador j2, Mazo mazo) {
		this.maxJugadas = numeroMaxJugadas;
		this.j1 = j1;
		this.j2 = j2;
		this.mazo = mazo;
		this.iniciaRonda  = j1;
		this.pocimas = new ArrayList<>();
	}

	public void setPocima(Pocima pocima) {
		this.pocimas.add(pocima);
	}

	/**
	 * 
	 * @return la informacion de todas la rondas del juego .
	 */
	public void jugar() {
		// se reparten las cartas luego de haber incoporado las pocimas
		this.repartirCartas();

		// auxiliares
		int ronda = 1;
		Jugador ganador = null;
		String info = "";

		// inicia el juego hasta que gane un jugador o se cumpla el total de rondas
		while ((ganador == null) && (ronda <= this.maxJugadas)) {
			info += jugarRonda(ronda);
			ganador = this.hayGanador();
			ronda++;
		}

		info += this.logFinal(ganador);

		System.out.println(info);
//		return info;
	}

	

	/**
	 * 
	 * @return la informacion de una ronda del juego.
	 */
	private String jugarRonda(int ronda) {
		String info = "";

		// El jugador ganador de la ultima ronda elije el atributo
		String attr = this.iniciaRonda.seleccionarAtributo();

		// LOS DOS JUGADORES SUELTAN SU CARTA
		Carta cartaJ1 = j1.soltarCarta();
		Carta cartaJ2 = j2.soltarCarta();

		info += informacionInicial(ronda, cartaJ1, cartaJ2, attr);

		// se determina el ganador de la ronda
		int resultado = this.compararAtributos(attr, cartaJ1, cartaJ2);

		// se dan las cartas al ganador
		if (resultado == 0) {
			info += this.empate(cartaJ1, cartaJ2);
		} else {
			if (resultado > 0) {
				info += this.darCartasAlGanador(j1, cartaJ1, cartaJ2);
				this.iniciaRonda = j1;
			}
			if (resultado < 0) {
				info += this.darCartasAlGanador(j2, cartaJ1, cartaJ2);
				this.iniciaRonda = j2;
			}
		}
		info += this.informacionFinal();
		return info;
	}

	/**
	 * 
	 * Determina si hubo un ganador o empate.
	 */
	public int compararAtributos(String attr, Carta c1, Carta c2) {
		int val1 = c1.getValorAtributo(attr);
		int val2 = c2.getValorAtributo(attr);
		return val1 - val2;
	}

	/**
	 * 
	 * Jugador que gano la ronda recibe las dos cartas jugadas.
	 */
	public String darCartasAlGanador(Jugador j, Carta carta1, Carta carta2) {
		j.tomarCarta(carta1);
		j.tomarCarta(carta2);
		return j + " gano la ronda \n";
	}

	/**
	 * 
	 * Devuelva las cartas a los jugadores (en caso de empate).
	 */
	public String empate(Carta c1, Carta c2) {
		j1.tomarCarta(c1);
		j2.tomarCarta(c2);
		return "\nempate!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n \n";
	}

	/**
	 * 
	 * Controla que los jugadores tengan cartas para jugar.
	 */
	public Jugador hayGanador() {
		if (!j1.tieneCartas()) {
			return j2;
		}
		if (!j2.tieneCartas()) {
			return j1;
		}
		return null;
	}

	/**
	 * 
	 * Mezcla y reparte cartas a los jugadores.
	 */
	public void repartirCartas() {
		mazo.mezclarCartas();
		this.repartirPocimas();

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
	public String informacionInicial(int i, Carta c1, Carta c2, String attr) {
		String info = "";
		info += "------- Ronda " + i + " -------" + "\n";
		info += "El jugador " + this.iniciaRonda + " selecciona competir por atributo " + attr + "\n";
		info += c1.infoJugada(j1, c1, attr);
		info += "\n";
		info += c2.infoJugada(j2, c2, attr);
		info += "\n";
		return info;
	}

	public String informacionFinal() {
		return j1 + " tiene: " + j1.totalCartas() + " cartas y " + j2 + " tiene: " + j2.totalCartas() + "\n \n";
	}

	/**
	 * 
	 * Reparte todas las pocimas aleatoreamenta a las cartas del mazo. Se dan las
	 * pocimas de una a la vez al mazo para que este se la asigne a una carta.
	 * 
	 * @param { boolean: ok } El mazo devueve false cuando no ha podido a�adir una
	 *          pocima, es decir que todas sus cartas ya tienen una pocima asignada.
	 * 
	 */
	private void repartirPocimas() {
		int num = this.pocimas.size();
		boolean ok = true;
		while (num > 0 && ok) {
			int random = (int) (num * Math.random());
			ok = mazo.addPocima(this.getPocima(random));
			num--;
		}
	}

	/**
	 * 
	 * Obtener una pocima en una posicion dada y eliminarla del arreglo.
	 * 
	 * (SIMILAR A METODO POP)
	 */
	private Pocima getPocima(int i) {
		Pocima copia = pocimas.get(i);
		pocimas.remove(i);
		return copia;
	}
	
	private String logFinal(Jugador ganador) {
		String info = "";
		if(ganador != null) {			
			info += ganador + " es el ganador de la partida!";
		}
		else {
			if(j1.totalCartas() > j2.totalCartas()) {
				info += j1 + " es el ganador de la partida!";
			}else if(j1.totalCartas() < j2.totalCartas()) {
				info += j2 + " es el ganador de la partida!";
			}
			else {				
				info += "Los jugadores empataron";
			}
		}
		return info;
	}

}
