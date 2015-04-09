package br.com.matheus.lancamento_aulas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import br.com.matheus.domain.HorarioEscolar;
import br.com.matheus.domain.Materia;
import br.com.matheus.service.LancamentoAulasService;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public App() {
	}
	
	
    public static void main( String[] args )
    {
    	    	
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
    	
    	HorarioEscolar horarioEscolar = new HorarioEscolar(historia, portugues, matematica, geografia, ciencias);
    	
    	
    }
    
    
    
    
}
