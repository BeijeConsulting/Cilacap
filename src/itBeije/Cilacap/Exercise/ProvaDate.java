package itBeije.Cilacap.Exercise;

import java.time.LocalDate;
import java.time.Month;

public class ProvaDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate data = LocalDate.of(2020, Month.JANUARY, 20);
		System.out.println(data.getDayOfWeek()); 
		System.out.println(data.getMonth()); 
		System.out.println(data.getYear()); 
		System.out.println(data.getDayOfYear()); 
	}

}
