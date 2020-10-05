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

	public boolean equals(Object o) {
		try {
			Atributo otro = (Atributo) o;
			return this.getNombre().equals(otro.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public int comparar(Atributo otroAtributo) {		
//		if(this.valor > otroAtributo.getValor())
//			return 1;
//		else if(this.valor < otroAtributo.getValor())
//			return -1;
//		else
//			return 0;
//	}

}
