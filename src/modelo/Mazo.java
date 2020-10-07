package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Mazo {

	private ArrayList<Carta> cartas;

	public Mazo() {
		cartas = new ArrayList<>();
	}

	/**
	 * Verifica una carta antes de añadirla a la lista.
	 */
	public void setCarta(Carta carta) {
		if (this.verificacionCarta(carta))
			push(carta);
	}

	/**
	 * Compara una carta recibida con la primer carta del Mazo.
	 */
	private boolean verificacionCarta(Carta c) {

		if ((this.size() == 0))
			return true;

		if (this.getPrimeraCarta().perteneAlMismoMazo(c))
			return true;

		return false;
	}

	/**
	 * Anañade una carta al PRINCIPIO de la lista. !!!!! (push != setCarta).
	 */
	public void push(Carta c) {
		cartas.add(0, c);
	}

	/**
	 * @return la ultima carta y la borra.
	 */
	public Carta pop() {
		int ultimaCarta = cartas.size() - 1;
		Carta aux = cartas.get(ultimaCarta);
		cartas.remove(ultimaCarta);
		return aux;
	}

	/**
	 * @return la primera carta.
	 */
	public Carta getPrimeraCarta() {
		return cartas.get(0);
	}

	/**
	 * @return la cantidad de cartas en el mazo.
	 */
	public int size() {
		return cartas.size();
	}

	/**
	 * Mezcla las cartas (idealmente antes de ser repartidas).
	 */
	public void mezclarCartas() {
		Collections.shuffle(cartas);
	}

	public void mostrarCartas() {
		for (Carta c : cartas)
			System.out.println(c);
	}

	/**
	 * @return un mazo con cartas verificadas (son todas iguales a la primera).
	 */
	public static Mazo cargarMazo(String jsonFile) {
		File jsonInputFile = new File(jsonFile);
		InputStream is;

		// se hace un nuevo mazo vacio.
		Mazo m = new Mazo();
		try {
			is = new FileInputStream(jsonInputFile);
			JsonReader reader = Json.createReader(is);
			JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
			for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
				String nombreCarta = carta.getString("nombre");
				JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");

				// se hace una nueva carta vacia.
				Carta cartaNueva = new Carta(nombreCarta);

				// se cargan los atributos.
				for (String nombreAtributo : atributos.keySet()) {
					cartaNueva.setAtributo(nombreAtributo, atributos.getInt(nombreAtributo));
				}

				// se añade al mazo (solo si pasa la verificacion).
				m.setCarta(cartaNueva);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// retorna el mazo ya cargado.
		return m;
	}
}
