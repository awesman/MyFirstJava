package test.by.mantur.task02.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import by.mantur.task02.io.DataReader;

public class DataReaderTest {
	
	private static File file;
    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();
    
    @BeforeClass
    public static void initTextFileReader() {
        new DataReader();
    }

    @AfterClass
    public static void unInit() {
    }
    
    @Before
    public void initAndFillFile() throws IOException {
        file = folder.newFile();
        FileWriter fw = new FileWriter(file);
        fw.write("First string\n");
        fw.write("Second string");
        fw.close();
    }
	
	 @Test
	    public void readFileToStringListTest() {
	        List<String> list = DataReader.readFile(file.getPath());
	        Assert.assertEquals("List hasn't expected strings: ", list);
	    }
	
	  @Test(expected = RuntimeException.class)
	    public void readFileToStringListWithWrongFileNameTest() {
	        DataReader.readFile("wrongPath");
	    }

}
