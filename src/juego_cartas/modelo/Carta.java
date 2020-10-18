package juego_cartas.modelo;

import java.util.HashMap;
import java.util.Map;

public class Carta {

	private String nombre;
	private Map<String, Integer> atributos;
	
	public Carta() { 
		this("auxiliar");
	}

	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new HashMap<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setAtributo(String nombre, int valor) {
		atributos.put(nombre, valor);
	}

	/**
	 * 
	 * @return el nombre de un atributo aleatorio.
	 */
	public String getAtributoRandom() {
		Object[] keys = atributos.keySet().toArray();
		int i = (int) (Math.random() * atributos.size());
		
		return keys[i].toString();
	}

	/**
	 * 
	 * @return un atributo dado un nombre de atributo.
	 */
	public int getValorAtributo(String attr) {
		return atributos.get(attr);
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
		for (String atributo : atributos.keySet()) {
			if (!otra.contieneAtributo(atributo))
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @return si en el mapa de atributos existe la clave recibida.
	 */
	public boolean contieneAtributo(String atributo) {
		return atributos.containsKey(atributo);
	}


	/**
	 * 
	 * Se compara un atributo dado con el mismo atributo de otra carta.
	 */
	public int comparar(String attr, Carta c2) {
		return getValorAtributo(attr) - c2.getValorAtributo(attr);
	}

	/**
	 * 
	 * Muestra los atributos de la carta.
	 */
	public void mostrarAtributos() {
		for (String atributo : atributos.keySet()) {
			Integer valor = atributos.get(atributo);
			System.out.println(atributo + "  ->  " + valor);
		}
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
	
	@Override
	public String toString() {
		return nombre;
	}
}
