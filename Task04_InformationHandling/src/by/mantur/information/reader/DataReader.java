package by.mantur.information.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DataReader {
	
	private static Logger logger =LogManager.getLogger(DataReader.class);

	public List<String> readFile(String filePath) {
	       List<String> list;
	        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
	            list = br.lines().collect(Collectors.toList());
	        } catch (IOException | InvalidPathException e) {
	            logger.log(Level.FATAL, e);
	            throw new RuntimeException(e);
	        }
	        return list;
	    }
	}


