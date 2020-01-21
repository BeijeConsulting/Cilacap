package it.beije.cilacap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class MetodiStringhe {
	public static String reverse(String s) {
		char[]parole=s.toCharArray();
		StringBuilder block=new StringBuilder();;
		for(int i=s.length()-1;i>=0;i--) {	
			block.append(parole[i]);
			}
		return block.toString();
	}
	
	public static void main(String[] args) {
		LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
		Period p = Period.ofDays(1).ofYears(2);
		d = d.minus(p);
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(f.format(d));
		
	}

}
