package juego_cartas.estrategia;

import java.util.ArrayList;

import juego_cartas.modelo.Carta;

public class Estrategia_Timbero implements Estrategia {

	@Override
	public String implementarEstrategia(Carta carta) {
		ArrayList<String> atributos = carta.getNombresAtributos();
		int i = (int) (Math.random() * atributos.size());
		return atributos.get(i);
	}

}
