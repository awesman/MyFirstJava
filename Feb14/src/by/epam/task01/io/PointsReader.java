package by.epam.task01.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointsReader {
	
	public static List<String> pointsInput(String path){
		
		final Logger logger = LogManager.getLogger(PointsReader.class);
		
		List<String> pointsList=new ArrayList<>();
		
		try {
			pointsList=Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			logger.log(Level.INFO, "Data reading successfull!");
		} catch (IOException e) {
			logger.log(Level.ERROR, "IOException", e);
		}
		return pointsList;	
	}
}


