package by.mantur.port.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FileParser {
	
	private final static String SHIP_PATTERN = "(?i)^\\s*ship\\s*\\:\\s*\\d{1,3}\\s+\\d{1,3}\\s+\\d{1,3}\\s*$";
	private final static String NUMBER_PATTERN="\\D+";
    private static Logger logger = LogManager.getLogger(FileParser.class);

    public List<int[]> getParametrs(List<String> list) {
        List<int[]> result = new ArrayList<>();
        for (String string : list) {
            Pattern pattern = Pattern.compile(SHIP_PATTERN);
            Matcher matcher = pattern.matcher(string);
            if (matcher.matches()) {
                result.add(getNumber(string));
            } else {
                logger.log(Level.WARN, "Wrong line: "+ string);
            }
        }
        return result;
    }

    private int[] getNumber(String string) {
        Scanner scanner = new Scanner(string);
        Pattern notNumber = Pattern.compile(NUMBER_PATTERN);
        List<Integer> parametrs = new ArrayList<>();
        scanner.useDelimiter(notNumber);
        while (scanner.hasNextInt()) {
        	parametrs.add(scanner.nextInt());
        }
        int[] result = new int[parametrs.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = parametrs.get(i);
        }
        scanner.close();
        return result;
    }

}
