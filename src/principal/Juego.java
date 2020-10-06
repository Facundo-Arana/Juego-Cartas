package principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import modelo.Carta;
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

		//mazo.mostrarCartas();//TODO solo muestra superman

		Jugador j1 = new Jugador("Facundo");
		//j1.crearNombre();
		Jugador j2 = new Jugador("Gabriel");
		//j2.crearNombre();
		
		juego.repartir(j1, j2, mazo);
		
		//int turnos=juego.cantidadTurnos();
		int auxPrueba = 6;//para no pregunta a cada rato mando un valor fijo
		juego.jugar(j1, j2,auxPrueba);

	}
														
	public void jugar(Jugador j1, Jugador j2,Integer turnos) {
		int i = 0;
		boolean ganador = false;
		
//		System.out.println("cartas j1");
//		j1.getMazo().imprimirMazo();
//		
//		System.out.println("cartas j2");
//		j2.getMazo().imprimirMazo();
//		
		while(ganador==false && i < turnos) {
				
			Carta cartaJ1 = new Carta();
			Carta cartaJ2 = new Carta();
						
			cartaJ1 = j1.tomarCarta();
			cartaJ2 = j2.tomarCarta();
			
		System.out.println(cartaJ1);
		System.out.println(" ");
		
			//seleccionar atributo ramdon aca
		
			//compara atributos de ambas cartas
			
			i++;				 
			}
	}

	/**
	 * Mezcla y reparte cartas a los jugadores.
	 */
	public void repartir(Jugador j1, Jugador j2, Mazo mazo) {
		mazo.mezclarCartas();
//	mazo.mostrarCartas();
		
//		System.out.println(mazo.size());
		//mazo.imprimirMazo();
		
		for (int i = mazo.size(); i > 0; i--) {
			if ((i % 2) == 0)
				j1.getMazo().push(mazo.pop());
			else
				j2.getMazo().push(mazo.pop());
		}
	}
	
	/**
	 * Seleciona la cantidad de turnos a Jugar
	 */
	public int cantidadTurnos() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int turnos = 0;
		do {
			System.out.println("Ingrese Cantidad de Turnos a Jugar:");
			try {
				turnos = new Integer(entrada.readLine());
			} catch (Exception exc) {
				System.out.println("Error valor no valido");
			}
		} while (turnos < 0);
		return turnos;
	}

}
