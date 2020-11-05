package juego_cartas.pocima;

public class PocimaCocktail extends Pocima {

	private Pocima primerPocima;
	private Pocima segundaPocima;

	public PocimaCocktail(String nombre, Pocima primerPocima, Pocima segundaPocima) {
		super(nombre);
		this.primerPocima = primerPocima;
		this.segundaPocima = segundaPocima;
	}

	@Override
	public int aplicar(int valor, String nombre) {
		int valorIntermedio = primerPocima.aplicar(valor, nombre);
		return segundaPocima.aplicar(valorIntermedio, nombre);
	}

	@Override
	public String infoJugada(int valor, String nombre) {
		String info = "";
		info += primerPocima.infoJugada(valor, nombre);
		info += segundaPocima.infoJugada(valor, nombre);
		return info;
	}

}
