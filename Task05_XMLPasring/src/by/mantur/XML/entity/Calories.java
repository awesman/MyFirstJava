package by.mantur.XML.entity;

public class Calories {
	
	private double protein;
    private double fat;
    private double carbohydrate;

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        return "protein=" + protein +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate;
    }

}
