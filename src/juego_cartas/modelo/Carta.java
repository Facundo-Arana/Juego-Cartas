package juego_cartas.modelo;

import java.util.ArrayList;
import java.util.HashMap;

import juego_cartas.modelo.pocima.Pocima;

public class Carta {

	private String nombre;
	private Pocima pocima;
	private ArrayList<Atributo> atributos;

	public Carta() {
		this("auxiliar");
	}

	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new ArrayList<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public boolean tienePocima() {
		return this.pocima != null;
	}

	public boolean setPocima(Pocima pocima) {
		if (!this.tienePocima()) {
			this.pocima = pocima;
			return true;
		}
		return false;
	}

	public void setAtributo(String nombre, int valor) {
		Atributo nuevo = new Atributo(nombre, valor);
		atributos.add(nuevo);
	}

	/**
	 * 
	 * @return el nombre de un atributo aleatorio.
	 */
	public String getAtributoRandom() {
		int i = (int) (Math.random() * atributos.size());
		return atributos.get(i).getNombre();
	}

	/**
	 * 
	 * @param attr es el nombre del atributo.
	 * @return el valor del atributo dado.
	 */
	public int getValorAtributo(String attr) {
		for (int i = 0; i < atributos.size(); i++) {
			if (atributos.get(i).getNombre().equals(attr))
				return atributos.get(i).getValor();
		}
		return 0;
	}

	/**
	 * 
	 * Compara dos cartas para saber si pertenecen al mismo mazo.
	 */
	public boolean perteneAlMismoMazo(Carta otra) {
		if (!this.equals(otra))
			if (this.contieneLosMismosAtributos(otra))
				if (otra.contieneLosMismosAtributos(this))
					return true;	
		return false;
	}

	/**
	 * 
	 * Compara dos cartas para saber si comparten los mismos atributos.
	 */
	public boolean contieneLosMismosAtributos(Carta otra) {
		for (Atributo atributo : this.atributos) 
			if (!otra.contieneAtributo(atributo))
				return false;
		return true;
	}

	/**
	 * 
	 * @return si existe un atributo igual al atributo dado.
	 */
	public boolean contieneAtributo(Atributo atributo) {
		return atributos.contains(atributo);
	}

	@Override
	public boolean equals(Object o) {
		try {
			Carta otra = (Carta) o;
			if (this.getNombre().equals(otra.getNombre()))
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return nombre;
	}

	/**
	 * 
	 * Muestra los atributos de la carta.
	 */
	public void mostrarAtributos() {
		for (Atributo atributo : this.atributos) 
			System.out.println(atributo);
	}
}
