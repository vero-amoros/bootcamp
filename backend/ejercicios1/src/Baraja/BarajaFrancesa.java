package Baraja;

import java.util.Stack;

import Baraja.CartaFrancesa.Palos;

public class BarajaFrancesa extends Baraja {
	public BarajaFrancesa() {
		baraja = new Stack<>();
		for (Palos palo : Palos.values())
			for (int i = 1; i <= 52 / 4; i++) {
				baraja.push(new CartaFrancesa(palo, i));
			}
	}
}
