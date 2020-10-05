package modelo;

public class Jugador {

	private String nombre;
	private Mazo cartas;

	public Jugador(String nombre) {
		this.nombre = nombre;
		cartas = new Mazo();
	}

	public String getNombre() {
		return this.nombre;
	}

	public Mazo getMazo() {
		return this.cartas;
	}

	
	public boolean tieneCartas() {
		return cartas.size() > 0;
	}

	public String seleccionarAtributoRandom() {
		return cartas.get().getAtributoRandom();
	}
}
