package juego_cartas.estrategia;

import java.util.ArrayList;

import juego_cartas.modelo.Carta;

public class Estrategia_Ambicioso implements Estrategia {

	@Override
	public String implementarEstrategia(Carta carta) {
		ArrayList<String> atributos = carta.getNombresAtributos();
		String attrMayor = "";
		int valorMayor = -1;

		for (String atributo : atributos) {
			int aux = -1;
			aux = carta.getValorAtributo(atributo);
			if (aux > valorMayor) {
				attrMayor = atributo;
				valorMayor = aux;
			}
		}
		return attrMayor;
	}
}
