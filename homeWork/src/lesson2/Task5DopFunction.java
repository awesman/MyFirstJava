package lesson2;

public class Task5DopFunction {

	public static void main(String[] args) {
		// Вычисление фунцкии
		// x=0 нигде не исключаем, если было бы действия деления, просто пропустили бы этот шаг
		double x;
		double y;
		
		for (x=-4 ; x<=4 ; x+=0.5){
			y=2*x*x-5*x-8;
			
			System.out.println("При х="+x);
			System.out.println("Y="+y);
		}
	}
}
