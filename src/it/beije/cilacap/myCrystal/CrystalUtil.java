package it.beije.cilacap.myCrystal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrystalUtil {
	
	// Test
	public static String[] getTest(String s) {
		Pattern versione = Pattern.compile("CrystalDiskMark\\s(.*?)\\((.*)Test:\\s(.*?)\\s\\((.*?)x(.*?)\\)\\s\\[(.*?):\\s(.*?)\\](.*?)Date:\\s(.*?)O(.*?)\\:\\s(.*?)\\s\\[");
		Matcher m = versione.matcher(s);
		String [] test =  new String[6];
		while(m.find()) {
			test[0] = m.group(1);
			test[1] = m.group(11);
			test[2] = m.group(3);
			test[3] = m.group(5);
			test[4] = m.group(7);
			test[5] = m.group(9);
		}
		
		return test;
	}

	// String for Read
	public static String getStringForRead(String s) {
		Pattern read = Pattern.compile("\\[Read\\](.*?)\\[Write\\]");
		Matcher m = read.matcher(s);
		String s2 = "";
		while(m.find()) {
			s2 = m.group(1);
		}
		return s2;
	}

	// String for Write
	public static String getStringForWrite(String s) {
		Pattern read = Pattern.compile("\\[Write\\](.*?)Profile");
		Matcher m = read.matcher(s);
		String s2 = "";
		while(m.find()) {
			s2 = m.group(1);
		}
		return s2;
	}

	// MBs read
	public static String [] getMBsRead(String s) {
		String s2 = getStringForRead(s);
		Pattern read = Pattern.compile("\\):[\\s]+(.*?)\\sMB/s\\s\\[");
		Matcher m = read.matcher(s2);
		String [] sequential = new String[4];
		int i = 0;
		while(m.find()) {
			sequential[i] = m.group(1);
			i++;
		}
		return sequential;
	}

	// MBs Write
	public static String [] getMBsWrite(String s) {
		String s2 = getStringForWrite(s);
		Pattern write = Pattern.compile("\\):[\\s]+(.*?)\\sMB/s\\s\\[");
		Matcher m = write.matcher(s2);
		String [] sequential = new String[4];
		int i = 0;
		while(m.find()) {
			sequential[i] = m.group(1);
			i++;
		}
		return sequential;
	}

	// Q write
	public static String [] getQWrite(String s) {
		String s2 = getStringForWrite(s);
		Pattern write = Pattern.compile("\\s\\(Q=[\\s]*(.*?),\\sT");
		Matcher m = write.matcher(s2);
		String [] attribute = new String[4];
		int i = 0;
		while(m.find()) {
			attribute[i] = m.group(1);
			i++;
		}
		return attribute;
	}

	// Q Read
	public static String [] getQRead(String s) {
		String s2 = getStringForRead(s);
		Pattern read = Pattern.compile("\\s\\(Q=[\\s]*(.*?),\\sT");
		Matcher m = read.matcher(s2);
		String [] attribute = new String[4];
		int i = 0;
		while(m.find()) {
			attribute[i] = m.group(1);
			i++;
		}
		return attribute;
	}

	// T Write
	public static String [] getTWrite(String s) {
		String s2 = getStringForWrite(s);
		Pattern write = Pattern.compile("\\sT=[\\s]*(.*?)\\)");
		Matcher m = write.matcher(s2);
		String [] attribute = new String[4];
		int i = 0;
		while(m.find()) {
			attribute[i] = m.group(1);
			i++;
		}
		return attribute;
	}

	// T Read
	public static String [] getTRead(String s) {
		String s2 = getStringForWrite(s);
		Pattern read = Pattern.compile("\\sT=[\\s]*(.*?)\\)");
		Matcher m = read.matcher(s2);
		String [] attribute = new String[4];
		int i = 0;
		while(m.find()) {
			attribute[i] = m.group(1);
			i++;
		}
		return attribute;
	}

	// IOPS Write
	public static String[] getIOPSWrite(String s) {
		String s2 = getStringForWrite(s);
		Pattern write = Pattern.compile("\\[[\\s]*(.*?)IOPS\\]");
		Matcher m = write.matcher(s2);
		String [] iops = new String[4];
		int i = 0;
		while(m.find()) {
			iops[i] = m.group(1);
			i++;
		}
		return iops;
	}

	// IOPS Read
	public static String[] getIOPSRead(String s) {
		String s2 = getStringForRead(s);
		Pattern read = Pattern.compile("\\[[\\s]*(.*?)IOPS\\]");
		Matcher m = read.matcher(s2);
		String [] iops = new String[4];
		int i = 0;
		while(m.find()) {
			iops[i] = m.group(1);
			i++;
		}
		return iops;
	}

	// us Write
	public static String[] getUsWrite(String s) {
		String s2 = getStringForWrite(s);
		Pattern write = Pattern.compile("<[\\s]*(.*?)[\\s]*us");
		Matcher m = write.matcher(s2);
		String [] us = new String[4];
		int i = 0;
		while(m.find()) {
			us[i] = m.group(1);
			i++;
		}
		return us;
	}

	// us Read
	public static String[] getUsRead(String s) {
		String s2 = getStringForRead(s);
		Pattern read = Pattern.compile("<[\\s]*(.*?)[\\s]*us");
		Matcher m = read.matcher(s2);
		String [] us = new String[4];
		int i = 0;
		while(m.find()) {
			us[i] = m.group(1);
			i++;
		}
		return us;
	}
}
