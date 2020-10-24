package juego_cartas.modelo;

import java.util.ArrayList;

import juego_cartas.modelo.pocima.Pocima;

public class Juego {

	private int maxJugadas;
	private ArrayList<Pocima> pocimas;

	public Juego(int numeroMaxJugadas) {
		this.maxJugadas = numeroMaxJugadas;
		this.pocimas = new ArrayList<>();
	}

	public void addPocima(Pocima pocima) {
		this.pocimas.add(pocima);
	}

	public int getMaxJugadas() {
		return this.maxJugadas;
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
	public String empate(Jugador j1, Jugador j2, Carta c1, Carta c2) {
		j1.tomarCarta(c1);
		j2.tomarCarta(c2);
		return "\nempate!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n \n" ;
	}

	/**
	 * 
	 * Controla que los jugadores tengan cartas para jugar.
	 */
	public Jugador hayGanador(Jugador j1, Jugador j2) {
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
	public void repartirCartas(Jugador j1, Jugador j2, Mazo mazo) {
		mazo.mezclarCartas();
		this.repartirPocimas(mazo);

		for (int i = mazo.size(); i > 0; i--) {
			if ((i % 2) == 0)
				j1.tomarCarta(mazo.pop());
			else
				j2.tomarCarta(mazo.pop());
		}
	}

	/**
	 * 
	 * Reparte todas las pocimas aleatoreamenta a las cartas del mazo.
	 * Se dan las pocimas de una a la vez al mazo para que este se la asigne a una carta.
	 * 
	 * @param { boolean: ok } El mazo devueve false cuando no ha podido añadir una pocima,
	 *  es decir que todas sus cartas ya tienen una pocima asignada.
	 * 
	 */
	private void repartirPocimas(Mazo mazo) {
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

	/**
	 * 
	 * Informa el numero de ronda Informa el atributo por el que los jugadores van a
	 * competir y que jugador lo eligio. Informa la cartas jugadas.
	 */
	public String informacionInicial(int i, Jugador ini, Carta c1, Carta c2, String attr, Jugador j1, Jugador j2) {
		String info = "";
		info += "------- Ronda " + i + " -------" + "\n";
		info += "El jugador " + ini + " selecciona competir por atributo " + attr + "\n";
		info += j1 + " jugo la carta " + c1 + " con " + c1.getValorAtributoSinPocima(attr);
		if(c1.tienePocima())
			info += ", se aplico pócima " + c1.getNombrePocima() + " valor resultante " + c1.getValorAtributo(attr);
		info += "\n";
		info += j2 + " jugo la carta " + c2 + " con " + c2.getValorAtributoSinPocima(attr);
		if(c2.tienePocima())
			info += ", se aplico pócima " + c2.getNombrePocima() + " valor resultante " + c2.getValorAtributo(attr);
		info += "\n";
		return info;
	}

	public String informacionFinal(Jugador j1, Jugador j2) {
		return j1 + " tiene: " + j1.totalCartas() + " cartas y " + j2 + " tiene: " + j2.totalCartas() + "\n";
	}
}
