package test.by.mantur.XML.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.by.mantur.XML.builder.CandiesDOMBuilderTest;
import test.by.mantur.XML.builder.CandiesSAXBuilderTest;
import test.by.mantur.XML.builder.CandiesStAXBuilderTest;
import test.by.mantur.XML.validator.FileValidatorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CandiesDOMBuilderTest.class, CandiesSAXBuilderTest.class, CandiesStAXBuilderTest.class,
        FileValidatorTest.class})
public class SuiteTest {
}
