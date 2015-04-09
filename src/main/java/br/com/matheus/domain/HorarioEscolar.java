package br.com.matheus.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorarioEscolar {

	private List<Materia> materias = new ArrayList<>();
	
	public HorarioEscolar() {}
	
	public HorarioEscolar(Materia... materia) {
		Collections.addAll(materias, materia);
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
	public void addMateria(Materia materia) {
		materias.add(materia);
	}
	
	public Materia getMateriaPorNome(String nomeMateria) {
		for (Materia materia : materias) {
			if (materia.getNome().equalsIgnoreCase(nomeMateria)) {
				return materia;
			}
		}
		
		return null;
	}
	
	
	
}
