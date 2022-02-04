package ejercicios1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class JuegoDelNumberTest {
	JuegoDelNumber juego;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		juego = new JuegoDelNumber();
		juego.numeroBuscado = 50;
	}

	@Test
	void testJuegoDelNumber() {
		fail("Not yet implemented");
	}

	@Test
	void testInicializar() {
		juego.numeroBuscado= -1;
		juego.inicializar();
		assertAll("Inicializar", 
				()-> assertEquals("Pendiente de empezar", juego.getResultado()),
				()-> assertEquals(0, juego.getJugada()),
				()-> assertTrue(0< juego.numeroBuscado && juego.numeroBuscado<=100, "rango entre 1 y 100")
				);
	}
	
	@Nested //es una de sus clases que tiene que usar el para organizar el test
	class jugadas{
		@Test
		void test_es_mayor() throws JuegoException {
			juego.jugada(51); //compruebo un numero mayor que el que tengo (50) 
			//hay que probar el mas cercano al numero que estamos probando
			assertAll("Jugada", 
					()->assertEquals("Mi número es menor.", juego.getResultado()), //tengo que ver que si meto el 51 me devuelve lo de mi numero es menor
					()-> assertEquals(1, juego.getJugada()) //tiene que haberse incrementado el número de jugadas
					);
			
		}
		@Test
		void test_es_menor() throws JuegoException {
			juego.jugada(49); 
			assertAll("Jugada", 
					()->assertEquals("Mi número es mayor.", juego.getResultado()),
					()-> assertEquals(1, juego.getJugada()) //el juego empieza todas las vecxes por eso no se incrementa a dos el numero de jugadas
					);
			
		}
		@Test
		void test_es_igual() throws JuegoException {
			juego.jugada(50); 
			assertAll("Jugada", 
					()->assertEquals("Bieeen!!! Acertaste.", juego.getResultado()),
					()-> assertEquals(1, juego.getJugada()) 
					);
			
		}
		@Test
		void test_acabado() throws JuegoException {
			for(int i=0; i<=9;i++) {
				juego.jugada(20); 
			}
			assertAll("Jugada", 
					()-> assertEquals("Upsss! Se acabaron los intentos, el número era el " + juego.numeroBuscado, juego.getResultado()),
					()-> assertEquals(10, juego.getJugada())
					);
		}
		
		//Prueba si se pasa con los intentos
		@Test
		void excepcionJugadas() throws JuegoException {
			
			for(int i=0; i<=9;i++) {
				juego.jugada(20); 
			}
			assertTrue(juego.getFinalizado());
			Assertions.assertThrows(JuegoException.class,()-> juego.jugada(20));
		}
		
		//Prueba si ya lo ha encontrado
		@Test
		void excepcionJugadas2() throws JuegoException {
			juego.jugada(50);

			assertTrue(juego.getFinalizado());
			assertThrows(JuegoException.class,()-> juego.jugada(50));
		}
		
		
		
		/*
		@ParameterizedTest
		@ValueSource(ints = {-1,101})
		void dentro(int number) {
		    assertTrue(juego.jugada(number));
		}
		*/
	}
	
	/*APUNTE*/
	//si quisiera probar el 101 y el -1, como me tiene que dar el mismo error
	//podria probarlo en una parametrizada

	@Test
	void testJugadaString() {
		fail("Not yet implemented");
	}

	@Test
	void testJugadaInt() {
		fail("Not yet implemented");
	}

	@Test
	void testGetResultado() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFinalizado() {
		fail("Not yet implemented");
	}

	@Test
	void testGetJugada() {
		fail("Not yet implemented");
	}

}
