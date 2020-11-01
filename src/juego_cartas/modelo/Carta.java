package juego_cartas.modelo;

import java.util.ArrayList;

import juego_cartas.pocima.Pocima;

public class Carta {

	private String nombre;
	private Pocima pocima;
	private ArrayList<Atributo> atributos;

	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new ArrayList<>();
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void setAtributo(String nombre, int valor) {
		Atributo nuevo = new Atributo(nombre, valor);
		atributos.add(nuevo);
	}
	
	/**
	 * 
	 * @param attr es el nombre del atributo.
	 * @return el valor del atributo dado, puede ser alterado por una pocima.
	 */
	public int getValorAtributo(String attr) {
		for (Atributo atributo : this.atributos) {
			
			if (atributo.getNombre().equals(attr)) {
				
				if (this.tienePocima())
					return atributo.getValor(pocima);
				
				else
					return atributo.getValor();
			}
		}
		return 0;
	}
	
	public void mostrarAtributos() {
		for (Atributo atributo : this.atributos)
			System.out.println(atributo);
	}	

	// ---------------------- Estrategias ---------------------------//

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
	 * @return el nombre del atributo con mayor valor.
	 */
	public String getAtributoMayor() {
		String attrMayor = "";
		int valorMayor = -1;

		for (Atributo atributo : atributos) {
			int aux = -1;
			if (this.tienePocima()) {
				aux = atributo.getValor(pocima);
			} else {
				aux = atributo.getValor();
			}

			if (aux > valorMayor) {
				attrMayor = atributo.getNombre();
				valorMayor = aux;
			}
		}

		return attrMayor;
	}


	///// ------------------- metodos comparativos ------------------//////////

	/**
	 * Compara dos cartas para saber si pertenecen al mismo mazo. Tienen que tener
	 * nombre distintos y compartir todos los atributos.
	 */
	public boolean perteneAlMismoMazo(Carta otra) {
		if (!this.equals(otra))
			if (this.contieneLosMismosAtributos(otra))
				if (otra.contieneLosMismosAtributos(this))
					return true;
		return false;
	}

	/**
	 * Compara dos cartas para saber si comparten los mismos atributos.
	 */
	public boolean contieneLosMismosAtributos(Carta otra) {
		for (Atributo atributo : this.atributos)
			if (!otra.contieneAtributo(atributo))
				return false;
		return true;
	}

	/**
	 * @return true si existe un atributo igual al atributo dado.
	 */
	public boolean contieneAtributo(Atributo atributo) {
		return atributos.contains(atributo);
	}

	//-------------------- Pocimas -------------------//
	
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
	
	public String getNombrePocima() {
		return this.pocima.toString();
	}
	
	public int getValorAtributoSinPocima(String attr) {
		for (Atributo atributo : this.atributos)
			if (atributo.getNombre().equals(attr))
				return atributo.getValor();
		return 0;
	}
	
	
	///// --------------- metodos informativos -------------///////////
	@Override
	public String toString() {
		return nombre;
	}
	@Override
	public boolean equals(Object o) {
		try {
			Carta otra = (Carta) o;
			return this.getNombre().equals(otra.getNombre());

		} catch (Exception e) {
			return false;
		}
	}

}
