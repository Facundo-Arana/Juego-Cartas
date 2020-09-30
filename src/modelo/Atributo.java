package modelo;

public class Atributo {

	private String nombre;
	private double valor;
	
	
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
}
