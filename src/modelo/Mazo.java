package modelo;

import java.util.ArrayList;

public class Mazo {

	private ArrayList<Carta> cartas;

	public Mazo() {
		cartas = new ArrayList<>();
	}

	public void setCarta(Carta carta) {
		if (this.verificarCarta(carta)) {
			cartas.add(carta);
		}
	}

	private boolean verificarCarta(Carta carta) {
		// TODO
		return true;
	}

	// repartir de forma aleatoria.
	public void repartir(Jugador j1, Jugador j2) {
		for (int i = 0; i < cartas.size(); i++) {
			int aux = cartas.size();
			int numeroRandom = (int) (aux * Math.random());
			
			if((i % 2) == 0)
				j1.push(cartas.get(numeroRandom));
			else
				j2.push(cartas.get(numeroRandom));
			
			cartas.remove(numeroRandom);
		}
	}


	// solo para chequear que funciona el metodo cargarCartas.
	public void mostrarCartas() {
		for (int i = 0; i < cartas.size(); i++) {
			System.out.println(cartas.get(i).getNombre());
		}
	}

}
