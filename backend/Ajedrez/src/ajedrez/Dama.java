package ajedrez;

public class Dama extends Pieza {

	public Dama(Color color) {
		super(color);
	}

	@Override
	protected boolean esValido(Movimiento mov, Tablero tab) throws JuegoException {
		if (mov == null || tab == null)
			throw new JuegoException("El tablero o el movimiento no pueden estar vacíos");
		return ((mov.esHorizontal() || mov.esVertical() || mov.esDiagonal()) && !tab.hayPiezasEntre(mov));
	}
}
