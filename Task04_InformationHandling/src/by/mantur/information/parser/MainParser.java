package by.mantur.information.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.mantur.information.composite.CompositeText;
import by.mantur.information.composite.Symbol;
import by.mantur.information.composite.TextPart;
import by.mantur.information.composite.IPart;
import by.mantur.information.exception.FormatException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainParser extends ChainParser {
	
	private static final String PARAGRAPH_REGEX = "(?s)\\t[\\p{Upper}+\\-(](.(?!\\r?\\n\\r?\\n))*.";
    private Logger logger = LogManager.getLogger(MainParser.class);
    private ChainParser sentenceParser;

    public MainParser() {
        sentenceParser = new ParseToSentence();
    }

    IPart parse(String text) throws FormatException {
        CompositeText paragraphs = new CompositeText();
        ArrayList<CompositeText> paragraphList = new ArrayList<>();
        Pattern paragraphPattern = Pattern.compile(PARAGRAPH_REGEX);
        Matcher paragraphMatcher = paragraphPattern.matcher(text);
        if (paragraphMatcher.groupCount() <= 0) {
            throw new FormatException("Wrong text format!");
        }
        while (paragraphMatcher.find()) {
            String paragraph = paragraphMatcher.group();
            CompositeText newParagraph = new CompositeText();
            newParagraph.setLevel(TextPart.PARAGRAPH);
            newParagraph.add(new Symbol("\t"));
            newParagraph.add(sentenceParser.parse(paragraph));
            paragraphList.add(newParagraph);
        }
        for (int i = 0; i < paragraphList.size() - 1; i++) {
            CompositeText current = paragraphList.get(i);
            current.add(new Symbol("\n"));
            current.add(new Symbol("\n"));
            paragraphs.add(current);
        }
        paragraphs.add(paragraphList.get(paragraphList.size() - 1));

        return paragraphs;
    }

    public IPart doChain(String text) {
        IPart result = null;
        try {
            result = parse(text);
        } catch (FormatException e) {
            logger.log(Level.ERROR, e);
        }
        return result;
    }

}
