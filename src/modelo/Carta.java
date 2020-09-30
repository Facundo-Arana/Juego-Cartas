package modelo;
import java.util.ArrayList;

public class Carta {

	private String nombre;
	private ArrayList<Atributo> atributos;

	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new ArrayList<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setAtributo(String nombre, double valor) {
		Atributo atr = new Atributo(nombre, valor);
		atributos.add(atr);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// @ return un atributo random.
	public Atributo getAtributoRandom() {
		int i = (int) (atributos.size() * Math.random());
		return this.getAtributo(i);
	}

	// @ return una copia del atributo que se va a comparar.
	private Atributo getAtributo(int i) {
		String nombre = atributos.get(i).getNombre();
		double valor = atributos.get(i).getValor();

		Atributo copia = new Atributo(nombre, valor);
		return copia;
	}

}
