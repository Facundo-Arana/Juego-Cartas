package juego_cartas.modelo;

public class Atributo {

	private String nombre;
	private int valor;

	public Atributo(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public int getValor() {
		return this.valor;
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public boolean equals(Object o) {
		try {
			Atributo otro = (Atributo) o;
			return this.getNombre().equals(otro.getNombre());

		} catch (Exception e) {
			return false;
		}
	}

}
