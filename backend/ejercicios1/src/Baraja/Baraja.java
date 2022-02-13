package Baraja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public abstract class Baraja {

	protected Stack<Carta> baraja;

	public void barajar() {
		Collections.shuffle(baraja);
	}

	/*public void pintar() {
		for (int i = 0; i < baraja.size(); i++) {
			System.out.println(baraja.get(i).getNumero() + " de " + baraja.get(i).getValor());
		}
	}*/
	
	public Stack<Carta> getBaraja(){
		return baraja;
	}

	public List<Carta> repartir() {
		int numero = 3;
		List<Carta> repartidas = new ArrayList<>();

		for (int i = 0; i < numero; i++) {
			repartidas.add(baraja.pop());
		}

		return repartidas;
	}
	

}
