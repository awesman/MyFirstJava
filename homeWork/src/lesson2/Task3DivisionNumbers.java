package lesson2;

import java.util.Scanner;

public class Task3DivisionNumbers {

	
		public static void main(String[] args) {
			// Деление чисел
			Scanner scanner = new Scanner(System.in);
	        System.out.print("Введите первое число - ");
	        double var1 = scanner.nextDouble();
	        System.out.print("Введите второе число - ");
	        double var2 = scanner.nextDouble();
	        
	        if (var2==0){
	        	// Исключение деления на 0
	        	System.out.println("Деление на 0 невозможно");
	        }else{
	        	System.out.println(var1/var2);
	        }
	        scanner.close();

	}

}
