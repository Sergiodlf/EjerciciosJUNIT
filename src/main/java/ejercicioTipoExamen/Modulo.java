package ejercicioTipoExamen;

import java.util.ArrayList;
import java.util.List;

public class Modulo {
	private String nombre;
	private List<Valoracion> listaEntregables = new ArrayList<Valoracion>();
	private List<Valoracion> listaExamenes = new ArrayList<Valoracion>();
	private static final int NUMERO_TOTAL_ENTREGABLES = 3;
	private static final int NUMERO_TOTAL_EXAMENES = 2;

	public Modulo(String nombre) {
		this.nombre = nombre;
	}

	public void anadirEntregable(Valoracion entregable) {
		listaEntregables.add(entregable);
	}

	public void anadirExamen(Valoracion examen) {
		listaExamenes.add(examen);
	}

	public double calcularNota() {
		if (listaEntregables.size() != NUMERO_TOTAL_ENTREGABLES)
			return 0;
		if (listaExamenes.size() != NUMERO_TOTAL_EXAMENES)
			return 0;

		for (Valoracion examen : listaExamenes)
			if (examen.getNota() < 4)
				return 0;

		double mediaEntregables = listaEntregables.stream().mapToDouble(Valoracion::getNota).average().orElse(0);
		double mediaExamenes = listaExamenes.stream().mapToDouble(Valoracion::getNota).average().orElse(0);

		return mediaEntregables * 0.6 + mediaExamenes * 0.4;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Valoracion> getListaEntregables() {
		return listaEntregables;
	}

	public List<Valoracion> getListaExamenes() {
		return listaExamenes;
	}
}
