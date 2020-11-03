package juego_cartas.estrategia;

import juego_cartas.modelo.Carta;

public class Estrategia_Obstinado extends Estrategia {

	private String atributo;
	
	public Estrategia_Obstinado(String nombre) {
		atributo = nombre;
	}

	@Override
	public String implementarEstrategia(Carta carta) {
		return atributo;
	}
}
