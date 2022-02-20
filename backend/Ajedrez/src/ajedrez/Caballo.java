package ajedrez;

public class Caballo extends Pieza {

	public Caballo(Color color) {
		super(color);
	}

	@Override
	protected boolean esValido(Movimiento mov, Tablero tab) throws JuegoException {
		if (mov == null || tab == null)
			throw new JuegoException("El tablero o el movimiento no pueden estar vacíos");
		return ((mov.SaltoHorizontal() == 2 && mov.SaltoVertical() == 1)
				|| (mov.SaltoHorizontal() == 1 && mov.SaltoVertical() == 2));
	}

}
