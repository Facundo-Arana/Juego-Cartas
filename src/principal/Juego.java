package principal;

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

import modelo.Carta;
import modelo.Jugador;
import modelo.Mazo;



public class Juego {
	
	/**
	 * crear j1
	 * crear j2
	 * 
	 * crear mazo
	 * cargar mazo
	 * 
	 * repartiCartas(j1, j2) // se encarga el mazo de repartirse.
	 * 
	 * juego.jugar(j1, j2);
	 * 
	 * termina lo que se realiza en el main.
	 * //arranca el turno.
	 * 
	 * jugador 1 elije el atributo a comparar. //String del nombre del atributo.
	 * 
	 * j1 y j2 sueltan sus cartas(pop).
	 * 
	 * de cada carta se obtiene el atributo y se comparan.
	 * 
	 */
	
	public static void main(String[] args) {
		String mazoPath = "./superheroes.json";
		Mazo mazo = new Mazo();
		mazo.cargarMazo(mazoPath);
		mazo.mostrarCartas();
		Jugador j1 = new Jugador("Facundo");
		Jugador j2 = new Jugador("Gabriel");	
		//mazo.repartir(j1, j2);
		
		Juego juego = new Juego();
		juego.jugar(j1, j2,mazo);
	}
	
	public void jugar(Jugador j1, Jugador j2,Mazo mazo) {
	//TODO a terminar
	}

	// repartir de forma aleatoria.
		public void repartir(Jugador j1, Jugador j2, Mazo mazo) {
			ArrayList<Carta> aux = mazo.copiaMazo();//COPIA de las cartas
			Collections.shuffle(aux);//Mezclo ANTES de repartir... quisas exista mazo jugador...
			for (int i = aux.size()-1; i >= 0 ; i--) {
			
				if((i % 2) == 0)
					j1.push(aux.get(i));
				else
					j2.push(aux.get(i));
				
				aux.remove(i);
			}
		}
	
		
		
		
		
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
		}//fin metodo cargarMazo
}
