package modelo;

public class Atributo implements Comparable<Atributo> {

	private String nombre;
	private int valor;

	public Atributo(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getValor() {
		return this.valor;
	}

	@Override
	public boolean equals(Object o) {
		try {
			Atributo otro = (Atributo) o;
			if (this.getNombre().equals(otro.getNombre()))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public String toString() {
		return   nombre + " " + valor;//"\n Atributo [nombre=" + nombre + " valor=" + valor + "]";
	}

	@Override
	public int compareTo(Atributo otro) {		
		return this.getValor() - otro.getValor();
	}

}
