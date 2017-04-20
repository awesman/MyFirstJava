package by.mantur.information.parser;

import by.mantur.information.composite.IPart;
import by.mantur.information.exception.FormatException;

public abstract class ChainParser {
	
	abstract IPart parse(String text) throws FormatException;

}
