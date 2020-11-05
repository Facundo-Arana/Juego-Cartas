package juego_cartas.pocima;

public class PocimaDebilitadora extends Pocima {
	private int decremento;

	public PocimaDebilitadora(String nombre, int decremento) {
		super(nombre);
		if (decremento > 100)
			this.decremento = 100;
		this.decremento = decremento;
	}

	@Override
	public int aplicar(int valor, String nombre) {
		int porcentajeDecremento = (int) ((valor * this.decremento) / 100);
		return valor - porcentajeDecremento;
	}

	@Override
	public String infoJugada(int valor, String nombre) {
		String info = "";
		info += ", se aplico pócima " + this.nombre;
		info += " valor resultante " + this.aplicar(valor, nombre);
		return info;
	}
}
