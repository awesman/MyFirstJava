package test.by.mantur.information.reader;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import by.mantur.information.reader.DataReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

public class DataReaderTest {
	
	private static File tempFile;
    private static DataReader textReader;
    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @BeforeClass
    public static void initTextReader() {
        textReader = new DataReader();
    }

    @AfterClass
    public static void unInit() {
        textReader = null;
    }

    @Before
    public void createFile() throws IOException {
        tempFile = folder.newFile();
        FileWriter fw = new FileWriter(tempFile);
        fw.write("First string\n");
        fw.write("Second string");
        fw.close();
    }

    @Test
    public void readFileTest() {
        List<String> list = textReader.readFile(tempFile.getPath());
        String firstExpected = "First string";
        String secondExpected = "Second string";
        Assert.assertThat("List hasn't expected strings: ", list, hasItems(firstExpected, secondExpected));
    }

    @Test(expected = RuntimeException.class)
    public void readWrongFileTest() {
        textReader.readFile("wrongFilePath");
    }

}
