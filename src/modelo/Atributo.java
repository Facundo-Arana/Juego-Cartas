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
	
	// no aseguramos en otro lugar que sean atributos con el mismo nombre.
	public int comparar(Atributo otroAtributo) {		
		if(this.valor > otroAtributo.getValor())
			return 1;
		else if(this.valor < otroAtributo.getValor())
			return -1;
		else
			return 0;
	}
	
	
}
