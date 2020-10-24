package juego_cartas.principal;

import juego_cartas.modelo.Carta;
import juego_cartas.modelo.Juego;
import juego_cartas.modelo.Jugador;
import juego_cartas.modelo.Mazo;
import juego_cartas.modelo.pocima.PocimaCocktail;
import juego_cartas.modelo.pocima.PocimaDebilitadora;
import juego_cartas.modelo.pocima.PocimaFortalecedora;
import juego_cartas.modelo.pocima.PocimaSelectiva;

public class Main {

	public static void main(String[] args) {

		Juego juego = new Juego(100);
		Mazo mazo = new Mazo();
		mazo = Mazo.cargarMazo("./superheroes.json");
		Jugador j1 = new Jugador("Facundo");
		Jugador j2 = new Jugador("Gabriel");

		PocimaFortalecedora p1 = new PocimaFortalecedora("foralecedora", 100);
		PocimaDebilitadora p2 = new PocimaDebilitadora("debilitadora", 100);
		PocimaCocktail p3 = new PocimaCocktail("cocktail", p1, p2);
		PocimaSelectiva p4 = new PocimaSelectiva("selectiva", "fuerza", p1);
	
		juego.addPocima(p1);
		juego.addPocima(p2);
		juego.addPocima(p3);
		juego.addPocima(p4);
	
		juego.repartirCartas(j1, j2, mazo);

		int i = 1;
		Jugador ganador = null;
		Jugador iniciaRonda = j1;

		while ((ganador == null) && (i <= juego.getMaxJugadas())) {
			String info = "";

			// El jugador ganador de la ultima ronda elije el atributo.
			String attr = iniciaRonda.seleccionarAtributoRandom();

			// LOS DOS JUGADORES SUELTAN SU CARTA.
			Carta cartaJ1 = j1.soltarCarta();
			Carta cartaJ2 = j2.soltarCarta();

			info += juego.informacionInicial(i, iniciaRonda, cartaJ1, cartaJ2, attr, j1, j2);

			// determina quien inicia la proxima ronda eh informa quien gana.
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

			info += juego.informacionFinal(j1, j2);
			System.out.println(info);

			ganador = juego.hayGanador(j1, j2);

			i++;
		}

		if (ganador == null)
			System.out.println("Los jugadores empataron");
		else
			System.out.println(ganador + " es el ganador de la partida!");
	}

}
