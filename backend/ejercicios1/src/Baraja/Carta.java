package Baraja;

import Baraja.ValorCarta;

public abstract class Carta<E> {
	protected int numero;
	private E palo;

	public Carta(E palo, int numero) {
		this.palo = palo;
		this.numero = numero;
	}
	
	public E getValor() {
		return this.palo;
	}

	public ValorCarta getNumero() {
		return ValorCarta.toEnum(numero);
		
	}

}
