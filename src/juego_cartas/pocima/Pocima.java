package juego_cartas.pocima;

public abstract class Pocima {
	
	protected String nombre;
	
	public Pocima(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String toString() {
		return this.getNombre();
	}
	
	public abstract int aplicar(int valor, String nombre);

	public abstract String infoJugada(int valor, String nombre);

	
}
