package juego_cartas.estrategia;

import juego_cartas.modelo.Carta;

public  class Estrategia_Timbero extends Estrategia {

	@Override
	public String implementarEstrategia(Carta carta) {
		return carta.getAtributoRandom();
	}

}
