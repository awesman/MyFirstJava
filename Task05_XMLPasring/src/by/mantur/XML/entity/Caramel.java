package by.mantur.XML.entity;

public class Caramel extends Ingredient{
	
	private int cocoa;
    private int nut;

    public void setCocoa(int cocoa) {
        this.cocoa = cocoa;
    }

    public void setNut(int nut) {
        this.nut = nut;
    }

    @Override
    public String toString() {
        return super.toString() + " cocoa=" + cocoa +
                ", nut=" + nut;
    }

}
