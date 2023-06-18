package multiThreadingExceptionOOPs_FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ReadWriteAppendFile {
	
	private static void createFileUsingFileClass() throws IOException
    {
          File file = new File("C:\\Users\\Lenovo\\Documents\\GIT\\FileHandling//fileHandling.txt");
  
          //Create the file
          file.createNewFile();
           
          //Write Content
          FileWriter writer = new FileWriter(file);
          writer.write("Hello, My Name is Rahul");
          writer.close();
    }
	
	public static List<String> readFileInList(String fileName) 
	  { 
	  
	    List<String> lines = Collections.emptyList(); 
	    try
	    { 
	      lines = 
	       Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
	    } 
	  
	    catch (IOException e) 
	    { 
	      e.printStackTrace(); 
	    } 
	    return lines; 
	  }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		createFileUsingFileClass();
		
		List l = readFileInList("C:\\Users\\Lenovo\\Documents\\GIT\\FileHandling//fileHandling.txt"); 
	    
		System.out.println("Original Content in the File is:\n");
	    Iterator<String> itr = l.iterator(); 
	    while (itr.hasNext()) 
	      System.out.println(itr.next());

	}

}
