package juego_cartas.modelo.pocima;

import juego_cartas.modelo.Atributo;

public class PocimaDebilitadora extends Pocima {
	private int decremento;

	public PocimaDebilitadora(String nombre, int decremento) {
		super(nombre);
		if(decremento>99)
			this.decremento=99;
		this.decremento = decremento;
	}

	@Override
	public int aplicar(Atributo attr) {
		int valor = attr.getValor();
		int porcentajeDecremento = (int) ((valor * this.decremento) / 100);		
		int nuevoValor = valor - porcentajeDecremento;
		
		return nuevoValor;
	}
}
