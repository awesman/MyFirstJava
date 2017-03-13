package by.mantur.task02.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataParser {
	
	private static Logger logger = LogManager.getLogger(DataParser.class);
	
	private static final String CITY_TAXI_EXAMPLE = "^CityTaxi\\s\\d+,\\s\\d+,\\s\\d+,\\s\\w+$";
	private static final String AUTOBUS_EXAMPLE = "^Autobus\\s\\d+,\\s\\d+,\\s\\d+,\\s\\w+$";
	private static final String CARGO_TAXI_EXAMPLE = "^CargoTaxi\\s\\d+,\\s\\d+,\\s\\d+,\\s\\w+$";
	
	public static Map <String, List<int[]>> parseData (List<String> inputFile) {
		
		Pattern cityTaxiPattern = Pattern.compile(CITY_TAXI_EXAMPLE);
    	Pattern autobusPattern = Pattern.compile(AUTOBUS_EXAMPLE);
    	Pattern cargoPattern = Pattern.compile(CARGO_TAXI_EXAMPLE);
    	
    	List<int[]> cityTaxiList = new ArrayList<>();
    	List<int[]> autobusList = new ArrayList<>();
    	List<int[]> cargoList = new ArrayList<>();
    	Map<String, List<int[]>> carMap = new HashMap<>();
    	
    	for (String str : inputFile) {
    		
    		Matcher cityTaxiMatcher = cityTaxiPattern.matcher(str);
    		Matcher autobusMatcher = autobusPattern.matcher(str);
    		Matcher cargoMatcher = cargoPattern.matcher(str);
    		
    		if (cityTaxiMatcher.matches()) {
    			cityTaxiList.add(getInt(str));
    			
    		}else if (autobusMatcher.matches()) {
    			autobusList.add(getInt(str));
            } else if (cargoMatcher.matches()) {
            	cargoList.add(getInt(str));
            } else {
                logger.log(Level.WARN, "This is Wrong string - " + str);
            }
    		
    		carMap.put("CityTaxi", cityTaxiList);
    		carMap.put("Autobus", autobusList);
    		carMap.put("CargoTaxi", cargoList);
    	}
		return carMap;
		
	}
	
	private static int[] getInt(String string) {
        Scanner scanner = new Scanner(string);
        Pattern notNumbers = Pattern.compile("\\D+");
        List<Integer> list = new ArrayList<>();
        scanner.useDelimiter(notNumbers);
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        scanner.close();
        return result;
    }

}
