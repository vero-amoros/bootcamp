package ajedrez;

public class Alfil extends Pieza {

	public Alfil(Color color) {
		super(color);
	}

	@Override
	protected boolean esValido(Movimiento mov, Tablero tab) throws JuegoException {
		if (mov == null || tab == null)
			throw new JuegoException("El tablero o el movimiento no pueden estar vac�os");
		return (mov.esDiagonal() && !tab.hayPiezasEntre(mov));
	}

}
