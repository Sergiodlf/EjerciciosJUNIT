package ejercicioTipoExamen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ModuloTest {

	@Test
	void testModuloNotaCorrecta() {
		Modulo modulo = new Modulo("Entornos de desarrollo");
		for (int i = 0; i < 3; i++)
			modulo.anadirEntregable(new Valoracion("Valoración 1", 8));
		for (int i = 0; i < 2; i++)
			modulo.anadirExamen(new Valoracion("Valoración 2", 6));

		double nota = modulo.calcularNota();
		assertEquals(7.2, nota, 0.1);
	}

	@Test
	void testModuloFallaPorEntregablesIncompletos() {
		Modulo modulo = new Modulo("Programación");
		for (int i = 0; i < 2; i++)
			modulo.anadirEntregable(new Valoracion("Valoración 3", 8));
		for (int i = 0; i < 2; i++)
			modulo.anadirExamen(new Valoracion("Valoración 4", 6));

		assertEquals(0, modulo.calcularNota(), 0.01);
	}

	@Test
	void testModuloFallaPorExamenInferiorA4() {
		Modulo modulo = new Modulo("Sistemas informáticos");
		for (int i = 0; i < 3; i++)
			modulo.anadirEntregable(new Valoracion("Valoración 5", 7));
		modulo.anadirExamen(new Valoracion("Valoración 6", 3));
		modulo.anadirExamen(new Valoracion("Valoración 7", 6));

		assertEquals(0, modulo.calcularNota(), 0.01);
	}

	@Test
	void testModuloFallaPorFaltaDeExamenes() {
		Modulo modulo = new Modulo("Inglés");
		for (int i = 0; i < 3; i++)
			modulo.anadirEntregable(new Valoracion("Valoración 8", 9));
		modulo.anadirExamen(new Valoracion("Valoración 9", 6));

		assertEquals(0, modulo.calcularNota(), 0.01);
	}

}
