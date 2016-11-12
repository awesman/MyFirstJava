package lesson2;

import java.util.Scanner;

public class Task2DopFactorial {

	public static void main(String[] args) {
		// Вычисляем факториал числа
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число:");
        long f = scanner.nextLong();
        
        long t=1;
        
        for (long i=1; i<=f; i++){
        	t=t*i;
        }
        
       System.out.println(t); 
       
       scanner.close();

	}

}
