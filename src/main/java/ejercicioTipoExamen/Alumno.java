package ejercicioTipoExamen;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String nombre;
	private String email;
	private List<Modulo> modulosMatriculados = new ArrayList<>();

	public Alumno(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
	}

	public void anadirModulo(Modulo modulo) {
		modulosMatriculados.add(modulo);
	}

	public boolean estaAlumnoAprobado() {
		if (email == null || !email.contains("@")) {
			throw new IllegalArgumentException("Email inválido");
		}

		if (modulosMatriculados.isEmpty()) {
			return false;
		}

		for (Modulo modulo : modulosMatriculados) {
			if (modulo.calcularNota() < 5) {
				return false;
			}
		}

		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public List<Modulo> getModulosMatriculados() {
		return modulosMatriculados;
	}
}
