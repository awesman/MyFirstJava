package test.by.mantur.information.operator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.mantur.information.composite.CompositeText;
import by.mantur.information.composite.Symbol;
import by.mantur.information.composite.TextPart;
import by.mantur.information.composite.IPart;
import by.mantur.information.interpreter.Context;
import by.mantur.information.interpreter.Interpreter;
import by.mantur.information.operator.TextOperator;

import java.util.Arrays;
import java.util.List;


public class TextOperatorTest {
	
	private static TextOperator operator;
    private IPart testText;
    private IPart sortText;
    private IPart removeText;
    private IPart mathExpression;
    private Interpreter interpreter;
    private Context context;

    @BeforeClass
    public static void initOperator() {
        operator = new TextOperator();
    }

    @AfterClass
    public static void unInitOperator() {
        operator = null;
    }

    @Before
    public void initMathExpressions() {
        mathExpression = new CompositeText();
        CompositeText expression = new CompositeText();
        expression.setLevel(TextPart.MATH);
        Arrays.stream("2+2*2".split("")).map(Symbol::new).forEach(expression::add);
        mathExpression.add(new Symbol("A"));
        mathExpression.add(expression);
        mathExpression.add(new Symbol("A"));
        interpreter = new Interpreter();
        context = new Context(0, 0);
    }

    @After
    public void unInitMathExpression() {
        mathExpression = null;
        interpreter = null;
        context = null;
    }

    @Test
    public void calculateTextTest() {
        operator.calculateText(mathExpression, interpreter, context);
        String expected = "A6.0A";
        String actual = mathExpression.receiveText();
        Assert.assertEquals(expected, actual);
    }

    @Before
    public void initSwapTextTest() {
        testText = new CompositeText();
        CompositeText sentence = new CompositeText();
        sentence.setLevel(TextPart.SENTENCE);
        CompositeText firstLexeme = new CompositeText();
        firstLexeme.setLevel(TextPart.LEXEME);
        firstLexeme.add(new Symbol("f1 "));
        CompositeText secondLexeme = new CompositeText();
        secondLexeme.setLevel(TextPart.LEXEME);
        secondLexeme.add(new Symbol("f2 "));
        CompositeText thirdLexeme = new CompositeText();
        thirdLexeme.setLevel(TextPart.LEXEME);
        thirdLexeme.add(new Symbol("f3. "));
        sentence.add(firstLexeme);
        sentence.add(secondLexeme);
        sentence.add(thirdLexeme);
        testText.add(sentence);
    }

    @After
    public void unInitSwapTextTest() {
        testText = null;
    }

    @Test
    public void swapFirstLastLexemeTest() {
        String expected = "f3. f2 f1 ";
        operator.swapFirstLastLexeme(testText);
        String actual = testText.receiveText();
        Assert.assertEquals(expected, actual);
    }

    @Before
    public void sentenceSortTextTest() {
        sortText = new CompositeText();
        CompositeText sentence = new CompositeText();
        sentence.setLevel(TextPart.SENTENCE);
        CompositeText firstLexeme = new CompositeText();
        firstLexeme.setLevel(TextPart.LEXEME);
        CompositeText sentenceTwo = new CompositeText();
        sentenceTwo.setLevel(TextPart.SENTENCE);
        firstLexeme.add(new Symbol("f1. "));
        CompositeText secondLexeme = new CompositeText();
        secondLexeme.setLevel(TextPart.LEXEME);
        secondLexeme.add(new Symbol("f2 "));
        CompositeText thirdLexeme = new CompositeText();
        thirdLexeme.setLevel(TextPart.LEXEME);
        thirdLexeme.add(new Symbol("f3. "));
        sentence.add(firstLexeme);
        sentenceTwo.add(secondLexeme);
        sentenceTwo.add(thirdLexeme);
        sortText.add(sentenceTwo);
        sortText.add(sentence);
    }

    @After
    public void unInitSentenceSortTestText() {
        sortText = null;
    }

    @Test
    public void sentencesMinToMaxLexemesTest() {
        String expected = "f1. ";
        String expectedSecond = "f2 f3. ";
        List<IPart> actual = operator.sentencesMinToMaxLexemes(sortText);
        String firstActual = actual.get(0).receiveText();
        String secondActual = actual.get(1).receiveText();
        boolean isTrue = firstActual.equals(expected) && secondActual.equals(expectedSecond);
        Assert.assertTrue(isTrue);
    }

    @Before
    public void removeTestText() {
        removeText = new CompositeText();
        CompositeText sentence = new CompositeText();
        sentence.setLevel(TextPart.SENTENCE);
        CompositeText firstLexeme = new CompositeText();
        firstLexeme.setLevel(TextPart.LEXEME);
        firstLexeme.add(new Symbol("first "));
        CompositeText secondLexeme = new CompositeText();
        secondLexeme.setLevel(TextPart.LEXEME);
        secondLexeme.add(new Symbol("second "));
        CompositeText thirdLexeme = new CompositeText();
        thirdLexeme.setLevel(TextPart.LEXEME);
        thirdLexeme.add(new Symbol("third. "));
        sentence.add(firstLexeme);
        sentence.add(secondLexeme);
        sentence.add(thirdLexeme);
        removeText.add(sentence);
    }

    @After
    public void unInitRemoveTestText() {
        removeText = null;
    }

    @Test
    public void removeLexemesTest() {
        operator.removeLexemes(removeText, 's', 7);
        String expected = "first third. ";
        String actual = removeText.receiveText();
        Assert.assertEquals(expected, actual);
    }

}
