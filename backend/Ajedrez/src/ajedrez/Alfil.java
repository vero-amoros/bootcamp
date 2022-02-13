package ajedrez;

public class Alfil extends Pieza {

	public Alfil(Color color) {
		super(color);
	}

	protected boolean esValido(Movimiento mov, Tablero tab) throws JuegoException {
		if (mov == null || tab == null)
			throw new JuegoException("El tablero o el movimiento no pueden estar vacíos");
		return (mov.esDiagonal());
	}

}
