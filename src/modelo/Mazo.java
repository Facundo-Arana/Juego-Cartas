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

	public ArrayList<Carta> getCartas() {
		return (ArrayList<Carta>) cartas;
	}

	
	/**
	 * @param jsonFile se recibe la ruta donde se ubica el archivo .json
	 * 
	 * @return un mazo con cartas VERIFICADAS (son todos iguales a la primera).
	 */
	public static Mazo cargarMazo(String jsonFile) {

		File jsonInputFile = new File(jsonFile);
		InputStream is;
		Mazo m = new Mazo();

		try {
			is = new FileInputStream(jsonInputFile);
			JsonReader reader = Json.createReader(is);

			JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");

			for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {

				String nombreCarta = carta.getString("nombre");
				JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");

				Carta cartaNueva = new Carta(nombreCarta);
				for (String nombreAtributo : atributos.keySet()) {
					cartaNueva.setAtributo(nombreAtributo, atributos.getInt(nombreAtributo));
				}
				// System.out.println(nombreCarta + "\t\t\t" + atributosStr);
				m.setCarta(cartaNueva);
			}

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return m;
	}

	/**
	 *  Verifica una carta antes de añadirla.
	 * 
	 * @param carta es la carta que se quiere añadir al Mazo.
	 */
	public void setCarta(Carta carta) {
		if (this.verificacionCarta(carta))
			cartas.add(carta);
	}

	
	/**
	 *  Compara una carta recibida con la primer carta del Mazo.
	 */
	private boolean verificacionCarta(Carta c) {
	
		// si no hay cartas en el Mazo se añade, esta carta fijara el pratron para las demas.
		if ((cartas.size() == 0))
			return true;
		
		
		if (cartas.get(0).equals(c))
			return true;
		
		return false;
	}

	// recibe una carta y la coloca en la posicion 0. // ( push() != setCarta() )
	public void push(Carta c) {
		cartas.add(0, c);
	}

	// devuelve la ultima carta y la borra.
	public Carta pop() {
		int ultimaCarta = cartas.size() - 1;
		Carta aux = cartas.get(ultimaCarta);
		cartas.remove(ultimaCarta);
		return aux;
	}

	// mostrar todo el mazo
	public void mostrarCartas() {
		for (int i = 0; i < cartas.size(); i++) {
			System.out.println(cartas.get(i).getNombre());
		}
	}

}
