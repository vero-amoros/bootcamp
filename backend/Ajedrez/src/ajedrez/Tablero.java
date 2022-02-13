package ajedrez;

public class Tablero {
	private Pieza[][] piezas = new Pieza[8][8];

	public Pieza getEscaque(int columna, int fila) {
		return piezas[columna][fila];
	}

	public Pieza getEscaque(Posicion pos) {
		return piezas[pos.getColumna()][pos.getFila()];
	}

	public void setEscaque(int columna, int fila, Pieza pieza) throws JuegoException {
		if (pieza == null)
			throw new JuegoException("La pieza no puede ser null");

		if (hayPieza(columna, fila)) {
			if (getEscaque(columna, fila).getColor() != pieza.getColor()) {
				quitaPieza(columna, fila);
				piezas[columna][fila] = pieza;
			} else {
				throw new JuegoException("Ya hay una pieza del mismo color en esa posición");
			}
		} else {
			piezas[columna][fila] = pieza;
		}
	}

	public void setEscaque(Posicion pos, Pieza pieza) throws JuegoException {
		if (pieza == null)
			throw new JuegoException("La pieza no puede ser null");

		setEscaque(pos.getColumna(), pos.getFila(), pieza);
	}

	private boolean esValido(int i) {
		return (1 <= i && i <= 8);
	}

	public boolean hayPieza(int columna, int fila) throws JuegoException {
		return hayPieza(new Posicion(columna, fila));
	}

	public boolean hayPieza(Posicion pos) {
		return piezas[pos.getColumna()][pos.getFila()] != null;
	}

	public void quitaPieza(int columna, int fila) {
		if (esValido(columna) && esValido(fila))
			piezas[columna][fila] = null;
	}

	public void quitaPieza(Posicion pos) { // comprobar con esValido
		if (esValido(pos.getColumna()) && esValido(pos.getFila()))
			piezas[pos.getColumna()][pos.getFila()] = null;
	}

	public void mover(Movimiento mov) throws JuegoException {
		if (mov == null)
			throw new JuegoException("El movimiento no puede estar vacío");
		if (!hayPieza(mov.getPosInicial().getColumna(), mov.getPosInicial().getFila())) {
			throw new JuegoException("Debe haber una pieza en la posición inicial");
		}
		setEscaque(mov.getPosFinal(), getEscaque(mov.getPosInicial()));
		quitaPieza(mov.getPosInicial().getColumna(), mov.getPosInicial().getFila());

	}

	public Color colorEscaque(int columna, int fila) throws JuegoException {
		if (!esValido(columna) && !esValido(fila)) {
			throw new JuegoException("La columna y la fila deben estar entre 1 y 8");
		}
		return piezas[columna][fila].getColor();
	}

	public boolean hayPiezasEntre(Movimiento mov) throws JuegoException {
		if (!mov.esVertical() && !mov.esHorizontal() && !mov.esDiagonal()) {
			throw new JuegoException("El movimiento debe ser vertical, horizontal o diagonal.");
		}
		Posicion next = new Posicion(mov.getPosInicial().getColumna() + mov.deltaColumna(),
				mov.getPosInicial().getFila() + mov.deltaFila());
		do {
			if (next.equals(mov.getPosFinal())) {
				return false;
			}
			if (hayPieza(next.getColumna(), next.getFila())) {
				return true;
			}
			next = new Posicion(next.getColumna() + mov.deltaColumna(), next.getFila() + mov.deltaFila());

		} while (true);

	}

	public Object Clone() {
		return piezas.clone(); // clone o copy?
	}
}
