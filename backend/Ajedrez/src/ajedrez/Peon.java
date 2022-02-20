package ajedrez;

public class Peon extends Pieza {
	public Peon(Color color) {
		super(color);
	}

	public boolean PuedeComer(Movimiento mov, Tablero tab) throws JuegoException {
		if (mov == null || tab == null)
			throw new JuegoException("El tablero o el movimiento no pueden estar vacíos");
		return (mov.esDiagonal() && mov.SaltoHorizontal() == 1 && tab.hayPieza(mov.getPosFinal())
				&& (tab.getEscaque(mov.getPosFinal()).getColor() != this.getColor()));
	}

	public boolean Avanza(Movimiento mov) {
		// si avanza uno en vertical / si es el primer movimiento del peon y avanza uno
		// o dos (caso blanco y caso negro)
		return ((mov.SaltoHorizontal() == 0 && mov.SaltoVertical() == 1)
				|| (mov.getPosInicial().getFila() == 2 && this.getColor() == Color.BLANCO // this.getColor().toString()
																							// ==
																							// Color.BLANCO.toString()
						&& (mov.SaltoVertical() == 1 || mov.SaltoVertical() == 2))
				|| (mov.getPosInicial().getFila() == 7 && this.getColor() == Color.NEGRO // this.getColor().toString()
																							// == Color.NEGRO.toString()
						&& (mov.SaltoVertical() == 1 || mov.SaltoVertical() == 2)));

	}

	@Override
	protected boolean esValido(Movimiento mov, Tablero tab) throws JuegoException {
		if (mov == null || tab == null)
			throw new JuegoException("El tablero o el movimiento no pueden estar vacíos");

		return ((this.Avanza(mov) && !tab.hayPieza(mov.getPosFinal())) || PuedeComer(mov, tab));
	}

	@Override
	public void mover(Movimiento mov, Tablero tab) throws JuegoException {
		if (!esValido(mov, tab))
			throw new JuegoException("El movimiento no es válido");

		tab.mover(mov);
	}

	public boolean Inicia(Posicion pos) {
		return true;
	}

	public boolean NecesitaPromocion(Posicion pos) {
		if (this.getColor() == Color.BLANCO && pos.getColumna() == 8) {
			return true;
		}
		if (this.getColor() == Color.NEGRO && pos.getColumna() == 1) {
			return true;
		}
		return false;
	}

//	protected void onPromocion(PromocionEventArgs) {
//		
//	}
}
