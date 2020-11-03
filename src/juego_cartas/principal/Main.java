package juego_cartas.principal;

import juego_cartas.estrategia.Estrategia_Ambicioso;
import juego_cartas.modelo.Carta;
import juego_cartas.modelo.Juego;
import juego_cartas.modelo.Jugador;
import juego_cartas.modelo.Mazo;
import juego_cartas.pocima.PocimaCocktail;
import juego_cartas.pocima.PocimaDebilitadora;
import juego_cartas.pocima.PocimaFortalecedora;
import juego_cartas.pocima.PocimaNumeroMagico;
import juego_cartas.pocima.PocimaSelectiva;

public class Main {

	public static void main(String[] args) {
		// se define el numero de rondas en el constructor del juego
		Juego juego = new Juego(100);

		// se crea a mazo y se cargan las cartas desde el archivo .json
		Mazo mazo = new Mazo();
		mazo = Mazo.cargarMazo("./autos.json");

		// se crean los jugadores definiendo sus nombre en el constructor
		Jugador j1 = new Jugador("Facundo");
		Jugador j2 = new Jugador("Gabriel");

		// se puede añadir una estrategia a cada jugador (por defecto es timbero)
		Estrategia_Ambicioso est = new Estrategia_Ambicioso();
		j2.setEstrategia(est);

		// se pueden añadir pocimas al juego que alteran los valores de las cartas
		// cada pocima lleva un nombre y un porcentaje
		PocimaFortalecedora mana = new PocimaFortalecedora("mana", 30);
		PocimaFortalecedora espinaca = new PocimaFortalecedora("espinaca", 40);
		PocimaFortalecedora sumum = new PocimaFortalecedora("sumum", 130);

		PocimaDebilitadora kriptonita = new PocimaDebilitadora("kriptonita", 50);
		PocimaDebilitadora manaos = new PocimaDebilitadora("manaos", 90);

		PocimaSelectiva elixirFuerza = new PocimaSelectiva("elixirFuerza", "fuerza", mana);
		PocimaSelectiva redBull = new PocimaSelectiva("redBull", "velocidad", espinaca);
		PocimaSelectiva danonino = new PocimaSelectiva("danonino", "altura", espinaca);
		
		PocimaSelectiva laDelDiego = new PocimaSelectiva("laDelDiego", "peleas ganadas", sumum);
		PocimaSelectiva sopaDeCaracol = new PocimaSelectiva("sopaDeCaracol", "velocidad", manaos);

		PocimaCocktail naranpol = new PocimaCocktail("naranpol", mana, kriptonita);
		PocimaCocktail dobleFilo = new PocimaCocktail("dobleFilo", sopaDeCaracol, laDelDiego);

		PocimaNumeroMagico laNota = new PocimaNumeroMagico("nota-tp", 10);
		PocimaNumeroMagico dolar = new PocimaNumeroMagico("dolar-Value", 78);
		
		
		juego.addPocima(mana);
		juego.addPocima(espinaca);
		juego.addPocima(kriptonita);
		juego.addPocima(manaos);
		juego.addPocima(elixirFuerza);
		juego.addPocima(redBull);
		juego.addPocima(naranpol);
		juego.addPocima(dobleFilo);
		juego.addPocima(laNota);
		juego.addPocima(dolar);
		juego.addPocima(danonino);
		// se reparten las cartas luego de haber incoporado las pocimas
		juego.repartirCartas(j1, j2, mazo);

		// auxiliares
		int i = 1;
		Jugador ganador = null;
		Jugador iniciaRonda = j1;

		// inicia el juego hasta que gane un jugador o se cumpla el total de rondas definidas
		
		while ((ganador == null) && (i <= juego.getMaxJugadas())) {

			// String { info }: recolecta la informacion porporcionada por los distintos metodos
			String info = "";

			// El jugador ganador de la ultima ronda elije el atributo
			String attr = iniciaRonda.seleccionarAtributo();

			// LOS DOS JUGADORES SUELTAN SU CARTA
			Carta cartaJ1 = j1.soltarCarta();
			Carta cartaJ2 = j2.soltarCarta();

			info += informacionInicial(i, iniciaRonda, cartaJ1, cartaJ2, attr, j1, j2);

			// se determina el ganador de la ronda
			int resultado = juego.compararAtributos(attr, cartaJ1, cartaJ2);

			// se reparten las cartas jugadas dependiendo el resultado
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

			// se informa todo lo ocurrido en la ronda
			info += informacionFinal(j1, j2);
			System.out.println(info);

			// se determina si hay ganador
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
		if (c1.tienePocima()) {
			info += ", se aplico pócima " + c1.getNombrePocima();
			if (c1.getValorAtributo(attr) == c1.getValorAtributoSinPocima(attr))
				info += " (no tuvo efecto)";
			else
				info += " valor resultante " + c1.getValorAtributo(attr);
		}
		info += "\n";
		info += j2 + " jugo la carta " + c2 + " con " + c2.getValorAtributoSinPocima(attr);
		if (c2.tienePocima()) {
			info += ", se aplico pócima " + c2.getNombrePocima();
			if (c2.getValorAtributo(attr) == c2.getValorAtributoSinPocima(attr))
				info += " (no tuvo efecto)";
			else
				info += " valor resultante " + c2.getValorAtributo(attr);
		}
		info += "\n";
		return info;
	}

	public static String informacionFinal(Jugador j1, Jugador j2) {
		return j1 + " tiene: " + j1.totalCartas() + " cartas y " + j2 + " tiene: " + j2.totalCartas() + "\n";
	}

}
