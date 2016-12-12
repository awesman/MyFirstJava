package classWork20DOMParser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class classWork {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		File f = new File("NewFile.xml");
		try {
			doc = builder.parse(f);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Element root = doc.getDocumentElement();
		System.out.println(root.getTagName());
		
		NodeList nList = root.getChildNodes();
		
		for (int i = 0; i < nList.getLength(); i++) {
			//System.out.println(nList.item(i).getNodeName());
			//System.out.println(nList.item(i).getNodeValue());
			
			if (nList.item(i) instanceof Element) {
				System.out.print(nList.item(i).getNodeName()+":");
				NodeList attributes = ((Element)nList.item(i)).getChildNodes();
				    System.out.print(" "+attributes.item(1).getChildNodes().item(0).getNodeValue());
					System.out.print(attributes.item(5).getChildNodes().item(0).getNodeValue()+",");
					System.out.print(" "+attributes.item(3).getChildNodes().item(0).getNodeValue());
					System.out.print(attributes.item(5).getChildNodes().item(0).getNodeValue());
				System.out.println();
			}
			
		}
	
	
	}

}
