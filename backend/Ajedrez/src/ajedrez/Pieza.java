package ajedrez;

public abstract class Pieza {
	private Color elColor;

	public Pieza(Color color) {
		this.elColor = color;
	}

	public void mover(Movimiento mov, Tablero tab) throws JuegoException {
		if (!esValido(mov, tab))
			throw new JuegoException("El movimiento no es válido para esa pieza");
		tab.mover(mov);
	}

	protected abstract boolean esValido(Movimiento mov, Tablero tab) throws JuegoException;

	public Color getColor() {
		return this.elColor;
	}

}
