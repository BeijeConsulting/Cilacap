package it.beije.cilacap.myCrystal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.xml.internal.ws.util.StringUtils;

public class ConversionToXML {


	public static void main(String[] args) {
		String s = "------------------------------------------------------------------------------\r\n" + 
				"CrystalDiskMark 7.0.0 x64 (C) 2007-2019 hiyohiyo Crystal Dew World: https://crystalmark.info/\r\n" + 
				"------------------------------------------------------------------------------\r\n" + 
				"* MB/s = 1,000,000 bytes/s [SATA/600 = 600,000,000 bytes/s]\r\n" + 
				"* KB = 1000 bytes, KiB = 1024 bytes\r\n" + 
				"\r\n" + 
				"[Read]\r\nSequential 1MiB (Q=  8, T= 1):   101.514 MB/s [     96.8 IOPS] < 81970.32 us>\r\n" + 
				"Sequential 1MiB (Q=  1, T= 1):    96.677 MB/s [     92.2 IOPS] < 10822.04 us>\r\n" + 
				"    Random 4KiB (Q= 32, T=16):     0.851 MB/s [    207.8 IOPS] <635043.04 us>\r\n" + 
				"    Random 4KiB (Q=  1, T= 1):     0.408 MB/s [     99.6 IOPS] < 10013.33 us>\r\n" + 
				"\r\n" + 
				"[Write]\r\n" + 
				"Sequential 1MiB (Q=  8, T= 1):    88.490 MB/s [     84.4 IOPS] < 93668.80 us>\r\n" + 
				"Sequential 1MiB (Q=  1, T= 1):    84.944 MB/s [     81.0 IOPS] < 12326.34 us>\r\n" + 
				"    Random 4KiB (Q= 32, T=16):     0.691 MB/s [    168.7 IOPS] <708764.71 us>\r\n" + 
				"    Random 4KiB (Q=  1, T= 1):     0.664 MB/s [    162.1 IOPS] <  6152.49 us>\r\n" + 
				"\r\n" + 
				"Profile: Default\r\n" + 
				"   Test: 1 GiB (x5) [Interval: 5 sec] <DefaultAffinity=DISABLED>\r\n" + 
				"   Date: 2020/01/03 11:44:51\r\n" + 
				"     OS: Windows 10  [10.0 Build 18363] (x64)\r\n" + 
				"\r\n" + 
				"";

		s = s.replace("\r\n", "");
	}

	// Test
	private static String[] getTest(String s) {
		Pattern versione = Pattern.compile("CrystalDiskMark\\s(.*?)\\((.*)Test:\\s(.*?)\\s\\((.*?)x(.*?)\\)\\s\\[(.*?):\\s(.*?)\\](.*?)Date:\\s(.*?)O(.*?)\\:\\s(.*?)\\s\\[");
		Matcher m = versione.matcher(s);
		String [] test =  new String[6];
		while(m.find()) {
			test[0] = m.group(1);
			test[1] = m.group(11);
			test[2] = m.group(3);
			test[3] = m.group(5);
			test[4] = m.group(5);
			test[5] = m.group(9);
		}
		return test;
	}

	// String for Read
	private static String getStringForRead(String s) {
		Pattern read = Pattern.compile("\\[Read\\](.*?)\\[Write\\]");
		Matcher m = read.matcher(s);
		String s2 = "";
		while(m.find()) {
			s2 = m.group(1);
		}
		return s2;
	}

	// String for Write
	private static String getStringForWrite(String s) {
		Pattern read = Pattern.compile("\\[Write\\](.*?)Profile");
		Matcher m = read.matcher(s);
		String s2 = "";
		while(m.find()) {
			s2 = m.group(1);
		}
		return s2;
	}

	// MBs read
	private static String [] getMBsRead(String s) {
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
	private static String [] getMBsWrite(String s) {
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
	private static String [] getQWrite(String s) {
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
	private static String [] getQRead(String s) {
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
	private static String [] getTWrite(String s) {
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
	private static String [] getTRead(String s) {
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
	private static String[] getIOPSWrite(String s) {
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
	private static String[] getIOPSRead(String s) {
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
	private static String[] getUsWrite(String s) {
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
	private static String[] getUsRead(String s) {
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
