package test.by.mantur.information.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.by.mantur.information.composite.CompositeTextTest;
import test.by.mantur.information.interpreter.InterpreterTest;
import test.by.mantur.information.operator.TextOperatorTest;
import test.by.mantur.information.parser.MainParserTest;
import test.by.mantur.information.reader.DataReaderTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CompositeTextTest.class, InterpreterTest.class,
        TextOperatorTest.class, MainParserTest.class, DataReaderTest.class})

public class SuiteTest {

}
