package juego_cartas.modelo.pocima;

import juego_cartas.modelo.Atributo;

public class PocimaFortalecedora extends Pocima {

	private int aumento;

	public PocimaFortalecedora(String nombre, int aumento) {
		super(nombre);
		this.aumento = aumento;
	}

	@Override
	public int aplicar(Atributo attr) {
		int valor = attr.getValor();	
		int porcentaje = (int) Math.floor(valor * this.aumento / 100);	
		int nuevoValor = valor + porcentaje;	
		return nuevoValor;	
	}

}
