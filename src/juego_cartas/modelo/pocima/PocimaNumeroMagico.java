package juego_cartas.modelo.pocima;

import juego_cartas.modelo.Atributo;

public class PocimaNumeroMagico extends Pocima {
	private int numeroMagico;

	public PocimaNumeroMagico(String nombre, int numeroMagico) {
		super(nombre);
		this.numeroMagico = numeroMagico;
	}

	@Override
	public void aplicar(Atributo attr) {
		attr.setValor(this.numeroMagico);
	}

}
