package by.mantur.information.interpreter;

import java.util.ArrayDeque;

public class Context {
	
	private int i;
    private int j;
    private ArrayDeque<String> contextValues = new ArrayDeque<>();

    public Context(int i, int j) {
        this.i = i;
        this.j = j;
    }

     int getI() {
        return i;
    }

     int getJ() {
        return j;
    }

    String popValue() {
        return contextValues.pop();
    }

    void pushValue(String value) {
        this.contextValues.push(value);
    }

     int addAndGetI() {
        return ++i;
    }

     int getAndAddI() {
        int result = i;
        i++;
        return result;
    }

     int calculateAndGetI() {
        return --i;
    }

     int getAndCalculateI() {
        int result = i;
        i--;
        return result;
    }

     int addAndGetJ() {
        return ++j;
    }

     int getAndAddJ() {
        int result = j;
        j++;
        return result;
    }

     int calculateAndGetJ() {
        return --j;
    }

     int getAndCalculateJ() {
        int result = j;
        j--;
        return result;
    }

    public void resetContext() {
        contextValues.clear();
    }

}
