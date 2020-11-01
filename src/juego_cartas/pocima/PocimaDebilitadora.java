package juego_cartas.pocima;

import juego_cartas.modelo.Atributo;

public class PocimaDebilitadora extends Pocima {
	private int decremento;

	public PocimaDebilitadora(String nombre, int decremento) {
		super(nombre);
		if(decremento > 100)
			this.decremento = 100;
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
