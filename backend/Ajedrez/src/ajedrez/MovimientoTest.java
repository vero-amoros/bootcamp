package ajedrez;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MovimientoTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_excepcion_misma_posicion() throws JuegoException {
		Exception exception = assertThrows(Exception.class, () -> {
			new Movimiento("a1a1");
		});
		assertTrue(exception.getMessage().contains("La posición incial tiene que ser distinata de la posición final"));
	}

	@Test
	public void test_excepcion_formato_incorrecto() throws JuegoException {
		Exception exception = assertThrows(Exception.class, () -> {
			new Movimiento("a1a15");
		});
		assertTrue(exception.getMessage().contains("La jugada está vacía o tiene el formato incorrecto"));
	}

	@Test
	public void testGetPosIni() throws JuegoException {
		Movimiento movimiento = new Movimiento("C2b1");// 32 21 c2b1
		Movimiento movcero = new Movimiento("a1b1");
		Movimiento movocho = new Movimiento("h8a1");

		assertEquals(movimiento.getPosInicial().getColumna(), 3);
		assertEquals(movimiento.getPosInicial().getFila(), 2);
		assertEquals(movimiento.getPosFinal().getColumna(), 2);
		assertEquals(movimiento.getPosFinal().getFila(), 1);
		assertEquals(movcero.getPosInicial().getColumna(), 1);
		assertEquals(movcero.getPosInicial().getFila(), 1);
		assertEquals(movocho.getPosInicial().getColumna(), 8);
	}

	@Test
	public void enVertical() throws JuegoException {
		Movimiento vertical = new Movimiento("C1C6");
		assertTrue(vertical.esVertical());
	}

	@Test
	public void enHorizontal() throws JuegoException {
		Movimiento horizon = new Movimiento("b2f2");
		assertTrue(horizon.esHorizontal());
	}

	@Test
	public void enDiagonal() throws JuegoException {
		Movimiento diagonal = new Movimiento("a2d5");
		assertTrue(diagonal.esDiagonal());
	}

	@Test
	public void noDiagonal() throws JuegoException {
		Movimiento vertical = new Movimiento("C1C6");
		assertFalse(vertical.esDiagonal());
	}

	@Test
	public void daSaltoVertical() throws JuegoException {
		Movimiento vertical = new Movimiento("C1C6");
		assertEquals(vertical.SaltoVertical(), 5);
	}

	@Test
	public void daSaltoHorizontal() throws JuegoException {
		Movimiento horizontal = new Movimiento("A3g3");
		assertEquals(horizontal.SaltoHorizontal(), 6);
	}

	@Test
	public void deltaHorizontal() throws JuegoException {
		Movimiento horizontal = new Movimiento("a1f1");
		assertEquals(horizontal.deltaColumna(), 1);
	}

	@Test
	public void deltaVertical() throws JuegoException {
		Movimiento vertical = new Movimiento("c1c6");
		assertEquals(vertical.deltaFila(), 1);
	}

	@Test
	public void deltaVerticalNegro() throws JuegoException {
		Movimiento vertical = new Movimiento("c7c3");
		assertEquals(vertical.deltaFila(), -1);
	}

	@Test
	public void deltaHorizontalNegro() throws JuegoException {
		Movimiento horizontal = new Movimiento("g6b6");
		assertEquals(horizontal.deltaColumna(), -1);
	}

	@Test
	public void deltaHorizontalFila() throws JuegoException {
		Movimiento horizontal = new Movimiento("g6b6");
		assertEquals(horizontal.deltaFila(), 0);
	}

	@Test
	public void deltaVerticalColumna() throws JuegoException {
		Movimiento vertical = new Movimiento("c7c3");
		assertEquals(vertical.deltaColumna(), 0);
	}

}
