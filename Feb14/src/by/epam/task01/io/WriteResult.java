package by.epam.task01.io;

import java.io.FileWriter;
import java.io.IOException;

public class WriteResult {
	
	public static void writeResult(String d){
		
		try(FileWriter writer = new FileWriter("data/resultsOutput.txt", true)){			
			writer.write(d);
			writer.flush();		
		}catch(IOException e){
			
		}
		
	}

}
