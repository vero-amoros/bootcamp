package ajedrez;

public class Movimiento {
	private Posicion posIni;
	private Posicion posFin;

	/**
	 * Transforma el string con el formato internacional, validando primero el
	 * mismo, y crea la posicion inicial y la final obteniendo los caracteres
	 * 
	 * @param posiciones string que contiene la posicion inicial y final de un
	 *                   movimiento
	 * @throws JuegoException
	 */
	public Movimiento(String posiciones) throws JuegoException {
		if (posiciones == null || posiciones.length() != 4)
			throw new JuegoException("La jugada est� vac�a o tiene el formato incorrecto");

		posIni = new Posicion(posiciones.charAt(0), posiciones.charAt(1));
		posFin = new Posicion(posiciones.charAt(2), posiciones.charAt(3));

		if (posFin.equals(posIni))
			throw new JuegoException("La posici�n incial tiene que ser distinata de la posici�n final");
	}

	/**
	 * 
	 * @return true si el movimiento es vertical
	 */
	public boolean esVertical() {
		return (posFin.getColumna() == posIni.getColumna());
	}

	/**
	 * 
	 * @return true si el movimiento es horizontal
	 */
	public boolean esHorizontal() {
		return (posFin.getFila() == posIni.getFila());
	}

	/**
	 * 
	 * @return true si el movimiento es diagonal
	 */
	public boolean esDiagonal() {
		return (SaltoVertical() == SaltoHorizontal());
	}

	/**
	 * 
	 * @return devuelve el n�mero de casillas que una pieza avanza en vertical (como
	 *         valor absoluto)
	 */
	public int SaltoVertical() {
		return Math.abs(posFin.getFila() - posIni.getFila());
	}

	/**
	 * 
	 * @return devuelve el n�mero de casillas que una pieza avanza en horizontal
	 *         (como valor absoluto)
	 */
	public int SaltoHorizontal() {
		return Math.abs(posFin.getColumna() - posIni.getColumna());
	}

	/**
	 * 
	 * @return devuelve un 1 si la direcci�n del movimiento en la fila es hacia
	 *         arriba, -1 si es hacia abajo y 0 si es igual
	 */
	public int deltaFila() {
		if (posFin.getFila() > posIni.getFila()) {
			return 1;
		} else if (posFin.getFila() < posIni.getFila()) {
			return -1;
		} else {
			return 0;
		}

	}

	/**
	 * 
	 * @return devuelve un 1 si la direcci�n del movimiento en la columna es hacia
	 *         la derecha, -1 si es hacia la izquierda y 0 si es igual
	 */
	public int deltaColumna() {
		if (posFin.getColumna() > posIni.getColumna()) {
			return 1;
		} else if (posFin.getColumna() < posIni.getColumna()) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @return devuelve la posici�n inicial de una posici�n
	 */
	public Posicion getPosInicial() {
		return posIni;
	}

	/**
	 * 
	 * @return devuelve la posici�n final de una posici�n
	 */
	public Posicion getPosFinal() {
		return posFin;
	}

}
