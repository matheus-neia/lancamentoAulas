package br.com.matheus.service;

import static org.junit.Assert.fail;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.matheus.domain.HorarioEscolar;
import br.com.matheus.domain.Materia;

public class LancamentoAulasServiceTest {
	
	private static HorarioEscolar horarioEscolar;
	private static List<LocalDate> feriados;

	@BeforeClass
	public static void setUpBeforeClass() {
		Materia historia = new Materia(1, "Historia");
    	Materia portugues = new Materia(2, "Portugues");
    	Materia matematica = new Materia(3, "Matematica");
    	Materia geografia = new Materia(4, "Geografia");
    	Materia ciencias = new Materia(5, "Ciencias");
    	
    	
    	historia.addDiasQueOcorre(DayOfWeek.MONDAY, 1);
    	
    	portugues.addDiasQueOcorre(DayOfWeek.MONDAY, 2);
    	portugues.addDiasQueOcorre(DayOfWeek.TUESDAY, 1);
    	portugues.addDiasQueOcorre(DayOfWeek.WEDNESDAY, 1);
    	portugues.addDiasQueOcorre(DayOfWeek.THURSDAY, 2);
    	portugues.addDiasQueOcorre(DayOfWeek.FRIDAY, 2);
    	
    	matematica.addDiasQueOcorre(DayOfWeek.MONDAY, 1);
    	matematica.addDiasQueOcorre(DayOfWeek.TUESDAY, 2);
    	matematica.addDiasQueOcorre(DayOfWeek.WEDNESDAY, 2);
    	matematica.addDiasQueOcorre(DayOfWeek.FRIDAY, 2);
    	
    	geografia.addDiasQueOcorre(DayOfWeek.TUESDAY, 2);
    	
    	ciencias.addDiasQueOcorre(DayOfWeek.WEDNESDAY, 2);
    	
    	horarioEscolar = new HorarioEscolar(historia, portugues, matematica, geografia, ciencias);
    	
    	
    	//carregar feriados
    	feriados = new ArrayList<>();
    	feriados.add(LocalDate.of(2015, Month.FEBRUARY, 17)); //carnaval
    	feriados.add(LocalDate.of(2015, Month.APRIL, 3)); //pascoa
    	feriados.add(LocalDate.of(2015, Month.APRIL, 21)); //tiradentes
	}
	
	@Test
	public void testGetQuantidadeAulaCienciasEmMarco() {
    	LancamentoAulasService lancamentoAulas = new LancamentoAulasService(feriados);
    	int qtdAulas = lancamentoAulas.getQuantidadeAula("Ciencias", horarioEscolar, LocalDate.of(2015, Month.MARCH, 1), LocalDate.of(2015, Month.MARCH, 31));
    	
    	Assert.assertEquals("Quantidade de Aulas inesperada", 8, qtdAulas);
	}
	
	@Test
	public void testGetQuantidadeAulaHistoriaEmAbril() {
		LancamentoAulasService lancamentoAulas = new LancamentoAulasService(feriados);
    	int qtdAulas = lancamentoAulas.getQuantidadeAula("Historia", horarioEscolar, LocalDate.of(2015, Month.APRIL, 1), LocalDate.of(2015, Month.APRIL, 30));
    	
    	Assert.assertEquals("Quantidade de Aulas inesperada", 4, qtdAulas);
	}
	
	@Test
	public void testGetQuantidadeAulaPortuguesEmAbril() {
		LancamentoAulasService lancamentoAulas = new LancamentoAulasService(feriados);
    	int qtdAulas = lancamentoAulas.getQuantidadeAula("Portugues", horarioEscolar, LocalDate.of(2015, Month.APRIL, 1), LocalDate.of(2015, Month.APRIL, 30));
    	
    	Assert.assertEquals("Quantidade de Aulas inesperada", 32, qtdAulas);
	}
	
	@Test
	public void testGetQuantidadeAulaMatematicaEmAbril() {
		LancamentoAulasService lancamentoAulas = new LancamentoAulasService(feriados);
    	int qtdAulas = lancamentoAulas.getQuantidadeAula("Matematica", horarioEscolar, LocalDate.of(2015, Month.APRIL, 1), LocalDate.of(2015, Month.APRIL, 30));
    	
    	Assert.assertEquals("Quantidade de Aulas inesperada", 26, qtdAulas);
	}
	
	@Test
	public void testGetQuantidadeAulaPortuguesFevereiroAteAbril() {
		LancamentoAulasService lancamentoAulas = new LancamentoAulasService(feriados);
    	int qtdAulas = lancamentoAulas.getQuantidadeAula("Portugues", horarioEscolar, LocalDate.of(2015, Month.FEBRUARY, 1), LocalDate.of(2015, Month.APRIL, 30));
    	
    	Assert.assertEquals("Quantidade de Aulas inesperada", 98, qtdAulas);
	}
	
	@Test
	public void testGetQuantidadeAulaCienciasFevereiroAteAbril() {
		LancamentoAulasService lancamentoAulas = new LancamentoAulasService(feriados);
    	int qtdAulas = lancamentoAulas.getQuantidadeAula("Ciencias", horarioEscolar, LocalDate.of(2015, Month.FEBRUARY, 1), LocalDate.of(2015, Month.APRIL, 30));
    	
    	Assert.assertEquals("Quantidade de Aulas inesperada", 26, qtdAulas);
	}

	@Test
	@Ignore
	public void testGetQuantidadeAulas() {
		fail("Not yet implemented");
	}

}
