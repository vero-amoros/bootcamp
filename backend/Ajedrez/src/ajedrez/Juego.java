package ajedrez;

public class Juego {
	private Tablero elTablero;
	private Color elTurno;
	private boolean partidaActiva = false;

	public void inicializar() throws JuegoException {
		elTablero = new Tablero();
		elTablero.setEscaque(0, 0, new Torre(Color.BLANCO));
		elTablero.setEscaque(1, 0, new Caballo(Color.BLANCO));
		elTablero.setEscaque(2, 0, new Alfil(Color.BLANCO));
		elTablero.setEscaque(3, 0, new Rey(Color.BLANCO));
		elTablero.setEscaque(4, 0, new Dama(Color.BLANCO));
		elTablero.setEscaque(5, 0, new Alfil(Color.BLANCO));
		elTablero.setEscaque(6, 0, new Caballo(Color.BLANCO));
		elTablero.setEscaque(7, 0, new Torre(Color.BLANCO));
		for (int i = 0; i < 8; i++) {
			elTablero.setEscaque(i, 0, new Peon(Color.BLANCO));
			elTablero.setEscaque(i, 7, new Peon(Color.NEGRO));
		}
		elTablero = new Tablero();
		elTablero.setEscaque(0, 7, new Torre(Color.NEGRO));
		elTablero.setEscaque(1, 7, new Caballo(Color.NEGRO));
		elTablero.setEscaque(2, 7, new Alfil(Color.NEGRO));
		elTablero.setEscaque(3, 7, new Rey(Color.NEGRO));
		elTablero.setEscaque(4, 7, new Dama(Color.NEGRO));
		elTablero.setEscaque(5, 7, new Alfil(Color.NEGRO));
		elTablero.setEscaque(6, 7, new Caballo(Color.NEGRO));
		elTablero.setEscaque(7, 7, new Torre(Color.NEGRO));

		partidaActiva = true;

	}

	public void Jugada(String jugada) throws JuegoException {
		Movimiento mov = new Movimiento(jugada);
		mover(mov);

	}

	private void mover(Movimiento mov) throws JuegoException {
		if (elTablero.hayPiezasEntre(mov))
			throw new JuegoException("Hay piezas entre la posición inicial y la final");
		elTablero.getEscaque(mov.getPosInicial()).mover(mov, elTablero);
		cambiaTurno();

	}

	private void cambiaTurno() {
		if (this.elTurno == Color.BLANCO) {
			this.elTurno = Color.NEGRO;
		} else {
			this.elTurno = Color.BLANCO;
		}
	}

	public Tablero getTablero() throws JuegoException {
		if (!partidaActiva)
			throw new JuegoException("La partida aún no ha empezado");
		return (Tablero) elTablero.Clone();
	}

	public Color getTurno() {
		return elTurno;
	}

	/*
	 * private promocionaPeon(Object o, PromocionEventArgs) {
	 * 
	 * }
	 */
}
