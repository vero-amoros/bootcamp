package Baraja;

import Baraja.Carta;
import Baraja.CartaEspa�ola;
import Baraja.CartaEspa�ola.Palos;

public class CartaEspa�ola extends Carta<CartaEspa�ola.Palos> {
	public static enum Palos {
		BASTOS, COPAS, ESPADAS, OROS
	}

	public CartaEspa�ola(Palos palo, int numero) {
		super(palo, numero);
	}

}
