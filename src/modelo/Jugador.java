package modelo;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private ArrayList<Carta> cartas;

	public Jugador(String nombre) {
		this.nombre = nombre;
		cartas = new ArrayList<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	// recibe una carta y la coloca en la posicion 0.
	public void push(Carta c) {
		cartas.add(0, c);
	}

	// devuelve la ultima carta y la borra.
	public Carta pop() {
		int ultimaCarta = cartas.size() - 1;
		Carta aux = cartas.get(ultimaCarta);
		cartas.remove(ultimaCarta);
		return aux;
	}

}
