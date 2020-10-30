package juego_cartas.estrategia;

import juego_cartas.modelo.Carta;

public class Estrategia_Obstinado extends Estrategia {

	private String atributo;

	@Override
	public String implementarEstrategia(Carta carta) {
		if(this.atributo==null){
			this.atributo=carta.getAtributoRandom();
		}	
		return atributo;
	}
	
/**
 * 
 * 
 * */

//	public Estrategia_Obstinado(String atributo) {
//		this.atributo = atributo;
//	}
//	
//	public boolean atributo_valido(Carta carta) {
//		if(carta.existeAtributo(atributo)) {//metodo nuevo
//			return true;
//		}else {
//			this.atributo = carta.getAtributoRandom();//si no lo es, cambia el atributo por uno random pero valido
//			return false;
//		}
//	}
//	
//	@Override
//	public String implementarEstrategia(Carta carta) {
//		this.atributo_valido(carta);
//		return atributo;
//	}
	
}
