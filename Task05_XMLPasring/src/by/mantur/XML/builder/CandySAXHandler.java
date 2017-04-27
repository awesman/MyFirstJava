package by.mantur.XML.builder;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import by.mantur.XML.entity.*;


public class CandySAXHandler extends DefaultHandler {
	
	private List<Candy> candies;
    private Candy current = null;
    private CandySAXEnum currentEnum = null;
    private EnumSet<CandySAXEnum> withText;
    private Ingredient ingredients;
    private Caramel caramelIngredients;
    private Chocolate chocolateIngredients;
    private Cream creamyIngredients;
    private Attributes attrs;
    private Calories value;

    public CandySAXHandler() {
		candies = new ArrayList<>();
        withText = EnumSet.range(CandySAXEnum.NAME, CandySAXEnum.PRODUCTION);
    }

    public List<Candy> getCandies() {
        return candies;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        if ("candy".equals(localName)) {
            current = new Candy();
            current.setId(attrs.getValue(0));
        } else {
            this.attrs = attrs;
            CandySAXEnum temp = CandySAXEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("candy".equals(localName)) {
            current.setIngredients(ingredients);
            current.setValue(value);
            candies.add(current);
            caramelIngredients = null;
            chocolateIngredients = null;
            creamyIngredients = null;
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case ENERGY:
                    current.setEnergy(Integer.parseInt(s));
                    break;
                case TYPE:
                    current.setType(CandyType.valueOf(s.toUpperCase()));
                    break;
                case CHOCOLATE:
                    chocolateIngredients = new Chocolate();
                    ingredients = chocolateIngredients;
                    break;
                case CARAMEL:
                    caramelIngredients = new Caramel();
                    ingredients = caramelIngredients;
                    break;
                case CREAM:
                    creamyIngredients = new Cream();
                    ingredients = creamyIngredients;
                    break;
                case SUGAR:
                    ingredients.setSugar(Integer.parseInt(attrs.getValue(0)));
                    break;
                case COCOA:
                    if (caramelIngredients != null) {
                        caramelIngredients.setCocoa(Integer.parseInt(s));
                    } else {
                        chocolateIngredients.setCocoa(Integer.parseInt(s));
                    }
                    break;
                case NUT:
                    caramelIngredients.setNut(Integer.parseInt(s));
                    break;
                case CONDENSED_MILK:
                    creamyIngredients.setCondensedMilk(Integer.parseInt(attrs.getValue(0)));
                    break;
                case POWDERED_MILK:
                    chocolateIngredients.setPowderedMilk(Integer.parseInt(attrs.getValue(0)));
                    break;
                case BUTTER:
                    creamyIngredients.setButter(Integer.parseInt(s));
                    break;
                case VALUE:
                    value = new Calories();
                    break;
                case PROTEIN:
                    value.setProtein(Double.parseDouble(s));
                    break;
                case FAT:
                    value.setFat(Double.parseDouble(s));
                    break;
                case CARBOHYDRATE:
                    value.setCarbohydrate(Double.parseDouble(s));
                    break;
                case PRODUCTION:
                    current.setProduction(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }

}
