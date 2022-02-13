package Baraja;

import java.util.Stack;

import Baraja.CartaEspa�ola.Palos;

public class BarajaEspa�ola48 extends Baraja {

	public BarajaEspa�ola48() {
		baraja = new Stack<>();
		for (Palos palo : Palos.values())
			for (int i = 1; i <= 48 / 4; i++) {
				baraja.push(new CartaEspa�ola(palo, i));
			}
	}

}
