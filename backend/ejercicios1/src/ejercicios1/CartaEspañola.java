package ejercicios1;

public class CartaEspa�ola extends Carta<CartaEspa�ola.Palos> {
	public static enum Palos {
		BASTOS, COPAS, ESPADAS, OROS
	}

	public CartaEspa�ola(Palos palo, int numero) {
		super(palo, numero);
	}

}
