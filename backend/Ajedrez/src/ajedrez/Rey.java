package ajedrez;

public class Rey extends Pieza {

	public Rey(Color color) {
		super(color);
	}

	protected boolean esValido(Movimiento mov, Tablero tab) throws JuegoException {
		if (mov == null || tab == null)
			throw new JuegoException("El tablero o el movimiento no pueden estar vacíos");
		return ((mov.SaltoHorizontal() == 1 && mov.SaltoVertical() == 0)
				|| (mov.SaltoHorizontal() == 0 && mov.SaltoVertical() == 1)
				|| (mov.SaltoHorizontal() == 1 && mov.SaltoVertical() == 1));
	}

}
