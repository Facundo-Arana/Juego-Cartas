package juego_cartas.pocima;

import juego_cartas.modelo.Atributo;

public abstract class Pocima {
	
	private String nombre;
	
	public Pocima(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String toString() {
		return this.getNombre();
	}
	
	public abstract int aplicar(Atributo attr);

}
