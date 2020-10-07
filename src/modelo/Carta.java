package modelo;

import java.util.ArrayList;

public class Carta {

	private String nombre;
	private ArrayList<Atributo> atributos;

	public Carta() { // creado para crear carta auxiliar
		this.nombre = "auxiliar";
		this.atributos = new ArrayList<>();
	}

	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new ArrayList<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setAtributo(String nombre, int valor) {
		Atributo atr = new Atributo(nombre, valor);
		atributos.add(atr);
	}

	/**
	 * @return el nombre de un atributo aleatorio.
	 */
	public Atributo getAtributoRandom() {
		int i = (int) (atributos.size() * Math.random());
		return atributos.get(i);
	}

	/**
	 * @return un atributo dado un nombre de atributo.
	 */
	public Atributo getAtributo(Atributo attr) {
		int i = atributos.indexOf(attr);
		return atributos.get(i);
	}

	@Override
	public boolean equals(Object o) {
		try {

			Carta otra = (Carta) o;

			if (this.getNombre().equals(otra.getNombre()))
				return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean perteneAlMismoMazo(Carta otra) {

		if (!this.equals(otra))

			if (atributos.containsAll(otra.atributos))

				if (otra.atributos.containsAll(atributos))
					return true;

		return false;
	}

	@Override
	public String toString() {
		return nombre;// "Carta [nombre=" + nombre + ", atributos=" + atributos + "]";
	}

	public int comparar(Atributo attr, Carta c2) {
		return getAtributo(attr).compareTo(c2.getAtributo(attr));
	}

}
