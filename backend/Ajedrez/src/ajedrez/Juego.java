package ajedrez;

public class Juego {
	private Tablero elTablero;
	private Color elTurno;
	private boolean partidaActiva = false;

	public void inicializar() throws JuegoException {
		elTablero = new Tablero();
		elTablero.setEscaque(1, 1, new Torre(Color.BLANCO));
		elTablero.setEscaque(2, 1, new Caballo(Color.BLANCO));
		elTablero.setEscaque(3, 1, new Alfil(Color.BLANCO));
		elTablero.setEscaque(4, 1, new Rey(Color.BLANCO));
		elTablero.setEscaque(5, 1, new Dama(Color.BLANCO));
		elTablero.setEscaque(6, 1, new Alfil(Color.BLANCO));
		elTablero.setEscaque(7, 1, new Caballo(Color.BLANCO));
		elTablero.setEscaque(8, 1, new Torre(Color.BLANCO));
		for (int i = 1; i <= 8; i++) {
			elTablero.setEscaque(i, 2, new Peon(Color.BLANCO));
			elTablero.setEscaque(i, 7, new Peon(Color.NEGRO));
		}
		elTablero.setEscaque(1, 8, new Torre(Color.NEGRO));
		elTablero.setEscaque(2, 8, new Caballo(Color.NEGRO));
		elTablero.setEscaque(3, 8, new Alfil(Color.NEGRO));
		elTablero.setEscaque(4, 8, new Rey(Color.NEGRO));
		elTablero.setEscaque(5, 8, new Dama(Color.NEGRO));
		elTablero.setEscaque(6, 8, new Alfil(Color.NEGRO));
		elTablero.setEscaque(7, 8, new Caballo(Color.NEGRO));
		elTablero.setEscaque(8, 8, new Torre(Color.NEGRO));

		partidaActiva = true;
		elTurno = Color.BLANCO;

	}

	public void Jugada(String jugada) throws JuegoException {
		if (!partidaActiva)
			throw new JuegoException("La partida aún no ha empezado");
		Movimiento mov = new Movimiento(jugada);
		mover(mov);

	}

	private void mover(Movimiento mov) throws JuegoException {
		Pieza laPieza = elTablero.getEscaque(mov.getPosInicial());

		if (laPieza.getColor() != elTurno)
			throw new JuegoException("No puedes mover las piezas del oponente");

		if (elTablero.hayPieza(mov.getPosFinal().getColumna(), mov.getPosFinal().getFila())) {
			if (elTablero.getEscaque(mov.getPosFinal().getColumna(), mov.getPosFinal().getFila()).getColor() != laPieza
					.getColor()) {
				if (!laPieza.esValido(mov, elTablero))
					throw new JuegoException("El movimiento que intentas hacer no es válido para esa pieza");
				// hay pieza en la posFin, me la como y me muevo
				elTablero.quitaPieza(mov.getPosFinal().getColumna(), mov.getPosFinal().getFila());
				laPieza.mover(mov, elTablero);

			} else { // la pieza de la PosFin es del mismo color que la pieza que se está moviendo
				throw new JuegoException("Ya hay una pieza tuya en esa posición");
			}
		} else { // no hay pieza en la posFin, solo me muevo
			laPieza.mover(mov, elTablero);
		}

		cambiaTurno();

	}

	private void cambiaTurno() {
		if (elTurno == Color.BLANCO) {
			elTurno = Color.NEGRO;
		} else {
			elTurno = Color.BLANCO;
		}
	}

	public Tablero getTablero() throws JuegoException {
		if (!partidaActiva)
			throw new JuegoException("La partida aún no ha empezado");
		return elTablero.Clone();
	}

	public Color getTurno() throws JuegoException {
		if (!partidaActiva)
			throw new JuegoException("La partida aún no ha empezado");
		return elTurno;
	}

	/*
	 * private promocionaPeon(Object o, PromocionEventArgs) {
	 * 
	 * }
	 */
}
