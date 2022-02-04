package ejercicios1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	class Divide {
		@Nested
		class OK{
			@Test
			void divide_enteros_OK(){
				assertEquals(1, Calculadora.dividir(3,2));
			}
			@Test
			void divide_por_0_enteros(){
				assertEquals(0, Calculadora.dividir(3,0));
			}
			
		}
	}

}
