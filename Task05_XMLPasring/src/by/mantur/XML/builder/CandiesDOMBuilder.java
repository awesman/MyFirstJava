package by.mantur.XML.builder;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.mantur.XML.entity.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CandiesDOMBuilder extends CandiesBuilder{
	
	private final static Logger LOGGER = LogManager.getLogger();
    private DocumentBuilder docBuilder;

    public CandiesDOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.log(Level.ERROR, "Parser configuration error: {}", e);
        }
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

    private static boolean hasElement(Element element, String elementName) {
        if (element.getElementsByTagName(elementName).getLength() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public void buildSetCandies(String fileName) {
        try {
            Document doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList candiesList = root.getElementsByTagName("candy");
            for (int i = 0; i < candiesList.getLength(); i++) {
                Element candyElement = (Element) candiesList.item(i);
                Candy candy = buildCandy(candyElement);
                candies.add(candy);
            }
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "File error or I/O error: {}", e);
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "Parsing failure: {}", e);
        }
    }

    private Candy buildCandy(Element candyElement) {
        Candy candy = new Candy();
        candy.setId(candyElement.getAttribute("id"));
        candy.setName(getElementTextContent(candyElement, "name"));
        Integer energy = Integer.parseInt(getElementTextContent(candyElement, "energy"));
        candy.setEnergy(energy);
        candy.setType(CandyType.valueOf(getElementTextContent(candyElement, "type").toUpperCase()));
        Element sugarElement = (Element) candyElement.getElementsByTagName("sugar").item(0);
        int sugar = Integer.parseInt(sugarElement.getAttribute("weight"));
        if (hasElement(candyElement, "chocolate_ingredients")) {
            Chocolate ingredients = new Chocolate();
            ingredients.setCocoa(Integer.parseInt(getElementTextContent(candyElement, "cocoa")));
            Element powderedMilkElement = (Element) candyElement.getElementsByTagName("powdered_milk").item(0);
            ingredients.setPowderedMilk(Integer.parseInt(powderedMilkElement.getAttribute("weight")));
            ingredients.setSugar(sugar);
            candy.setIngredients(ingredients);
        } else if (hasElement(candyElement, "caramel_ingredients")) {
            Caramel ingredients = new Caramel();
            ingredients.setCocoa(Integer.parseInt(getElementTextContent(candyElement, "cocoa")));
            ingredients.setNut(Integer.parseInt(getElementTextContent(candyElement, "nut")));
            ingredients.setSugar(sugar);
            candy.setIngredients(ingredients);
        } else {
            Cream ingredients = new Cream();
            ingredients.setButter(Integer.parseInt(getElementTextContent(candyElement, "butter")));
            Element condensedMilkElement = (Element) candyElement.getElementsByTagName("condensed_milk").item(0);
            ingredients.setCondensedMilk(Integer.parseInt(condensedMilkElement.getAttribute("weight")));
            ingredients.setSugar(sugar);
            candy.setIngredients(ingredients);
        }
        Calories value = new Calories();
        value.setProtein(Double.parseDouble(getElementTextContent(candyElement, "protein")));
        value.setFat(Double.parseDouble(getElementTextContent(candyElement, "fat")));
        value.setCarbohydrate(Double.parseDouble(getElementTextContent(candyElement, "carbohydrate")));
        candy.setValue(value);
        candy.setProduction(getElementTextContent(candyElement, "production"));
        return candy;
    }

}
