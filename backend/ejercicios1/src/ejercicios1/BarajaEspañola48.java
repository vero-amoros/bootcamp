package ejercicios1;

import java.util.Stack;

public class BarajaEspaņola48 extends Baraja {

	public BarajaEspaņola48() {
		iniciar();
	}

	public void iniciar() {
		baraja = new Stack<>();
		for (Palos palo : Palos.values())
			for (int i = 1; i <= 48 / 4; i++) {
				baraja.push(new Carta(palo, i));
			}
	}

}
