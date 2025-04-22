package ejercicioTipoExamen;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String nombre;
	private String email;
	private List<Modulo> modulosMatriculados = new ArrayList<Modulo>();
	
	public Alumno(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Modulo> getModulosMatriculados() {
		return modulosMatriculados;
	}
	
	public void anadirModulo(Modulo modulo) {
		this.modulosMatriculados.add(modulo);
	}
	
	public boolean estaAlumnoAprobado() {
		return false;
	}
}
