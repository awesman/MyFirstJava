package test.by.mantur.XML.builder;

import org.junit.Assert;
import org.junit.Test;

import by.mantur.XML.builder.CandiesSAXBuilder;
import by.mantur.XML.builder.Director;
import by.mantur.XML.entity.Candy;

import java.util.List;

public class CandiesSAXBuilderTest {
	
	private static final String TEST_FILE_PATH = "data/candies.xml";
    private static final int EXPECTED_SIZE = 16;

    @Test
    public void testSAXParser() {
        List<Candy> candies = Director.readXML(new CandiesSAXBuilder(), TEST_FILE_PATH);
        Assert.assertEquals(EXPECTED_SIZE, candies.size());
    }

}
