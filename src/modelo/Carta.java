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
	
	public Atributo getAtributo(String atributoYaSeleccionado) {
		Atributo atr = buscarAtributo(atributoYaSeleccionado);
		return atr;
	}

	public Atributo buscarAtributo(String nombre) {
		for(int i = 0; i < atributos.size(); i++) {
			if(atributos.get(i).getNombre().equals(nombre))
				return atributos.get(i);
		}
		return null; // no deberia ser null nunca.
	}
	
	
}
