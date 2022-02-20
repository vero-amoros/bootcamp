package ajedrez;

public class Torre extends Pieza {

	public Torre(Color color) {
		super(color);
	}

	@Override
	protected boolean esValido(Movimiento mov, Tablero tab) throws JuegoException {
		if (mov == null || tab == null)
			throw new JuegoException("El tablero o el movimiento no pueden estar vacíos");
		return ((mov.esHorizontal() || mov.esVertical()) && !tab.hayPiezasEntre(mov));
	}

}
