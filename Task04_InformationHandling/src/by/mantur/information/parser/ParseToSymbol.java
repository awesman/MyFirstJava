package by.mantur.information.parser;

import java.util.Arrays;

import by.mantur.information.composite.CompositeText;
import by.mantur.information.composite.Symbol;
import by.mantur.information.composite.IPart;

class ParseToSymbol extends ChainParser {
	
	IPart parse(String string) {
        CompositeText symbols = new CompositeText();
        Arrays.stream(string.split("")).forEach((String s) -> {
            s = s.intern();
            symbols.add(new Symbol(s));
        });
        return symbols;
    }

}
