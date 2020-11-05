package juego_cartas.pocima;

public class PocimaNumeroMagico extends Pocima {
	private int numeroMagico;

	public PocimaNumeroMagico(String nombre, int numeroMagico) {
		super(nombre);
		this.numeroMagico = numeroMagico;
	}

	@Override
	public int aplicar(int valor, String nombre) {
		return this.numeroMagico;
	}

	@Override
	public String infoJugada(int valor, String nombre) {
		String info = "";
		info += ", se aplico pócima " + this.nombre;
		info += " valor resultante " + this.numeroMagico;
		return info;
	}

}
