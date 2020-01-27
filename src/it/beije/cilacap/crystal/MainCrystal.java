package it.beije.cilacap.crystal;

import java.io.File; 
import java.util.ArrayList;
import java.util.List;

public class MainCrystal {
	
	public static final List<String> PATHS_TEST = new ArrayList<>();
//	
//	
//	
//	public static void main(String[] args) throws Exception{
//		
	
    static void RecursivePrint(File[] arr,int index,int level)  
     { 
         // terminate condition 
         if(index == arr.length) 
             return; 
           
         // tabs for internal levels 
         for (int i = 0; i < level; i++) 
             System.out.print("\t"); 
           
         // for files 
         if(arr[index].isFile()) {
             if (arr[index].getName().contains(".txt")) {
            	 PATHS_TEST.add(arr[index].getAbsolutePath()); 
            	 
            	 
             }
         }  
         // for sub-directories 
         else if(arr[index].isDirectory()) 
         { 
             System.out.println("[" + arr[index].getName() + "]"); 
               
             // recursion for sub-directories 
             RecursivePrint(arr[index].listFiles(), 0, level + 1); 
         } 
            
         // recursion for main directory 
         RecursivePrint(arr,++index, level); 
    } 
      
    // Driver Method 
    public static void main(String[] args) throws Exception 
    { 
        // Provide full path for directory(change accordingly)   
        String maindirpath = "crystal"; 
                  
        // File object 
        File maindir = new File(maindirpath); 
        
        
        if(maindir.exists() && maindir.isDirectory()) 
        { 
    		// array for files and sub-directories  
            // of directory pointed by maindir 
            File arr[] = maindir.listFiles(); 
              
            System.out.println("**********************************************"); 
            System.out.println("Files from main directory : " + maindir); 
            System.out.println("**********************************************"); 
              
            // Calling recursive method 
            RecursivePrint(arr,0,0);  
       } 
       for (int i = 0; i < PATHS_TEST.size(); i++) {
        	System.out.println(PATHS_TEST.get(i));
       }
       CrystalTestManager c = new CrystalTestManager();
		
		List<TestData> oldTests = c.readTestFromXML("crystal/crystaldata.xml");
		List<TestData> newTests = new ArrayList<>();
		
		for (int i = 0; i < PATHS_TEST.size(); i++) {
			System.out.println("\n");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Lettura file n_"+i+": directory |" + PATHS_TEST.get(i)+ "|\n");
			newTests.add(c.readTestFile(PATHS_TEST.get(i)));
			
		}
		
		c.writeTestToXML(newTests, oldTests, "crystal/crystaldata.xml");
	}
} 

