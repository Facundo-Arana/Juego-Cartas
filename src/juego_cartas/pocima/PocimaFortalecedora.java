package juego_cartas.pocima;

public class PocimaFortalecedora extends Pocima {

	private int aumento;

	public PocimaFortalecedora(String nombre, int aumento) {
		super(nombre);
		this.aumento = aumento;
	}

	@Override
	public int aplicar(int valor, String nombre) {
		int porcentajeAumento = (int) Math.floor(valor * this.aumento / 100);	
		return valor + porcentajeAumento;
	}

}
