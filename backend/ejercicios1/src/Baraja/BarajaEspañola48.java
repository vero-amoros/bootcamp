package Baraja;

import java.util.Stack;

import Baraja.CartaEspaņola.Palos;

public class BarajaEspaņola48 extends Baraja {

	public BarajaEspaņola48() {
		baraja = new Stack<>();
		for (Palos palo : Palos.values())
			for (int i = 1; i <= 48 / 4; i++) {
				baraja.push(new CartaEspaņola(palo, i));
			}
	}

}
