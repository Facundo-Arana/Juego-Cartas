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
	
	public void cargarMazo(String jsonFile) { //eliminado static
		
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
			
				setCarta(cartaNueva);//eliminado mazo.
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}//fin metodo cargarMazo
	
	
	public void setCarta(Carta carta) {
		if (this.verificarCarta(carta)) {
			cartas.add(carta);
		}
	}

	//Copia de ArrayList para usar en repartir cartas	
	public ArrayList<Carta> copiaMazo(){//metodo publico para que ande... F
		return (ArrayList<Carta>) cartas.clone();
	}
	
	private boolean verificarCarta(Carta carta) {
		// TODO
		return true;
	}
	


	// solo para chequear que funciona el metodo cargarCartas.
	public void mostrarCartas() {
		for (int i = 0; i < cartas.size(); i++) {
			System.out.println(cartas.get(i).getNombre());
		}
	}
	
	

}
