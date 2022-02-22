package ajedrez;

public class Tablero {
	private Pieza[][] piezas = new Pieza[8][8];

	public Pieza getEscaque(int columna, int fila) throws JuegoException {
		Posicion pos = new Posicion(columna, fila);
		return getEscaque(pos);
	}

	public Pieza getEscaque(Posicion pos) throws JuegoException {
		if (pos == null)
			throw new IllegalArgumentException("No hay pieza o es null");
		if (!hayPieza(pos))
			throw new JuegoException("No hay pieza");

		return piezas[pos.getColumna() - 1][pos.getFila() - 1];
	}
//prueba
	public void setEscaque(int columna, int fila, Pieza pieza) throws JuegoException {
		if (pieza == null)
			throw new JuegoException("La pieza no puede ser null");

		piezas[columna - 1][fila - 1] = pieza;
	}

	public void setEscaque(Posicion pos, Pieza pieza) throws JuegoException {
		if (pieza == null || pos == null)
			throw new JuegoException("La pieza o la posición no pueden ser null");

		setEscaque(pos.getColumna(), pos.getFila(), pieza);
	}

	private boolean esValido(int i) {
		return (1 <= i && i <= 8);
	}

	public boolean hayPieza(int columna, int fila) throws JuegoException {
		if (!esValido(columna) || !esValido(fila))
			throw new IllegalArgumentException("La columna y la fila deben estar entre 1 y 8");
		return (piezas[columna][fila] != null);
	}

	public boolean hayPieza(Posicion pos) throws JuegoException {
		if (pos == null)
			throw new IllegalArgumentException("La posición es null");
		return hayPieza(pos.getColumna(), pos.getFila());

	}

	public void quitaPieza(int columna, int fila) throws JuegoException {
		if (!esValido(columna) || !esValido(fila))
			throw new IllegalArgumentException("La columna y la fila deben estar entre 1 y 8");
		if (!hayPieza(columna, fila))
			throw new JuegoException("La casilla ya estaba vacía");

		piezas[columna - 1][fila - 1] = null;
	}

	public void quitaPieza(Posicion pos) throws JuegoException {
		if (pos == null)
			throw new IllegalArgumentException("La posición es null");
		quitaPieza(pos.getColumna(), pos.getFila());
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
		if ((fila % 2) == (columna % 2)) {
			return Color.BLANCO;
		} else {
			return Color.NEGRO;
		}
	}

	public boolean hayPiezasEntre(Movimiento mov) throws JuegoException {
		if (mov == null)
			throw new JuegoException("El movimiento no puede ser null");
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

	public Tablero Clone() {
		Tablero copia = new Tablero();
		Pieza[][] copiaPiezas = new Pieza[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (piezas[i][j] != null)
					copiaPiezas[i][j] = piezas[i][j];
			}
		}
		copia.piezas = copiaPiezas;
		return copia;

	}
}
