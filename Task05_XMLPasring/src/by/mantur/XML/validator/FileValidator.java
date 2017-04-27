package by.mantur.XML.validator;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

public class FileValidator {
	
	private static final Logger LOGGER = LogManager.getLogger();

    public static boolean validateXML(File xml, File xsd) {
        boolean isValid = true;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            Schema schema = factory.newSchema(xsd);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xml);
            validator.validate(source);
            LOGGER.log(Level.INFO, "{} is valid.", xml);
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "{} is not valid because: {}", xml, e);
            isValid = false;
        } catch (IOException e) {
            LOGGER.log(Level.FATAL, "I/O error: {}", e);
            throw new RuntimeException("I/O error: " + e, e);
        }
        return isValid;
    }

}
