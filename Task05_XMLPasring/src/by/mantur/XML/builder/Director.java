package by.mantur.XML.builder;

import java.util.List;

import by.mantur.XML.entity.Candy;

public class Director {
	
	public static List<Candy> readXML(CandiesBuilder builder, String fileName) {
        builder.buildSetCandies(fileName);
        return builder.getCandies();
    }

}
