package ejercicio2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeneradorIPTest {

	GeneradorIP generador = new GeneradorIP();

	@Test
	void testGenerarNumero() {

		for (int i = 0; i < 1000; i++) {
			int numero = generador.generarNumero(0, 254);
			assertTrue("Número fuera de rango: " + numero, numero >= 0 && numero <= 254);
		}
	}

	@Test
	void testGenerarIPV4() {
		for (int i = 0; i < 100; i++) {
			String ip = generador.generarIPV4();
			String[] partes = ip.split("\\.");

			assertEquals("La IP no tiene 4 partes", 4, partes.length);
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(partes[j]);
				assertTrue("Número fuera de rango: " + num, num >= 0 && num <= 254);
			}
			assertNotEquals("La IP empieza por 0", "0", partes[0]);
			assertNotEquals("La IP termina en 0", "0", partes[3]);
		}
	}

}
