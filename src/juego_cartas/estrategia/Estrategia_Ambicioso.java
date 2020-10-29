package juego_cartas.estrategia;

import juego_cartas.modelo.Carta;

public class Estrategia_Ambicioso extends Estrategia {

	@Override
	public String implementarEstrategia(Carta carta) {
		return carta.getAtributoMayor();
	}

}
