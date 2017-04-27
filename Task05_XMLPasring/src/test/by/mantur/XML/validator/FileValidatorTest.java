package test.by.mantur.XML.validator;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import by.mantur.XML.validator.FileValidator;

import java.io.File;
import java.io.IOException;

public class FileValidatorTest {
	
	   private static final String TEST_XML_PATH = "data/candies.xml";
	    private static final String TEST_XSD_PATH = "data/candies.xsd";

	    @Test
	    public void testValidate() throws IOException, SAXException {
	        File xml = new File(TEST_XML_PATH);
	        File xsd = new File(TEST_XSD_PATH);
	        Assert.assertTrue(FileValidator.validateXML(xml, xsd));
	    }

}
