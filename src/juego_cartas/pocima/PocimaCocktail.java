package juego_cartas.pocima;

import juego_cartas.modelo.Atributo;

public class PocimaCocktail extends Pocima {

	private Pocima primerPocima;
	private Pocima segundaPocima;

	public PocimaCocktail(String nombre, Pocima primerPocima, Pocima segundaPocima) {
		super(nombre);
		this.primerPocima = primerPocima;
		this.segundaPocima = segundaPocima;
	}

	@Override
	public int aplicar(Atributo attr) {
		int valor = attr.getValor(primerPocima);
		Atributo aux = new Atributo(attr.getNombre(), valor);
		return aux.getValor(segundaPocima);
	}

}
