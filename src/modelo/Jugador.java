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
	
	public int totalCartas() {
		return cartas.size();
	}

	public Carta soltarCarta() {
		return this.cartas.pop();
	}

	public void tomarCarta(Carta c) {
		this.cartas.push(c);
	}

	public String getNombre() {
		return this.nombre;
	}

	public void mostrarCartas() {
		this.cartas.mostrarCartas();
	}

	public boolean tieneCartas() {
		return cartas.size() > 0;
	}

	public Atributo seleccionarAtributoRandom() {
		return cartas.getPrimeraCarta().getAtributoRandom();
	}

	@Override
	public String toString() {
		return nombre;
	}

	/*
	 * Setear nombre de Jugadores.
	 */
	public void crearNombre() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String nombre = "";
		while (nombre == "") {
			try {
				System.out.println("Ingrese Nombre Jugador:");
				nombre = new String(entrada.readLine());
			} catch (Exception exc) {
				nombre = "";
			}
		}
		this.setNombre(nombre);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
