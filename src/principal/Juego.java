package principal;

import modelo.Jugador;
import modelo.Mazo;

public class Juego {

	/**
	 * Descripcion de como se desarrollara el juego.
	 * 
	 * // primero lo que ocurre en el main.
	 * 
	 * crear Juego
	 * 
	 * crear Mazo
	 * 
	 * crear Jugador (j1 y j2).
	 * 
	 * cargar mazo
	 * 
	 * juego.repartirCartas(j1, j2, mazo); 
	 * 
	 * El mazo inicial se repartira en partes iguales a cada jugador, El jugador
	 * tendra su propio mazo que sera una mitad del mazo inicial. El mazo inicial
	 * quedara vacio luego de ser repartido.
	 * 
	 * juego.jugar(j1, j2);
	 * 
	 * El metodo jugar() se encargara de verificar las jugadas hasta que resulte un
	 * ganador o se de el maximo de rondas.
	 * 
	 * //termina lo que se realiza en el main.
	 * 
	 * 
	 * arrancan las jugadas (bucle while hasta MAX_JUGADAS o resulte un ganador).
	 * 
	 * jugador 1 elije el atributo a comparar. //String del nombre del atributo.
	 * 
	 * j1 y j2 sueltan sus cartas(pop).
	 * 
	 * de cada carta se obtiene el atributo seleccionado y se comparan.
	 * 
	 * se reparten las cartas segun el resultado de esta comparacion.
	 * 
	 * y asi hasta que termine.
	 * 
	 */

	public static void main(String[] args) {
		Juego juego = new Juego();
		Mazo mazo = new Mazo();

		mazo = Mazo.cargarMazo("./superheroes.json");

		mazo.mostrarCartas();

		Jugador j1 = new Jugador("Facundo");
		Jugador j2 = new Jugador("Gabriel");

		juego.repartir(j1, j2, mazo);

		juego.jugar(j1, j2);

	}

	public void jugar(Jugador j1, Jugador j2) {

		// TODO

	}

	/**
	 * Mezcla y reparte cartas a los jugadores.
	 */
	public void repartir(Jugador j1, Jugador j2, Mazo mazo) {
		mazo.mezclarCartas();

		for (int i = mazo.size(); i > 0; i--) {

			if ((i % 2) == 0)
				j1.getMazo().push(mazo.pop());

			else
				j2.getMazo().push(mazo.pop());

		}
	}

}
