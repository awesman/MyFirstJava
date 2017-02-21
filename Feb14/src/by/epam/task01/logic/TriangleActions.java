package by.epam.task01.logic;

import static java.lang.Math.sqrt;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Triangle;

public class TriangleActions {

    public static boolean triangleExists(Triangle one) {
    	
    	double ab=PointActions.distanceTo(one.getA(), one.getB());
    	double bc=PointActions.distanceTo(one.getB(), one.getC());
    	double ca=PointActions.distanceTo(one.getC(), one.getA());
        return (ab < (bc + ca)) &&
                (bc < (ab+ca)) &&
                (ca < ( ab+bc));
    }

    public static double trianglePerimeter(Triangle one) {
        if (triangleExists(one)) {
        	double ab=PointActions.distanceTo(one.getA(), one.getB());
        	double bc=PointActions.distanceTo(one.getB(), one.getC());
        	double ca=PointActions.distanceTo(one.getC(), one.getA());
            return ab + bc + ca;
        } else {
            throw new IllegalStateException("Triangle does not exists");
        }
    }

    public static double triangleSquare(Triangle one) {
        if (triangleExists(one)) {
            double p = (trianglePerimeter(one)) / 2;
            double ab=PointActions.distanceTo(one.getA(), one.getB());
        	double bc=PointActions.distanceTo(one.getB(), one.getC());
        	double ca=PointActions.distanceTo(one.getC(), one.getA());
            return sqrt(p * (p - ab) * (p - bc) * (p - ca));
        } else {
            throw new IllegalStateException("Triangle does not exists");
        }
    }
    
    public static boolean angleRectangularExists(Triangle one){
    	double ab=PointActions.distanceTo(one.getA(), one.getB());
    	double bc=PointActions.distanceTo(one.getB(), one.getC());
    	double ca=PointActions.distanceTo(one.getC(), one.getA());
    	
    	
    	if(ab>bc && ab>ca){
    		return ab==Math.sqrt(Math.pow(bc, 2)+Math.pow(ca, 2));
    	}else if(bc>ab && bc>ca){
    		return bc==Math.sqrt(Math.pow(ab, 2)+Math.pow(ca, 2));    		
    	}else if(ca>bc && ca> ab){
    		return ca==Math.sqrt(Math.pow(bc, 2)+Math.pow(ab, 2));
    	}else {
            throw new IllegalStateException("Triangle does not exists");
        }   	
    }
    
    public static Triangle createTriangle(Point p1, Point p2, Point p3) {
		return new Triangle(p1, p2, p3);
	}
    
}
