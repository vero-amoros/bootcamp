package Baraja;

import Baraja.Carta;
import Baraja.CartaEspañola;
import Baraja.CartaEspañola.Palos;

public class CartaEspañola extends Carta<CartaEspañola.Palos> {
	public static enum Palos {
		BASTOS, COPAS, ESPADAS, OROS
	}

	public CartaEspañola(Palos palo, int numero) {
		super(palo, numero);
	}

}
