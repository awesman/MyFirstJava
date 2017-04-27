package by.mantur.XML.entity;

public class Candy {

	private String id;
	private String name;
	private int energy;
	private CandyType type;
	private Ingredient ingredients;
	private Calories value;
	private String production;

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public CandyType getType() {
		return type;
	}

	public void setType(CandyType type) {
		this.type = type;
	}

	public void setIngredients(Ingredient ingredients) {
		this.ingredients = ingredients;
	}

	public void setValue(Calories value) {
		this.value = value;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	@Override
	public String toString() {
		return '\n' + "Candy{" + "id='" + id + '\'' + ", name='"
				+ name + '\'' + ", energy=" + energy + ", type="
				+ type + ", ingredients: " + ingredients
				+ ", value: " + value + ", production='"
				+ production + '\'' + '}';
	}

}
