package by.mantur.information.parser;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.mantur.information.composite.CompositeText;
import by.mantur.information.composite.Symbol;
import by.mantur.information.composite.TextPart;
import by.mantur.information.composite.IPart;
import by.mantur.information.exception.FormatException;


class ParseToWordAndPunctuation extends ChainParser{
	
	private static final String WORD_OR_PUNCTUATION_REGEX = "(\\w+|\\p{Punct}+)";
    private static final String WORD_REGEX = "\\w+";
    private static final String PUNCTUATION_REGEX = "\\p{Punct}+";
    private static final String WORD_WITH_PUNCTUATION_REGEX = "\\w+\\p{Punct}+";
    private static final String PUNCTUATION_WITH_WORD_REGEX = "\\p{Punct}+\\w+";
    private ChainParser symbolParser;

    ParseToWordAndPunctuation() {
        symbolParser = new ParseToSymbol();
    }

    IPart parse(String lexeme) throws FormatException {
        Pattern wordAndPunctuationPattern = Pattern.compile(WORD_OR_PUNCTUATION_REGEX);
        Pattern wordPattern = Pattern.compile(WORD_REGEX);
        Pattern punctuationPattern = Pattern.compile(PUNCTUATION_REGEX);
        Matcher matcher = wordAndPunctuationPattern.matcher(lexeme);
        CompositeText wordsAndPunctuation = new CompositeText();
        boolean spaceNeeded = !Pattern.matches(WORD_WITH_PUNCTUATION_REGEX, lexeme);
        boolean spaceAfterPunctuationNeeded = !Pattern.matches(PUNCTUATION_WITH_WORD_REGEX, lexeme);
        while (matcher.find()) {
            String current = matcher.group();
            Matcher wordMatcher = wordPattern.matcher(current);
            Matcher punctuationMatcher = punctuationPattern.matcher(current);
            if (wordMatcher.find()) {
                String wordString = matcher.group();
                CompositeText word = new CompositeText();
                word.setLevel(TextPart.WORD);
                symbolParser.parse(wordString).receiveParts().forEach(word::add);
                wordsAndPunctuation.add(word);
                if (spaceNeeded) {
                    wordsAndPunctuation.add(new Symbol(" "));
                }
            } else if (punctuationMatcher.find()) {
                String punctuationString = matcher.group();
                CompositeText punctuation = new CompositeText();
                punctuation.setLevel(TextPart.PUNCTUATION);
                symbolParser.parse(punctuationString).receiveParts().forEach(punctuation::add);
                wordsAndPunctuation.add(punctuation);
                if (spaceAfterPunctuationNeeded) {
                    wordsAndPunctuation.add(new Symbol(" "));
                }
            }
        }
        return wordsAndPunctuation;
    }

}
