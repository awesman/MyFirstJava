package test.by.mantur.information.interpreter;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.mantur.information.composite.IPart;
import by.mantur.information.interpreter.Context;
import by.mantur.information.interpreter.Interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterpreterTest {
	
	private Interpreter testInterpreter;
    private Context testContext;
    private List<String> testRpnList;

    @Before
    public void init() {
        testInterpreter = new Interpreter();
        testContext = new Context(0, 0);
        testRpnList = new ArrayList<>();
        testRpnList.addAll(Arrays.asList("2", "2", "2", "*", "+"));
    }

    @After
    public void unInit() {
        testRpnList = null;
        testContext = null;
        testInterpreter = null;
    }

    @Test
    public void executeInterpretationTest() {
        IPart result = testInterpreter.executeInterpretation(testRpnList, testContext);
        String expected = "6.0";
        String actual = result.receiveText().trim();
        Assert.assertEquals(expected, actual);
    }

}
