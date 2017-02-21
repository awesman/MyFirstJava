package by.epam.task01.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckData {

	private static final Pattern NUMBER_PATTERN =
			Pattern.compile(
					"(\\d)+||(\\d+(//.)\\d+)||((-)(\\d)+)|((-)(\\d+(//.)\\d+))");
	private static final String SPLIT_BY_SPACES = "\\s+";
	private static final int LINE_SIZE = 6;

	public static ArrayList<String> checkData(
			List<String> inputData) {
		ArrayList<String> triangleCoordinates = new ArrayList<>();
		Matcher matcher;
		String[] strings;
		
		for (String line : inputData) {
            int count = 0;
            strings = line.trim().split(SPLIT_BY_SPACES);
            if (strings.length == LINE_SIZE) {
                for (String singleNumber : strings) {
                    matcher = NUMBER_PATTERN.matcher(singleNumber);
                    if (matcher.find()) {
                        count++;
                    }
                }
                if (count == LINE_SIZE) {
                	triangleCoordinates.add(line);
                }
            }
        }
        return triangleCoordinates;
    }

}
