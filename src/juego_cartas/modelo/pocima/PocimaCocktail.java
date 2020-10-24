package juego_cartas.modelo.pocima;

import juego_cartas.modelo.Atributo;

public class PocimaCocktail extends Pocima {

	private Pocima primerIngrediente;
	private Pocima segundoIngrediente;
	
	public PocimaCocktail(String nombre, Pocima primerPocima, Pocima segundaPocima) {
		super(nombre);
		this.primerIngrediente = primerPocima;
		this.segundoIngrediente = segundaPocima;
	}
	
	@Override
	public int aplicar(Atributo attr) {	
		attr.setValor(this.primerIngrediente.aplicar(attr)); 	
		return this.segundoIngrediente.aplicar(attr);
	}

}
