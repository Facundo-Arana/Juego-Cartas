package principal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import modelo.Carta;
import modelo.Jugador;
import modelo.Mazo;

public class VisorMazo {
	public static void cargarMazo(String jsonFile, Mazo mazo) {
		// URL url = getClass().getResource(jsonFile);
		File jsonInputFile = new File(jsonFile);
		InputStream is;

		try {
			// Creo el objeto JsonReader de Json.
			is = new FileInputStream(jsonInputFile);
			JsonReader reader = Json.createReader(is);
			// Obtenemos el JsonObject a partir del JsonReader.
			
			JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
			for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
				String nombreCarta = carta.getString("nombre");
				JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
				//String atributosStr = "";
				Carta cartaNueva = new Carta(nombreCarta);
				for (String nombreAtributo : atributos.keySet()) {
					
					cartaNueva.setAtributo(nombreAtributo, atributos.getInt(nombreAtributo));
					//atributosStr = atributosStr + nombreAtributo + ":" + atributos.getInt(nombreAtributo) + "; ";
				}					
				//System.out.println(nombreCarta + "\t\t\t" + atributosStr);
			
				mazo.setCarta(cartaNueva);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		String mazoPath = "./superheroes.json";
		Mazo mazo = new Mazo();
		VisorMazo.cargarMazo(mazoPath, mazo);
		mazo.mostrarCartas();
		Jugador j1 = new Jugador("Facundo");
		Jugador j2 = new Jugador("Gabriel");	
		mazo.repartir(j1, j2);
		
		Juego juego = new Juego();
		juego.jugar(j1, j2);
	}
}