package ajedrez;

import java.util.Objects;

public class Posicion {
	private int laFila;
	private int laColumna;

	/**
	 * Recibe una posición (separada en enteros), valida que se corresponde a alguna
	 * posición en el tablero, en caso contrario lanza una excepción y almacena
	 * dicha posición
	 * 
	 * @param c la columna que debe ser una entero entre 1 y 8
	 * @param f la fila que debe ser una entero entre 1 y 8
	 * @throws JuegoException
	 */
	public Posicion(int c, int f) throws JuegoException {
		if (1 <= c && c <= 8) {
			this.laColumna = c;
		} else {
			throw new JuegoException("La columna debe estar entre el 1 y el 8");
		}
		if (1 <= f && f <= 8) {
			this.laFila = f;
		} else {
			throw new JuegoException("La fila debe estar entre el 1 y el 8");
		}

	}

	/**
	 * Recibe una posición en forma de dos caracteres que corresponden a la columna
	 * y a la fila, transforma dichos caracteres en los correspondientes enteros de
	 * esas posiciones en el tablero, lanza una excepción si la columna o la fila
	 * que le pasan no corresponde a ninguna posición del tablero
	 * 
	 * @param c Columna, es un caracter entre la A y la H
	 * @param f Fila, es un caracter entre el 1 y el 8
	 * @throws JuegoException
	 */
	public Posicion(char c, char f) throws JuegoException {
		if ('A' <= c && c <= 'H') {
			this.laColumna = c - 'A' + 1;
		} else if ('a' <= c && c <= 'h') {
			this.laColumna = c - 'a' + 1;
		} else {
			throw new JuegoException("La columna debe estar entra la A y la H");
		}
		if ('1' <= f && f <= '8') {
			this.laFila = f - '0';
		} else {
			throw new JuegoException("La fila debe estar entra el 1 y el 8");
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(laColumna, laFila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return laColumna == other.laColumna && laFila == other.laFila;
	}

	/**
	 * 
	 * @return laFila de una posición
	 */
	public int getFila() {
		return laFila;
	}

	/**
	 * 
	 * @return laColumna de una posición
	 */
	public int getColumna() {
		return laColumna;
	}

}
