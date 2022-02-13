package ajedrez;

public class Peon extends Pieza {
	public Peon(Color color) {
		super(color);
	}

	public boolean PuedeComer(Movimiento mov, Tablero tab) throws JuegoException {
		if (mov == null || tab == null)
			throw new JuegoException("El tablero o el movimiento no pueden estar vacíos");
		return (mov.esDiagonal() && mov.SaltoHorizontal() == 1 && tab.hayPieza(mov.getPosFinal())
				&& (tab.getEscaque(mov.getPosFinal()).getColor() != tab.getEscaque(mov.getPosInicial()).getColor()));
	}

	public boolean Avanza(Movimiento mov) {
		return false;
	}

	public boolean Inicia(Posicion pos) {
		return false;
	}

	public boolean NecesitaPromocion(Posicion pos) {
		return false;
	}

	protected boolean esValido(Movimiento mov, Tablero tab) {
		return false;
	}

	public void Mover(Movimiento mov, Tablero tab) {

	}

//	protected void onPromocion(PromocionEventArgs) {
//		
//	}
}
