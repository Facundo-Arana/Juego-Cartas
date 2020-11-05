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

	

	public ArrayList<String> getNombresAtributos(){
		ArrayList<String> retorno = new ArrayList<>();
		for (Atributo atributo : atributos) {
			retorno.add(atributo.getNombre());
		}
		return retorno;
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
	
	public Carta getCopia() {
		Carta copia = new Carta(this.getNombre());
		if(this.tienePocima())
			copia.setPocima(this.pocima);
		for (Atributo atributo : this.atributos)
				copia.setAtributo(atributo.getNombre(), atributo.getValor());
		return copia;
	}

	/**
	 * @return true si existe un atributo igual al atributo dado.
	 */
	public boolean contieneAtributo(Atributo atributo) {
		return atributos.contains(atributo);
	}

	// -------------------- Pocimas -------------------//

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
	
	public void mostrarAtributos() {
		for (Atributo atributo : this.atributos)
			System.out.println(atributo);
	}
	
	//----------------------------------------------------------//
	
	public String infoJugada(Jugador j,Carta carta, String attr) {
		String info=""; 

		info += j + " jugo la carta " + carta + " con " + carta.getValorAtributo(attr);
		
		if(tienePocima()) 
			info += pocima.infoJugada(carta.getValorAtributo(attr), attr);

				
		return info;
	}
	
	
	
	/**
	 * 
	 * @param attr es el nombre del atributo.
	 */
	public int getValorAtributo(String attr) {
		for (Atributo atributo : this.atributos) {
			if (atributo.getNombre().equals(attr)) {
			
				return atributo.getValor();
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * @param attr es el nombre del atributo.
	 * @return el valor del atributo dado, es alterado por una pocima.
	 */
	public int getValorPocimaAplicada(String attr) {
		for (Atributo atributo : this.atributos) {
			if (atributo.getNombre().equals(attr)) {
				return pocima.aplicar(atributo.getValor(), atributo.getNombre());
			}
		}
		return 0;
	}

	
}
