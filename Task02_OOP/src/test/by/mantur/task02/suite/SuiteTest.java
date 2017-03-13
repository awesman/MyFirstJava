package test.by.mantur.task02.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.by.mantur.task02.comparator.ComparatorTest;
import test.by.mantur.task02.factory.TaxiStationFactoryTest;
import test.by.mantur.task02.io.DataReaderTest;
import test.by.mantur.task02.logic.StationActionTest;
import test.by.mantur.task02.parser.DataParserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	  StationActionTest.class,
	  ComparatorTest.class,
	  DataReaderTest.class,
	  DataParserTest.class,
	  TaxiStationFactoryTest.class
})

public class SuiteTest {

}
