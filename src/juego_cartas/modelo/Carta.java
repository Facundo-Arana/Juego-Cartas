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
	private boolean contieneLosMismosAtributos(Carta otra) {
		for (Atributo atributo : this.atributos)
			if (!otra.contieneAtributo(atributo))
				return false;
		return true;
	}
	
	
	/**
	 * 
	 * @return una copia de la carta.
	 */
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
	private boolean contieneAtributo(Atributo atributo) {
		return atributos.contains(atributo);
	}

	// -------------------- Pocimas -------------------//

	private boolean tienePocima() {
		return this.pocima != null;
	}

	public boolean setPocima(Pocima pocima) {
		if (!this.tienePocima()) {
			this.pocima = pocima;
			return true;
		}
		return false;
	}

	///// --------------- metodos informativos -------------///////////
	
	public String infoJugada(Jugador j,Carta carta, String attr) {
		String info=""; 

		info += j + " jugo la carta " + carta + " con " + attr + " " + carta.getValor(attr);
		
		if(tienePocima()) 
			info += pocima.infoJugada(carta.getValor(attr), attr);
		
		return info;
	}
	
	/**
	 * 
	 * @param attr es el nombre del atributo.
	 */
	public int getValor(String attr) {
		for (Atributo atributo : this.atributos) {
			if (atributo.getNombre().equals(attr)) {
				if(this.pocima != null) {					
					return this.pocima.aplicar(atributo.getValor(), attr);
				}
				else {					
					return atributo.getValor();
				}
			}
		}
		return 0;
	}
	
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
