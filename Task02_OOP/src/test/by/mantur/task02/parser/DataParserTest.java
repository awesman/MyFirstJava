package test.by.mantur.task02.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.mantur.task02.parser.DataParser;

public class DataParserTest {

	private List<String> list;
	private List<String> wrongList;

	@BeforeClass
	public static void initParser() {
		new DataParser();
	}

	@AfterClass
	public static void unInitParser() {
	}

	@Before
	public void initCorrectStringList() {
		list = Arrays.asList("CityTaxi 13600,400,5,Sedan",
				"Autobus 42100,1200,5,Suburban",
				"CargoTaxi 27000,1600,3,Medium");
	}

	@After
	public void unInitCorrectStringList() {
		list = null;
	}
	
	
	 @Test
	    public void parseData() {
	        Map<String, List<int[]>> resultMap = DataParser.parseData(list);
	        int[] cityTaxiExpected = new int[]{13600,400,5};
	        int[] autobusExpected = new int[]{42100,1200,5};
	        int[] cargoTaxiExpected = new int[]{27000, 1600, 3};
	        int[] cityTaxi = resultMap.get("CityTaxi").get(0);
	        int[] autobus = resultMap.get("Autobus").get(0);
	        int[] cargoTaxi = resultMap.get("CargoTaxi").get(0);
	        Assert.assertTrue("Actual parsing result not equals to expected.",
	                Arrays.equals(cityTaxiExpected, cityTaxi) &&
	                        Arrays.equals(autobusExpected, autobus) &&
	                        Arrays.equals(cargoTaxiExpected, cargoTaxi));
	    }

	@Before
	public void initWrongList() {
		wrongList = Arrays.asList("wrong string", "wrong string",
				"wrong string");
	}

	@After
	public void unInitIncorrectStringList() {
		wrongList = null;
	}

	@Test(expected = RuntimeException.class)
	public void getParsingResultMapFromIncorrectStringListTest() {
		DataParser.parseData(wrongList);
	}

}
