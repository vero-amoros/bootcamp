package Baraja;

import java.util.Stack;

import Baraja.CartaEspañola.Palos;

public class BarajaEspañola48 extends Baraja {

	public BarajaEspañola48() {
		baraja = new Stack<>();
		for (Palos palo : Palos.values())
			for (int i = 1; i <= 48 / 4; i++) {
				baraja.push(new CartaEspañola(palo, i));
			}
	}

}
