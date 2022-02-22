package ajedrez;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JuegoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
    public void testJuego() throws JuegoException {
        Juego juego = new Juego();
        juego.inicializar();
        juego.Jugada("D2D4");
        assertNotNull(juego.getTablero().getEscaque(4, 4));
        juego.Jugada("E7E5");
        juego.Jugada("D4D5");
        juego.Jugada("F8C5");
        juego.Jugada("C1E3");
        juego.Jugada("C5E3");
        juego.Jugada("F2E3");
        juego.Jugada("D7D6");
        juego.Jugada("G1F3");
        juego.Jugada("E5E4");
        juego.Jugada("F3D4");
        juego.Jugada("G8F6");
        juego.Jugada("H2H3");
        juego.Jugada("F6D5");
        juego.Jugada("D1D2");
        juego.Jugada("D8F6");
        juego.Jugada("G2G3");
        juego.Jugada("F6G5");
        juego.Jugada("H1G1");
        juego.Jugada("G5E3");
        juego.Jugada("D2E3");
        juego.Jugada("D5E3");
        juego.Jugada("B1A3");
        juego.Jugada("C7C5");
        juego.Jugada("D4B5");
        juego.Jugada("E8D7");
        assertNull(juego.getTablero().getEscaque(5, 8));
        assertTrue(juego.getTablero().getEscaque(4, 7).getClass().equals(new Rey(Color.NEGRO).getClass()));
        assertNotNull(juego.getTablero().getEscaque(2, 5));
        assertNotNull(juego.getTablero().getEscaque(3, 5));
    }

}
