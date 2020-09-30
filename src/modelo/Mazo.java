package modelo;
import java.util.ArrayList;

public class Mazo {

	private ArrayList<Carta> cartas;
	
	
	public void setCarta(Carta carta) {
		if(this.verificarCarta(carta)) {
			cartas.add(carta);
		}
	}
	
	
	
	private boolean verificarCarta(Carta carta) {	
		return false;
	}
	
}
