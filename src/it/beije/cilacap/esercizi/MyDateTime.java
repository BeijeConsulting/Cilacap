package it.beije.cilacap.esercizi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class MyDateTime {

	public static void main(String[] args) throws InterruptedException {
		LocalDate ld = LocalDate.of(2020, 1, 17);
		System.out.println(ld.plusDays(1));
		
		LocalDateTime ldt = LocalDateTime.of(2020, 01, 17, 9, 51, 30);
		System.out.println(ldt);
		
		// periodo
		Period everyThreeWeeks = Period.ofYears(2);
		everyThreeWeeks = Period.ofMonths(5);
		System.out.println("Periodo: " + ldt.plus(everyThreeWeeks));
		
		// formatter
		DateTimeFormatter shortDateTime =
		DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println(shortDateTime.format(ldt));
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");
		System.out.println(ldt.format(f));
		
		/*LocalDateTime ldtn = LocalDateTime.now();
		int c = 0;
		while(c < 10) {
			System.out.println(LocalDateTime.now().format(f));
			c++;
			TimeUnit.SECONDS.sleep(1);
		}*/
		
	}
	
}
