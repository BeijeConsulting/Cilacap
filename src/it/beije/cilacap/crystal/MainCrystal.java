package it.beije.cilacap.crystal;

import java.io.File; 
import java.util.ArrayList;
import java.util.List;

public class MainCrystal {
	
	public static final List<String> PATHS_TEST = new ArrayList<>();
	public static final List<String> DIR_TEST = new ArrayList<>();
	
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
             // recursion for sub-directories 
             RecursivePrint(arr[index].listFiles(), 0, level + 1); 
             if (!arr[index].getName().contains("output")) {  
            	 DIR_TEST.add(arr[index].toString());
             }
         } 
            
         // recursion for main directory 
         RecursivePrint(arr,++index, level); 
    } 
      
    // Driver Method 
    public static void main(String[] args) throws Exception 
    { 
    	CrystalTestManager c = new CrystalTestManager();
    	List<TestData> testFromDB = c.getTestFromHDB();
//    	List<TestData> testFromDB = c.getTestFromDB();

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
       for (int x = 0; x < DIR_TEST.size(); x++) {
    	   System.out.println(DIR_TEST.get(x));
	       
	       
	       String pathFile="crystal\\outputsXML\\" + DIR_TEST.get(x).replace("\\", " ").split(" ")[1] ;
	       creaDir("crystal\\outputsXML\\");
	       creaDir(pathFile);
	       System.out.println("\n");
	        
	       List<TestData> newTests = new ArrayList<>();
	        
	        
	       for (int i = 0; i < PATHS_TEST.size(); i++) {
	    	   if (PATHS_TEST.get(i).contains(DIR_TEST.get(x))) {
		    	   System.out.println("\n");
		    	   System.out.println("-------------------------------------------------------------------");
		    	   System.out.println("Lettura file n_"+i+": directory |" + PATHS_TEST.get(i)+ "|\n");
		    	   newTests.add(c.readTestFile(PATHS_TEST.get(i)));
		    	   System.out.println("Lettura andata a buon fine\n");

	    	   }
	       }
	       //List<TestData> oldTests = c.readTestFromXML(DIR_TEST.get(x) + "\\output\\crystalOutput.xml");
	       c.writeTestToXML(newTests, pathFile + "\\crystalOutput.xml",true);
		   
	       for(TestData test : testFromDB) {
	    	   boolean esito = newTests.removeIf(a -> a.getIdComputer().contentEquals(test.getIdComputer()));	
	       }
	       boolean esito1 = newTests.removeIf(a -> a.getIdComputer().equals(null));
	       c.insertTestInHDB(newTests);
       }
	}
    
   
	private static void creaDir(String Dir)
    {
      
      boolean success = (new File(Dir)).mkdir();

      if (success)
      {
        System.out.println("Ho creato: " + Dir);
      }else{
        System.out.println("Directory già esistente: " + Dir);
      }
   
    }
} 

