package juego_cartas.estrategia;

import juego_cartas.modelo.Carta;

public abstract class Estrategia {

	public abstract String implementarEstrategia(Carta carta);
	
}

//1. Timbero. Es la estrategia que se utilizó hasta el momento. En cada ronda, el jugador
//elige al azar el atributo por el cual se desea competir

//2. Ambicioso. El jugador elige el atributo que posea el mayor valor de su carta del
//turno.

//3. Obstinado. El jugador elige siempre el mismo atributo para competir, ronda tras
//ronda.

