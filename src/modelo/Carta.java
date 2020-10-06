package modelo;

import java.util.ArrayList;

public class Carta {

	private String nombre;
	private ArrayList<Atributo> atributos;

	public Carta() {    //creado para crear carta auxiliar
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

	public void setAtributo(String nombre, double valor) {
		Atributo atr = new Atributo(nombre, valor);
		atributos.add(atr);
	}

	/**
	 * @return el nombre de un atributo aleatorio.
	 */
	public String getAtributoRandom() {
		int i = (int) (atributos.size() * Math.random());
		return atributos.get(i).getNombre();
	}

	/**
	 * @return un atributo dado un nombre de atributo.
	 */
	public Atributo getAtributo(String nombre) {
		int i = atributos.indexOf(nombre);
		Atributo atr = atributos.get(i);
		return atr;
	}

	@Override
	public boolean equals(Object o) {
		try {
			Carta otra = (Carta) o;

			// dos cartas son iguales si comparten todos los atributos una con la otra
			// y ademas deben tener distinto nombre.

			
				if (this.atributos.containsAll(otra.atributos))
					if (otra.atributos.containsAll(this.atributos))
						return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Carta [nombre=" + nombre + ", atributos=" + atributos + "]";
	}

}
