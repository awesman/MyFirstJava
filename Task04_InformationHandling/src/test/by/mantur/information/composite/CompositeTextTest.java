package test.by.mantur.information.composite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.mantur.information.composite.CompositeText;
import by.mantur.information.composite.Symbol;
import by.mantur.information.composite.IPart;

import java.util.stream.Stream;

public class CompositeTextTest {
	
	private IPart testComponent;

    @Before
    public void init() {
        testComponent = new CompositeText();
        Stream.of("S", "t", "r", "i", "n", "g").map(Symbol::new).forEach(testComponent::add);
    }

    @After
    public void unInit() {
        testComponent = null;
    }

    @Test
    public void receiveTextTest() {
        String expected = "String";
        String actual = testComponent.receiveText().trim();
        Assert.assertEquals(expected, actual);
    }

}
