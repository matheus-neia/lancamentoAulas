package br.com.matheus.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.matheus.domain.HorarioEscolar;
import br.com.matheus.domain.Materia;
import br.com.matheus.domain.Ocorrencia;

public class LancamentoAulasService {
	
    private static final Logger logger = LogManager.getLogger(LancamentoAulasService.class.getName());
    
    //TODO: Verificar como carregar a lista de feriados. carregar como @Resource?
    private List<LocalDate> feriados;
    
    public LancamentoAulasService(List<LocalDate> feriados) {
    	this.feriados = feriados;
    }

	public int getQuantidadeAula(String nomeMateria, HorarioEscolar horarioEscolar, LocalDate inicio, LocalDate fim) {
		//TODO: validar se a data de inicio é menor que a data fim
		int quantidadeAula = 0;
		Materia materia = horarioEscolar.getMateriaPorNome(nomeMateria);
		while(inicio.isBefore(fim) || inicio.isEqual(fim)) {
			for (Ocorrencia ocorrencia : materia.getDiasQueOcorre()) {
				if (ocorrencia.getDiaSemana().equals(inicio.getDayOfWeek())) {
					if (!isFeriado(inicio)) {
						quantidadeAula += ocorrencia.getQuantidadeAula();
						logger.debug("Encontrado Ocorrencia da materia {} para o dia {} - {} qtde aula {}", 
								nomeMateria, inicio.toString(), inicio.getDayOfWeek(), ocorrencia.getQuantidadeAula());
					} else {
						logger.debug("A Ocorrencia da materia {} para o dia {} - {} e um feriado", nomeMateria, inicio.toString(), inicio.getDayOfWeek());
					}
					continue;
				}
			}
			inicio = inicio.plusDays(1);
		}
		
		return quantidadeAula;
	}
	
	public Map<Materia, Integer> getQuantidadeAulas() {
		return null;
	}
	
	private boolean isFeriado(LocalDate data) {
		for (LocalDate feriado : feriados) {
			if (feriado.isEqual(data)) {
				return true;
			}
		}
		return false;
	}
}
