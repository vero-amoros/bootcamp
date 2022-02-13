package Baraja;

import Baraja.Carta;
import Baraja.CartaEspaņola;
import Baraja.CartaEspaņola.Palos;

public class CartaEspaņola extends Carta<CartaEspaņola.Palos> {
	public static enum Palos {
		BASTOS, COPAS, ESPADAS, OROS
	}

	public CartaEspaņola(Palos palo, int numero) {
		super(palo, numero);
	}

}
