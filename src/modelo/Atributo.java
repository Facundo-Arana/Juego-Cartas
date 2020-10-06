package modelo;

public class Atributo {

	private String nombre;
	private double valor;

	public Atributo() {
		this.nombre = "auxiliar";
		this.valor = valor;
	}

	public Atributo(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getValor() {
		return this.valor;
	}

	@Override
	public boolean equals(Object nombre) {
		return this.getNombre().equals(nombre);
	}

	@Override
	public String toString() {
		return "\n Atributo [nombre=" + nombre + " valor=" + valor + "]";
	}

}
