package by.epam.task01.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckData {

	private static final Pattern NUMBER =
			Pattern.compile(
					"(\\d)+||(\\d+(//.)\\d+)||((-)(\\d)+)|((-)(\\d+(//.)\\d+))");
	private static final String SPACES = "\\s+";
	private static final int AMOUNT = 6;//amount of numbers that we need for 3 points

	public static ArrayList<String> checkData(
			List<String> inputData) {
		ArrayList<String> triangleCoordinates = new ArrayList<>();
		Matcher matcher;
		String[] strings;
		
		for (String line : inputData) {
            int count = 0;
            strings = line.trim().split(SPACES);
            if (strings.length == AMOUNT) {
                for (String singleNumber : strings) {
                    matcher = NUMBER.matcher(singleNumber);
                    if (matcher.find()) {
                        count++;
                    }
                }
                if (count == AMOUNT) {
                	triangleCoordinates.add(line);
                }
            }
        }
        return triangleCoordinates;
    }

}
