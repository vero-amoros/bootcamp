package ejercicios1;

public class CartaFrancesa extends Carta<CartaFrancesa.Palos> {

	public static enum Palos {
		CORAZONES, DIAMANTES, PICAS, TR?BOLES
	}

	public CartaFrancesa(Palos palo, int numero) {
		super(palo, numero);
	}

}
