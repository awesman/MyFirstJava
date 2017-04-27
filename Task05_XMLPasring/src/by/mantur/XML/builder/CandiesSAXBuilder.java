package by.mantur.XML.builder;

import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class CandiesSAXBuilder extends CandiesBuilder {
	
	private final static Logger LOGGER = LogManager.getLogger();
    private CandySAXHandler handler;
    private XMLReader reader;

    public CandiesSAXBuilder() {
        handler = new CandySAXHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "SAX builder error: {}", e);
        }
    }

    @Override
    public void buildSetCandies(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "SAX builder error: {}", e);
        } catch (IOException e) {
            LOGGER.log(Level.FATAL, "I/O error: {}", e);
            throw new RuntimeException("I/O error: " + e, e);
        }
        candies = handler.getCandies();
    }

}
