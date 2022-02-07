package ejercicios1;

public class Carta {
	private Palos palo;
	private int numero;

	public Carta(Palos palo, int numero) {
		this.palo = palo;
		this.numero = numero;
	}

	public Palos getValor() {
		return this.palo;
	}

	public int getNumero() {
		return this.numero;
	}

}
