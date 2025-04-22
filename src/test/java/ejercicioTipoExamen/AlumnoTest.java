package ejercicioTipoExamen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlumnoTest {

	@Test
	void testAlumnoAprobadoConModulosValidos() {
		Alumno alumno = new Alumno("Sergio", "sergio4vientos@cuatrovientos.org");

		Modulo modulo1 = new Modulo("Entornos de desarrollo");
		for (int i = 0; i < 3; i++)
			modulo1.anadirEntregable(new Valoracion("Valoración 1", 8));
		for (int i = 0; i < 2; i++)
			modulo1.anadirExamen(new Valoracion("Valoración 2", 6));

		Modulo modulo2 = new Modulo("Programación");
		for (int i = 0; i < 3; i++)
			modulo2.anadirEntregable(new Valoracion("Valoración 3", 7));
		for (int i = 0; i < 2; i++)
			modulo2.anadirExamen(new Valoracion("Valoración 4", 5));

		alumno.anadirModulo(modulo1);
		alumno.anadirModulo(modulo2);

		assertTrue(alumno.estaAlumnoAprobado());
	}

	@Test
	void testAlumnoNoAprobadoPorEmailInvalido() {
		Alumno alumno = new Alumno("Iker", "ikercuatrovientos.org");
		assertThrows(IllegalArgumentException.class, () -> alumno.estaAlumnoAprobado());
	}

	@Test
	void testAlumnoNoAprobadoSinModulos() {
		Alumno alumno = new Alumno("Julen", "julen@cuatrovientos.org");
		assertFalse(alumno.estaAlumnoAprobado());
	}

	@Test
	void testAlumnoNoAprobadoPorNotaDeModulo() {
		Alumno alumno = new Alumno("Luis", "luis@cuatrovientos.org");

		Modulo modulo = new Modulo("Sistemas Informáticos");
		for (int i = 0; i < 3; i++)
			modulo.anadirEntregable(new Valoracion("Valoración 5", 6));
		modulo.anadirExamen(new Valoracion("Valoración 6", 3));
		modulo.anadirExamen(new Valoracion("Valoración 7", 6));

		alumno.anadirModulo(modulo);
		assertFalse(alumno.estaAlumnoAprobado());
	}

}
