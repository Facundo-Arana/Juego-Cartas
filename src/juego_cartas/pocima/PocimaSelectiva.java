package juego_cartas.pocima;

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
	public int aplicar(Atributo attr) {
		if(attr.getNombre().equals(atributoAfectado)) 
			return pocima.aplicar(attr);
		
		return attr.getValor();
	}
	
	@Override
	public String toString() {
		return this.getNombre() + " de " + this.atributoAfectado;
	}

}
