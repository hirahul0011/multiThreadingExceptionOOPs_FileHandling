package multiThreadingExceptionOOPs_FileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
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
	
	static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            String newContent = oldContent.replaceAll(oldString, newString);
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		createFileUsingFileClass();
		
		System.out.println("Original Content in the File is:\n");
		List l = readFileInList("C:\\Users\\Lenovo\\Documents\\GIT\\FileHandling//fileHandling.txt");	    
		
	    Iterator<String> itr = l.iterator(); 
	    while (itr.hasNext()) 
	      System.out.println(itr.next());
	    
	    modifyFile("C:\\Users\\Lenovo\\Documents\\GIT\\FileHandling\\fileHandling.txt", "Hello", "Hi");
        System.out.println("\nContent in the File changed.\n");
        
        System.out.println("After the changes the Content in the File is:\n");
		List l0 = readFileInList("C:\\Users\\Lenovo\\Documents\\GIT\\FileHandling//fileHandling.txt");	    
		
	    Iterator<String> itr0 = l0.iterator(); 
	    while (itr0.hasNext()) 
	      System.out.println(itr0.next());
	    
	    List<String> lines = Arrays.asList("","Hope you are doing good!", "Thank you!");
	       Files.write(Paths.get("C:\\Users\\Lenovo\\Documents\\GIT\\FileHandling\\fileHandling.txt"),
	                    lines,
	                    StandardCharsets.UTF_8,
	                    StandardOpenOption.CREATE,
	                    StandardOpenOption.APPEND);
	    
	    System.out.println("\nSome content is now appended in the File.\n");
	    
	    System.out.println("After the appending the Content in the File is:\n");
		List l1 = readFileInList("C:\\Users\\Lenovo\\Documents\\GIT\\FileHandling//fileHandling.txt");	    
		
	    Iterator<String> itr1 = l1.iterator(); 
	    while (itr1.hasNext()) 
	      System.out.println(itr1.next());

	}

}
