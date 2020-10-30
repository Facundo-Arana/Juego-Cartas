package juego_cartas.principal;

import juego_cartas.estrategia.Estrategia;
import juego_cartas.estrategia.Estrategia_Ambicioso;
import juego_cartas.modelo.Carta;
import juego_cartas.modelo.Juego;
import juego_cartas.modelo.Jugador;
import juego_cartas.modelo.Mazo;
import juego_cartas.pocima.PocimaCocktail;
import juego_cartas.pocima.PocimaDebilitadora;
import juego_cartas.pocima.PocimaFortalecedora;
import juego_cartas.pocima.PocimaSelectiva;

public class Main {

	public static void main(String[] args) {

		Juego juego = new Juego(100);
		Mazo mazo = new Mazo();
		mazo = Mazo.cargarMazo("./superheroes.json");
		Jugador j1 = new Jugador("Facundo");
		Jugador j2 = new Jugador("Gabriel");
		Estrategia est = new Estrategia_Ambicioso();
		j2.setEstrategia(est);

		PocimaFortalecedora p1 = new PocimaFortalecedora("fortalecedora", 50);
		PocimaDebilitadora p2 = new PocimaDebilitadora("debilitadora", 50);
		PocimaCocktail p3 = new PocimaCocktail("cocktail", p1, p2);
		PocimaSelectiva p4 = new PocimaSelectiva("selectiva", "fuerza", p1);

		juego.addPocima(p1);
		juego.addPocima(p2);
		juego.addPocima(p3);
		juego.addPocima(p4);
		for(int i =0; i < 20; i++)
			juego.addPocima(p3);

		juego.repartirCartas(j1, j2, mazo);

		int i = 1;
		Jugador ganador = null;
		Jugador iniciaRonda = j1;

		while ((ganador == null) && (i <= juego.getMaxJugadas())) {

			// String { info }: recolecta la informacion porporcionada por los distintos
			// metodos.
			String info = "";

			// El jugador ganador de la ultima ronda elije el atributo.
			String attr = iniciaRonda.seleccionarAtributo();

			// LOS DOS JUGADORES SUELTAN SU CARTA.
			Carta cartaJ1 = j1.soltarCarta();
			Carta cartaJ2 = j2.soltarCarta();

			info += informacionInicial(i, iniciaRonda, cartaJ1, cartaJ2, attr, j1, j2);

			// El resultado determina el ganador de la ronda.
			int resultado = juego.compararAtributos(attr, cartaJ1, cartaJ2);

			if (resultado == 0) {
				info += juego.empate(j1, j2, cartaJ1, cartaJ2);
			} else {
				if (resultado > 0) {
					info += juego.darCartasAlGanador(j1, cartaJ1, cartaJ2);
					iniciaRonda = j1;
				}
				if (resultado < 0) {
					info += juego.darCartasAlGanador(j2, cartaJ1, cartaJ2);
					iniciaRonda = j2;
				}
			}

			info += informacionFinal(j1, j2);
			System.out.println(info);

			ganador = juego.hayGanador(j1, j2);

			i++;
		}

		if (ganador == null)
			System.out.println("Los jugadores empataron");
		else
			System.out.println(ganador + " es el ganador de la partida!");
	}

	/**
	 * 
	 * Informa el numero de ronda Informa el atributo por el que los jugadores van a
	 * competir y que jugador lo eligio. Informa la cartas jugadas.
	 */
	public static String informacionInicial(int i, Jugador ini, Carta c1, Carta c2, String attr, Jugador j1,
			Jugador j2) {
		String info = "";
		info += "------- Ronda " + i + " -------" + "\n";
		info += "El jugador " + ini + " selecciona competir por atributo " + attr + "\n";
		info += j1 + " jugo la carta " + c1 + " con " + c1.getValorAtributoSinPocima(attr);
		if (c1.tienePocima())
			info += ", se aplico pócima " + c1.getNombrePocima() + " valor resultante " + c1.getValorAtributo(attr);
		info += "\n";
		info += j2 + " jugo la carta " + c2 + " con " + c2.getValorAtributoSinPocima(attr);
		if (c2.tienePocima())
			info += ", se aplico pócima " + c2.getNombrePocima() + " valor resultante " + c2.getValorAtributo(attr);
		info += "\n";
		return info;
	}

	public static String informacionFinal(Jugador j1, Jugador j2) {
		return j1 + " tiene: " + j1.totalCartas() + " cartas y " + j2 + " tiene: " + j2.totalCartas() + "\n";
	}

}
