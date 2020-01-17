package it.beije.cilacap.esercizi;
import java.time.*;
import java.time.format.*;
public class ProvaData {
	public static void main(String[] args) {

System.out.println(LocalTime.now());
System.out.println(LocalDate.now().plusMonths(1).plusWeeks(1).plusDays(5));

		System.out.println(LocalDate.of(2010, 12, 2));

		LocalDate data1= LocalDate.of(1998,Month.DECEMBER,27);
		LocalDate data4= LocalDate.of(2019,Month.MARCH,01);
		LocalDate data5= LocalDate.of(2019,Month.FEBRUARY,28);
		data5=data5.plusDays(1);
		System.out.println(data5);
		LocalDate data6= LocalDate.of(2020,Month.FEBRUARY,28);
		data5=data6.plusDays(1);
		System.out.println(data6);
		data4=data4.plusYears(1);
		System.out.println(data4);
		System.out.println(data1);
		data1=data1.plusDays(7);
		System.out.println(data1);
		data1=data1.plusMonths(0);
		System.out.println(data1);
		data1=data1.plusWeeks(2);
		System.out.println(data1);
		data1=data1.plusYears(21);
		System.out.println(data1);
		LocalTime tempo=LocalTime.of(10,15);
		LocalDateTime det=LocalDateTime.of(data1, tempo).minusDays(2).minusSeconds(5);
		LocalDateTime data2= LocalDateTime.of(1998,Month.DECEMBER,27, 10, 15);

		//PERIODO
		Period periodo=Period.ofYears(3).ofMonths(2).ofWeeks(3);
		System.out.println(data2.plus(periodo));
		System.out.println(data2.getDayOfWeek());

		//FORMATO DATA
		DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(data2.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(data2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

		DateTimeFormatter form = DateTimeFormatter.ofPattern("MM dd yyyy");

		try{
			LocalDate data3 = LocalDate.parse("39 06 2008", form);
		}catch(DateTimeParseException e) {
			System.out.println();
			System.out.println();
			LocalDate data3 = LocalDate.parse("09 06 2008", form);
			LocalTime time = LocalTime.parse("11:22");
			System.out.println(data3); 
			System.out.println(time);
		}

	}
}

