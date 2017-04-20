package test.by.mantur.information.parser;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.mantur.information.parser.MainParser;

public class MainParserTest {
	
	private MainParser parser;
    private String string;

    @Before
    public void init() {
        parser = new MainParser();
        string = "\tOne string.";
    }

    @After
    public void unInitParser() {
        parser = null;
        string =null;
    }

    @Test
    public void doChainTest() {
        String actual = parser.doChain(string).receiveText().trim();
        String expected = string.trim();
        Assert.assertEquals(expected,actual);
    }

}
