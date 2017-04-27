package by.mantur.XML.entity;

public class Chocolate extends Ingredient {

	private int powderedMilk;
	private int cocoa;

	public void setPowderedMilk(int powderedMilk) {
		this.powderedMilk = powderedMilk;
	}

	public void setCocoa(int cocoa) {
		this.cocoa = cocoa;
	}

	@Override
	public String toString() {
		return super.toString() + " powderedMilk=" + powderedMilk
				+ ", cocoa=" + cocoa;
	}

}
