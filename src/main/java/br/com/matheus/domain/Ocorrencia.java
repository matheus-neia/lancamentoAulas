package br.com.matheus.domain;
import java.time.DayOfWeek;


public class Ocorrencia {

	private DayOfWeek diaSemana;
	private int quantidadeAula;
	
	public Ocorrencia(DayOfWeek diaSemana, int quantidadeAula) {
		this.diaSemana = diaSemana;
		this.quantidadeAula = quantidadeAula;
	}
	public DayOfWeek getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(DayOfWeek diaSemana) {
		this.diaSemana = diaSemana;
	}
	public int getQuantidadeAula() {
		return quantidadeAula;
	}
	public void setQuantidadeDeAula(int quantidadeAula) {
		this.quantidadeAula = quantidadeAula;
	}
	
	
	
}
