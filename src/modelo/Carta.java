package modelo;

import java.util.ArrayList;

public class Carta {

	private String nombre;
	private ArrayList<Atributo> atributos;

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

	public Atributo getAtributo(String nombre) {
		Atributo atr = buscarAtributo(nombre);
		return atr;
	}

	public Atributo buscarAtributo(String nombre) {
		int i = atributos.lastIndexOf(nombre);
		return atributos.get(i);
	}

	@Override
	public boolean equals(Object o) {
		try {
			Carta otra = (Carta) o;
			
			// dos cartas son iguales si comparten todos los atributos una con la otra
			// y ademas deben tener distinto nombre.
			
			if (!this.getNombre().equals(otra.getNombre()))
				if (this.atributos.containsAll(otra.atributos))
					if (otra.atributos.containsAll(this.atributos))
						return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
