package lesson2;

import java.util.Scanner;

public class Task2CompareNumbers {

	public static void main(String[] args) {
		// Программа сравнения чисел

		 Scanner scanner = new Scanner(System.in);
	        System.out.print("Введите первое число - ");
	        double var1 = scanner.nextDouble();
	        System.out.print("Введите второе число - ");
	        double var2 = scanner.nextDouble();

	       



	        if (var1 > var2){
	        	System.out.println(var1+" больше "+var2);	        	       	
	        }else{
	        	// Учтен случай равенства вводимых чисел
	        	if(var1==var2){
	        		System.out.println(var1+" равно "+var2);
	        	}else{
	        	System.out.println(var2+" больше "+var1);
	        	}
	        }
	         
	        scanner.close();
	}

}
