package test.by.epam.task01;
import org.junit.Test;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Triangle;

import static by.epam.task01.logic.TriangleActions.triangleSquare;
import static by.epam.task01.logic.TriangleActions.triangleExists;
import static by.epam.task01.logic.TriangleActions.trianglePerimeter;
import static org.junit.Assert.assertEquals;

/**
 * Created by Pavel on 17.02.2017.
 */
public class TriangleActionsTest {

    
    @Test
    public void existsTest() throws Exception {

        Point first=new Point("1","2");
        Point second=new Point("4","6");
        Point third=new Point("4","2");
        Triangle one=new Triangle(first,second,third);

        boolean expected =true;
        boolean result=triangleExists(one);
        assertEquals(expected,result);
    }
 
    @Test
    public void perimeterTest() throws Exception {

        Point first=new Point("1","2");
        Point second=new Point("4","6");
        Point third=new Point("4","2");
        Triangle one=new Triangle(first,second,third);

        double expected=12;
        double result=trianglePerimeter(one);
        assertEquals(expected,result,0.00001);
    }
   
    @Test
    public void areaTest() throws Exception {

        Point first=new Point("1","2");
        Point second=new Point("4","6");
        Point third=new Point("4","2");
        Triangle one=new Triangle(first,second,third);

        double expected =6;
        double result=triangleSquare(one);
        assertEquals(expected,result,0.00001);
    }

}