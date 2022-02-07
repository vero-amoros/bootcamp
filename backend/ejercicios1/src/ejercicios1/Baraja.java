package ejercicios1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public abstract class Baraja {

	protected Stack<Carta> baraja;

	public void barajar() {
		Collections.shuffle(baraja);
	}

	public void pintar() {
		for (int i = 0; i < baraja.size(); i++) {
			System.out.println(baraja.get(i).getNumero() + " " + baraja.get(i).getValor());
		}
	}

	public ArrayList<Carta> repartir() {
		int numero = 7;
		ArrayList<Carta> repartidas = new ArrayList<>();

		for (int i = 0; i < numero; i++) {
			repartidas.add(baraja.pop());
		}

		return repartidas;
	}

}
