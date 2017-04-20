package by.mantur.information.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.mantur.information.composite.CompositeText;
import by.mantur.information.composite.Symbol;
import by.mantur.information.composite.TextPart;
import by.mantur.information.composite.IPart;
import by.mantur.information.exception.FormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ParseToLexemeAndMath extends ChainParser{
	
	private static final String LINEFEED_REGEX = "\\s+";
    private static final String LEXEME_REGEX = "[\\w\\p{Punct}]*";
    private static final String MATH_REGEX = "(?:\\s(?:[\\d+\\-*/(]|[ij])" +
            "(?:[\\d+\\-*/(\\s)]|[ij\\s)])*(?!\\p{Alpha}))";
    private static final String MATH_OR_LEXEME_REGEX = "(?:(?:\\s(?:[\\d+\\-*\\/(]|[ij])(?:[\\d+\\-*\\/(\\s\\)]" +
            "|[ij\\s\\)])*(?!\\p{Alpha}))|((?<=\\s)[\\w\\p{Punct}]+)|( ?[\\n] +))";
    private static Logger logger = LogManager.getLogger(ParseToLexemeAndMath.class);
    private ChainParser symbolParser;
    private ChainParser wordAndPunctuationParser;

    ParseToLexemeAndMath() {
        symbolParser = new ParseToSymbol();
        wordAndPunctuationParser = new ParseToWordAndPunctuation();
    }

    IPart parse(String sentence) throws FormatException {
        Pattern textAndLexeme = Pattern.compile(MATH_OR_LEXEME_REGEX);
        Matcher matcher = textAndLexeme.matcher(sentence);
        CompositeText mathAndLexeme = new CompositeText();
        while (matcher.find()) {
            String current = matcher.group();
            if (Pattern.matches(MATH_REGEX, current)) {
                CompositeText math = new CompositeText();
                math.setLevel(TextPart.MATH);
                symbolParser.parse(current.trim()).receiveParts().forEach(math::add);
                mathAndLexeme.add(math);
                mathAndLexeme.add(new Symbol(" "));
            } else if (Pattern.matches(LEXEME_REGEX, current)) {
                CompositeText lexeme = new CompositeText();
                lexeme.setLevel(TextPart.LEXEME);
                lexeme.add(wordAndPunctuationParser.parse(current));
                mathAndLexeme.add(lexeme);
            } else if (Pattern.matches(LINEFEED_REGEX, current)) {
                mathAndLexeme.add(new Symbol("\n"));
            } else {
                logger.log(Level.WARN, "Wrong sentence.Won't be parsed : " + current);
            }
        }
        return mathAndLexeme;
    }

}
