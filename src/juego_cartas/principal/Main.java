package juego_cartas.principal;

import juego_cartas.estrategia.Estrategia_Ambicioso;
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
		// se crea a mazo y se cargan las cartas desde el archivo .json
		Mazo mazo = new Mazo();
		mazo = Mazo.cargarMazo("./superheroes.json");

		// se crean los jugadores definiendo sus nombre en el constructor
		Jugador j1 = new Jugador("Facundo");
		Jugador j2 = new Jugador("Gabriel");

		// se puede a�adir una estrategia a cada jugador (por defecto es timbero)
		Estrategia_Ambicioso est = new Estrategia_Ambicioso();
		j2.setEstrategia(est);

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

		// se define el numero de rondas, los jugadores y el mazo en el constructor del
		// juego
		Juego juego = new Juego(100, j1, j2, mazo);
		juego.setPocima(mana);
		juego.setPocima(espinaca);
		juego.setPocima(kriptonita);
		juego.setPocima(manaos);
		juego.setPocima(elixirFuerza);
		juego.setPocima(redBull);
		juego.setPocima(naranpol);
		juego.setPocima(dobleFilo);
		juego.setPocima(laNota);
		juego.setPocima(dolar);
		juego.setPocima(danonino);

		juego.jugar();
	}

}
