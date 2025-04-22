package ejercicioTipoExamen;

import java.util.ArrayList;
import java.util.List;

public class Modulo {
	private String nombre;
	private List<Valoracion> listaEntregables = new ArrayList<Valoracion>();
	private List<Valoracion> listaExamenes = new ArrayList<Valoracion>();

	private final static int NUMERO_TOTAL_ENTREGABLES = 3;
	private final static int NUMERO_TOTAL_EXAMENES = 2;

	public Modulo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void anadirEntregable(Valoracion entregable) {
		this.listaEntregables.add(entregable);
	}

	public void anadirExamen(Valoracion examen) {
		this.listaExamenes.add(examen);
	}

	public List<Valoracion> getListaEntregables() {
		return listaEntregables;
	}

	public List<Valoracion> getListaExamenes() {
		return listaExamenes;
	}

	public double calcularNota() {
		return 0;
	}
}
