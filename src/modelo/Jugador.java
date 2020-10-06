package modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jugador {

	private String nombre;
	private Mazo cartas;

	public Jugador(String nombre) {
		this.nombre = nombre;
		cartas = new Mazo();
	}
	
	public Carta tomarCarta() {
		Carta aux= new Carta();
		aux = this.cartas.pop();
		return aux;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Mazo getMazo() {
		return this.cartas;
	}

	public boolean tieneCartas() {
		return cartas.size() > 0;
	}

	public String seleccionarAtributoRandom() {
		return cartas.get().getAtributoRandom();
	}
	
	/*///////////////////////////////////////////////
	 * 		Setear nombre de Jugadores Por Teclado 
	 *///////////////////////////////////////////////*/
	
	public void crearNombre() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String nombre = "";
		do {
			try {
				System.out.println("Ingrese Nombre Jugador:");
				nombre = new String(entrada.readLine());
			} catch (Exception exc) {
				System.out.println(exc);
			}
		} while (nombre == "");

		this.setNombre(nombre);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
