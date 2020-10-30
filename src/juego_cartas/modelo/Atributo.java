package juego_cartas.modelo;

import juego_cartas.pocima.Pocima;

public class Atributo implements Comparable<Atributo> {

	private String nombre;
	private int valor;

	public Atributo(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public int getValor() {
		return this.valor;
	}

	public int getValor(Pocima pocima) {
		return pocima.aplicar(this);
	}

	@Override
	public int compareTo(Atributo otro) {
		return this.getValor() - otro.getValor();
	}

	@Override
	public boolean equals(Object o) {
		try {
			Atributo otro = (Atributo) o;

			if (this.getNombre().equals(otro.getNombre()))
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return nombre + " " + valor;
	}

	public String getNombre() {
		return this.nombre;
	}
}
