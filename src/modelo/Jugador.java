package modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Jugador {

	private String nombre;
	private Mazo cartas;

	public Jugador(String nombre) {
		this.nombre = nombre;
		cartas = new Mazo();
	}

	public String getNombre() {
		return this.nombre;
	}

	public Mazo getMazo() {
		return this.cartas;
	}

}
