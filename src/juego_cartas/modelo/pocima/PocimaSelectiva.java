package juego_cartas.modelo.pocima;

import juego_cartas.modelo.Atributo;

public class PocimaSelectiva extends Pocima {

	private String atributoAfectado;
	private Pocima pocima;
	
	public PocimaSelectiva(String nombre, String atributoAfectado, Pocima pocima) {
		super(nombre);
		this.atributoAfectado = atributoAfectado;
		this.pocima = pocima;
	}

	@Override
	public void aplicar(Atributo attr) {
		if(attr.getNombre().equals(atributoAfectado))
			this.pocima.aplicar(attr);
	}

}
