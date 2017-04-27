package by.mantur.XML.builder;

import java.util.ArrayList;
import java.util.List;

import by.mantur.XML.entity.Candy;

public abstract class CandiesBuilder {
	
	protected List<Candy> candies;

    public CandiesBuilder() {
        candies = new ArrayList<>();
    }

    public List<Candy> getCandies() {
        return candies;
    }

    abstract public void buildSetCandies(String fileName);

}
