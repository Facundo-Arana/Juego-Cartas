package juego_cartas.pocima;

public class PocimaSelectiva extends Pocima {

	private String atributoAfectado;
	private Pocima pocima;

	public PocimaSelectiva(String nombre, String atributoAfectado, Pocima pocima) {
		super(nombre);
		this.atributoAfectado = atributoAfectado;
		this.pocima = pocima;
	}

	@Override
	public int aplicar(int valor, String nombre) {
		if (nombre.equals(atributoAfectado))
			return pocima.aplicar(valor, nombre);
		return valor;
	}

	@Override
	public String infoJugada(int valor, String nombre) {
		String info = "";
		if (nombre.equals(atributoAfectado)) {
			info += ", se aplico pócima " + this.nombre;
			info += " valor resultante " + this.aplicar(valor, nombre);
		}
		return info;
	}

}
