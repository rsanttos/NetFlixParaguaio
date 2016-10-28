package br.com.ufrn.bti.desktop.netflixparaguaio.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class MainTeste {

	public static void main(String[] args) throws ParseException {

		String str = new String("01234");
		System.out.println(str.substring(0, 2));
		
		
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		Date date = (Date)formatter.parse("07/08/1988");
		System.out.println(idade(date));
	}
	public static int idade(final Date aniversario) {
	    final LocalDate dataAtual = LocalDate.now();
	    Instant instant = aniversario.toInstant();
	    ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
	    LocalDate date = zdt.toLocalDate();
	    final Period periodo = Period.between(date, dataAtual);
	    return periodo.getYears();    
	}
}
