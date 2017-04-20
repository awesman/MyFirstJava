package by.mantur.information.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.mantur.information.composite.CompositeText;
import by.mantur.information.composite.TextPart;
import by.mantur.information.composite.IPart;
import by.mantur.information.exception.FormatException;

class ParseToSentence extends ChainParser {
	
    private static final String SENTENCE_REGEX = "(?s)\\s[\\p{Upper}+\\-(](.(?!\\.))*..";
    private ChainParser mathAndLexemeParser;

    ParseToSentence() {
        mathAndLexemeParser = new ParseToLexemeAndMath();
    }

    IPart parse(String paragraph) throws FormatException {
        CompositeText sentences = new CompositeText();
        Pattern sentencePattern = Pattern.compile(SENTENCE_REGEX);
        Matcher sentenceMatcher = sentencePattern.matcher(paragraph);
        while (sentenceMatcher.find()) {
            CompositeText sentence = new CompositeText();
            sentence.setLevel(TextPart.SENTENCE);
            String current = sentenceMatcher.group();
            sentence.add(mathAndLexemeParser.parse(current));
            sentences.add(sentence);
        }
        return sentences;
    }
	

}
