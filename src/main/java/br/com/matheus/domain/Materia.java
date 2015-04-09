package br.com.matheus.domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Materia {

	private long id;
	
	private String nome;
	
	private List<Ocorrencia> diasQueOcorre;

	public Materia(long id, String nome, List<Ocorrencia> diasQueOcorre) {
		super();
		this.id = id;
		this.nome = nome;
		this.diasQueOcorre = diasQueOcorre;
	}
	
	public Materia(long id, String nome) {
		this(id, nome, null);
	}
	
	public Materia(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ocorrencia> getDiasQueOcorre() {
		return diasQueOcorre;
	}

	public void addDiasQueOcorre(Ocorrencia ocorrencia) {
		if (diasQueOcorre == null) {
			diasQueOcorre = new ArrayList<>();
		}
		
		diasQueOcorre.add(ocorrencia);
	}
	
	public void addDiasQueOcorre(DayOfWeek diaSemana, int quantidadeAula) {
		Ocorrencia ocorrencia = new Ocorrencia(diaSemana, quantidadeAula);
		addDiasQueOcorre(ocorrencia);
	}
	
	public static Materia buildMateria (long id, String nome) {
		return new Materia(id, nome);
	}
	
	
	
}
