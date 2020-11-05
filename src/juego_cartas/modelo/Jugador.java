package juego_cartas.modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import juego_cartas.estrategia.Estrategia;
import juego_cartas.estrategia.Estrategia_Timbero;

public class Jugador {

	private String nombre;
	private Mazo mazoJugador;
	private Estrategia estrategia;

	public Jugador(String nombre) {
		this.nombre = nombre;
		mazoJugador = new Mazo();
		this.estrategia = new Estrategia_Timbero();
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	public int totalCartas() {
		return mazoJugador.size();
	}

	public Carta soltarCarta() {
		return this.mazoJugador.pop();
	}

	public void tomarCarta(Carta c) {
		this.mazoJugador.push(c);
	}

	public boolean tieneCartas() {
		return mazoJugador.size() > 0;
	}

	public String seleccionarAtributo() {
		return estrategia.implementarEstrategia(getCarta());
	}
	
	public Carta getCarta() {
		return mazoJugador.getUltimaCarta();
	}

	///// ------------------ metodos informativos ---------------////////////

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void mostrarCartas() {
		this.mazoJugador.mostrarCartas();
	}

	@Override
	public String toString() {
		return nombre;
	}

	/*
	 * Setear nombre de Jugador.
	 */
	public void crearNombre() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String nombre = "";
		while (nombre == "") {
			try {
				System.out.println("Ingrese Nombre Jugador:");
				nombre = new String(entrada.readLine());
			} catch (Exception exc) {
				nombre = "";
			}
		}
		this.setNombre(nombre);
	}

}
